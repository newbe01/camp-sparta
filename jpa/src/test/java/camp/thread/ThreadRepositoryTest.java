package camp.thread;

import camp.channel.Channel;
import camp.channel.ChannelRepository;
import java.util.Set;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest
@Transactional
@Rollback(value = false)
class ThreadRepositoryTest {

    @Autowired
    ThreadRepository threadRepository;

    @Autowired
    ChannelRepository channelRepository;

    @Test
    void insertSelectTreadTest() {
        Channel newChannel = Channel.builder().name("new-group").build();
        Thread newThread = Thread.builder().message("new-message").build();
        Thread newThread2 = Thread.builder().message("new-message2").build();
        newThread.setChannel(newChannel);
        newThread2.setChannel(newChannel);

        Channel channel = channelRepository.save(newChannel);
        Thread savedThread = threadRepository.save(newThread);
        Thread savedThread2 = threadRepository.save(newThread2);

        Thread thread = threadRepository.findById(savedThread.getId()).get();
        assert thread.getChannel().getName().equals(newChannel.getName());

        Channel result = channelRepository.findById(channel.getId()).get();
        assert result.getThreads().containsAll(Set.of(savedThread, savedThread2));
    }

    @Test
    void deleteThreadByOrphanRemovalTest() {
        Channel newChannel = Channel.builder().name("new-group").build();
        Thread newThread = Thread.builder().message("new-message").build();
        Thread newThread2 = Thread.builder().message("new-message2").build();
        newThread.setChannel(newChannel);
        newThread2.setChannel(newChannel);

        Channel channel = channelRepository.save(newChannel);
        Thread savedThread = threadRepository.save(newThread);
        Thread savedThread2 = threadRepository.save(newThread2);

//        Thread thread = threadRepository.selectThread(savedThread.getId());
//        assert thread.getChannel().getName().equals(newChannel.getName());

        Channel result = channelRepository.findById(channel.getId()).get();
        result.getThreads().remove(savedThread);

//        channelRepository.insertChannel(result);

//        assert result.getThreads().containsAll(Set.of(savedThread, savedThread2));
    }
}