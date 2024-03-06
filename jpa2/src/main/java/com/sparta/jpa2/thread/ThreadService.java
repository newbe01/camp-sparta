package com.sparta.jpa2.thread;

import com.sparta.jpa2.channel.Channel;
import com.sparta.jpa2.common.PageDTO;
import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ThreadService {

    List<Thread> getChannelThreadList(Channel channel);

    Thread save(Thread thread);

    Page<Thread> selectMentionThreadList(Long userId, PageDTO pageDTO);

}
