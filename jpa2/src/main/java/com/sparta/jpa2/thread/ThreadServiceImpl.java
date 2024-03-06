package com.sparta.jpa2.thread;

import com.mysema.commons.lang.IteratorAdapter;
import com.querydsl.core.types.Predicate;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.sparta.jpa2.channel.Channel;
import com.sparta.jpa2.user.User;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class ThreadServiceImpl implements ThreadService{

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


}
