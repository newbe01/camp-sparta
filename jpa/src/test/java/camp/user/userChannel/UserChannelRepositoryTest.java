package camp.user.userChannel;

import camp.channel.Channel;
import camp.channel.ChannelRepository;
import camp.common.PageDTO;
import camp.user.User;
import camp.user.UserRepository;
import camp.userChannel.UserChannel;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.jaxb.SpringDataJaxb.PageDto;
import org.springframework.data.jpa.domain.JpaSort;
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

        Channel savedChannel = channelRepository.save(newChannel);
        User savedUser = userRepository.save(newUser);
//        UserChannel savedUc = userChannelRepository.insertUserChannel(newUserChannel);

        Channel channel = channelRepository.findById(savedChannel.getId()).get();
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

        Channel savedChannel = channelRepository.save(newChannel);
        User savedUser = userRepository.save(newUser);

        Channel channel = channelRepository.findById(savedChannel.getId()).get();
        assert channel.getUserChannels().stream()
            .map(UserChannel::getChannel)
            .map(Channel::getName)
            .anyMatch(name -> name.equals(newChannel.getName()));
    }

    @Test
    void userCustomFieldSortingTest() {
        User newUser = User.builder().username("new-user").password("new-password1").build();
        User newUser2 = User.builder().username("new-user").password("new-password2").build();
        User newUser3 = User.builder().username("new-user").password("3").build();
        userRepository.save(newUser);
        userRepository.save(newUser2);
        userRepository.save(newUser3);

        List<User> result = userRepository.findByUsernameCustomField("new-user", Sort.by("custom_field").descending());
        List<User> result2 = userRepository.findByUsername("new-user", JpaSort.unsafe("LENGTH(password)"));

        assert result.get(0).getPassword().equals(newUser2.getPassword());
        assert result2.get(0).getPassword().equals(newUser3.getPassword());
    }

    @Test
    void pageDTOTest() {
        User newUser = User.builder().username("new-user").password("new-password1").build();
        User newUser2 = User.builder().username("new-user").password("new-password2").build();
        User newUser3 = User.builder().username("new-user").password("3").build();
        userRepository.save(newUser);
        userRepository.save(newUser2);
        userRepository.save(newUser3);

        PageDTO pageDTO = PageDTO.builder().currentPage(1).size(2).sortBy("password").build();
        Page<User> result = userRepository.findAll(pageDTO.toPageable());

        assert result.getContent().size() == 2;
    }
}
