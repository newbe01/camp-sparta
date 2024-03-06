package com.sparta.jpa2.thread;

import com.sparta.jpa2.channel.Channel;
import com.sparta.jpa2.user.User;
import java.util.List;

public interface ThreadService {

    List<Thread> getChannelThreadList(Channel channel);

    Thread save(Thread thread);

}
