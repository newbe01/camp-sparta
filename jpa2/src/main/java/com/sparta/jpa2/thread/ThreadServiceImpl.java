package com.sparta.jpa2.thread;

import com.mysema.commons.lang.IteratorAdapter;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.sparta.jpa2.channel.Channel;
import com.sparta.jpa2.common.PageDTO;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class ThreadServiceImpl implements ThreadService {

    private final ThreadRepository threadRepository;

    @Override
    public List<Thread> getChannelThreadList(Channel channel) {
        QThread thread = QThread.thread;

        BooleanExpression predicate = thread.channel.eq(channel).and(thread.message.isNotEmpty());

        Iterable<Thread> threads = threadRepository.findAll(predicate);
        return IteratorAdapter.asList(threads.iterator());
    }

    @Override
    public Thread save(Thread thread) {
        return threadRepository.save(thread);
    }

    @Override
    public Page<Thread> selectMentionThreadList(Long userId, PageDTO pageDTO) {
        ThreadSearchCond cond = ThreadSearchCond.builder().mentionedUserId(userId).build();
        return threadRepository.search(cond, pageDTO.toPageable());
    }

}
