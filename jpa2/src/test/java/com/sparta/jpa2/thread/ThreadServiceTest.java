package com.sparta.jpa2.thread;

import static org.junit.jupiter.api.Assertions.*;

import com.sparta.jpa2.channel.Channel;
import com.sparta.jpa2.channel.Channel.Type;
import com.sparta.jpa2.channel.ChannelRepository;
import com.sparta.jpa2.mention.Mention;
import com.sparta.jpa2.user.User;
import com.sparta.jpa2.user.UserRepository;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ThreadServiceTest {

    @Autowired
    UserRepository userRepository;

    @Autowired
    ChannelRepository channelRepository;

    @Autowired
    ThreadService threadService;

    @Test
    void getMentionedThreadList() {
        User user = User.builder().username("test").password("test").build();
        User saveUser = userRepository.save(user);

        Thread thread = Thread.builder().message("test").build();
        thread.addMention(user);
        threadService.save(thread);

        Thread thread2 = Thread.builder().message("test2").build();
        thread.addMention(saveUser);
        threadService.save(thread2);

        List<Thread> result = saveUser.getMentions().stream().map(Mention::getThread).toList();
//        List<Thread> result = threadService.getMentionedThreadList(saveUser);

        System.out.println("result = " + result.size());
    }

    @Test
    void getNotEmptyThreadList() {
        Channel channel = Channel.builder().name("test").type(Type.PUBLIC).build();
        Channel saveChannel = channelRepository.save(channel);

        Thread thread = Thread.builder().message("test").build();
        thread.setChannel(channel);
        threadService.save(thread);

        Thread thread2 = Thread.builder().message("").build();
        thread.setChannel(channel);
        threadService.save(thread2);

        List<Thread> result = threadService.getChannelThreadList(saveChannel);

        System.out.println("result = " + result.size());
    }
}