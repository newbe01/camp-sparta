package com.sparta.jpa2.thread;

import static com.sparta.jpa2.thread.QThread.thread;

import com.querydsl.core.types.Expression;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.core.types.dsl.Wildcard;
import com.querydsl.jpa.impl.JPAQuery;
import com.querydsl.jpa.impl.JPAQueryFactory;
import java.util.List;
import java.util.Objects;
import lombok.RequiredArgsConstructor;
import org.hibernate.Hibernate;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.support.PageableExecutionUtils;

@RequiredArgsConstructor
public class ThreadRepositoryQueryImpl implements ThreadRepositoryQuery {

    private final JPAQueryFactory factory;

    @Override
    public Page<Thread> search(ThreadSearchCond cond, Pageable pageable) {
        JPAQuery<Thread> query = query(thread, cond)
            .offset(pageable.getOffset())
            .limit(pageable.getPageSize());

        query.orderBy(thread.mentions.any().createdAt.desc());

        List<Thread> threads = query.fetch();
        long totalSize = countQuery(cond).fetch().get(0);

        threads.stream()
            .map(Thread::getComments)
            .forEach(comments -> comments
                .forEach(comment -> Hibernate.initialize(comment.getEmotions())));

        return PageableExecutionUtils.getPage(threads, pageable, () -> totalSize);
    }

    private <T> JPAQuery<T> query(Expression<T> expr, ThreadSearchCond cond) {
        return factory.select(expr)
            .from(thread)
            .leftJoin(thread.channel).fetchJoin()
            .leftJoin(thread.emotions).fetchJoin()
            .leftJoin(thread.comments).fetchJoin()
            .leftJoin(thread.mentions).fetchJoin()
            .where(
                channelIdEq(cond.getChannelId()),
                mentionedUserIdEq(cond.getMentionedUserId())
            );
    }


    private JPAQuery<Long> countQuery(ThreadSearchCond cond) {
        return factory.select(Wildcard.count)
            .from(thread)
            .where(
                channelIdEq(cond.getChannelId()),
                mentionedUserIdEq(cond.getMentionedUserId())
            );
    }

    private BooleanExpression channelIdEq(Long channelId) {
        return Objects.nonNull(channelId) ? thread.channel.id.eq(channelId) : null;
    }

    private BooleanExpression mentionedUserIdEq(Long mentionedUserId) {
        return Objects.nonNull(mentionedUserId) ? thread.mentions.any().user.id.eq(mentionedUserId)
            : null;
    }
}
