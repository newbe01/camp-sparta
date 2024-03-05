package camp.user.userChannel;

import camp.channel.Channel;
import camp.channel.ChannelRepository;
import camp.user.User;
import camp.user.UserRepository;
import camp.userChannel.UserChannel;
import camp.userChannel.UserChannelRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest
@Transactional
@Rollback(value = false)
class UserChannelRepositoryTest {

    @Autowired
    UserRepository userRepository;

    @Autowired
    ChannelRepository channelRepository;

//    @Autowired
//    UserChannelRepository userChannelRepository;

    @Test
    void userJoinChannelTest() {
        Channel newChannel = Channel.builder().name("new-group").build();
        User newUser = User.builder().username("new-user").password("new-password").build();
        UserChannel newUserChannel = newChannel.joinUser(newUser);

        Channel savedChannel = channelRepository.insertChannel(newChannel);
        User savedUser = userRepository.insertUser(newUser);
//        UserChannel savedUc = userChannelRepository.insertUserChannel(newUserChannel);

        Channel channel = channelRepository.selectChannel(savedChannel.getId());
        assert channel.getUserChannels().stream()
            .map(UserChannel::getChannel)
            .map(Channel::getName)
            .anyMatch(name -> name.equals(newChannel.getName()));
    }

    @Test
    void userJoinChannelWithCascadeTest() {
        Channel newChannel = Channel.builder().name("new-group").build();
        User newUser = User.builder().username("new-user").password("new-password").build();
        newChannel.joinUser(newUser);

        Channel savedChannel = channelRepository.insertChannel(newChannel);
        User savedUser = userRepository.insertUser(newUser);

        Channel channel = channelRepository.selectChannel(savedChannel.getId());
        assert channel.getUserChannels().stream()
            .map(UserChannel::getChannel)
            .map(Channel::getName)
            .anyMatch(name -> name.equals(newChannel.getName()));
    }
}