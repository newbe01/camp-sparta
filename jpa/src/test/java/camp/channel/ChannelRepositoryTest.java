package camp.channel;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest
@Transactional
@Rollback(value = false)
class ChannelRepositoryTest {

    @Autowired
    ChannelRepository channelRepository;

    @Test
    void InsertSelectChannelTest() {
        Channel newChannel = Channel.builder().name("new-group").build();

        Channel savedChannel = channelRepository.insertChannel(newChannel);

        Channel channel = channelRepository.selectChannel(savedChannel.getId());
        assert channel.getId().equals(savedChannel.getId());
    }
}