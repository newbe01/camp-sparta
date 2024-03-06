package com.sparta.jpa2.thread;

import com.sparta.jpa2.channel.Channel;
import com.sparta.jpa2.channel.Channel.Type;
import com.sparta.jpa2.channel.ChannelRepository;
import com.sparta.jpa2.comment.Comment;
import com.sparta.jpa2.comment.CommentRepository;
import com.sparta.jpa2.common.PageDTO;
import com.sparta.jpa2.mention.ThreadMention;
import com.sparta.jpa2.user.User;
import com.sparta.jpa2.user.UserRepository;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
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

    @Autowired
    CommentRepository commentRepository;

    @Test
    void getMentionedThreadList() {
        User user = User.builder().username("test").password("test").build();
        User saveUser = userRepository.save(user);

        Thread thread = Thread.builder().message("test").build();
//        thread.addMention(user);
        threadService.save(thread);

        Thread thread2 = Thread.builder().message("test2").build();
        thread.addMention(saveUser);
        threadService.save(thread2);

        List<Thread> result = saveUser.getThreadMentions().stream().map(ThreadMention::getThread)
            .toList();
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

    @Test
    void selectMentionedThreadListTest() {
        // given
        var user = getTestUser("1", "1");
        var user2 = getTestUser("2", "2");
        var user3 = getTestUser("3", "3");
        var user4 = getTestUser("3", "4");
        var newChannel = Channel.builder().name("c1").type(Type.PUBLIC).build();
        var savedChannel = channelRepository.save(newChannel);
        var thread2 = getTestThread("", savedChannel, user
            , user2, "e2", user3, "c2", user4, "ce2");
        var thread1 = getTestThread("message", savedChannel, user
            , user2, "e1", user3, "c1", user4, "ce1");

        // when
        var pageDTO = PageDTO.builder().currentPage(1).size(100).build();
        var mentionedThreadList = threadService.selectMentionThreadList(user.getId(), pageDTO);

        // then
        assert mentionedThreadList.getTotalElements() == 2;
    }

    private User getTestUser(String username, String password) {
        var newUser = User.builder().username(username).password(password).build();
        return userRepository.save(newUser);
    }

    private Comment getTestComment(User user, String message) {
        var newComment = Comment.builder().message(message).build();
        newComment.setUser(user);
        return commentRepository.save(newComment);
    }

    private Thread getTestThread(String message, Channel savedChannel) {
        var newThread = Thread.builder().message(message).build();
        newThread.setChannel(savedChannel);
        return threadService.save(newThread);
    }

    private Thread getTestThread(String message, Channel channel, User mentionedUser) {
        var newThread = getTestThread(message, channel);
        newThread.addMention(mentionedUser);
        return threadService.save(newThread);
    }

    private Thread getTestThread(String message, Channel channel, User mentionedUser,
        User emotionUser, String emotionValue) {
        var newThread = getTestThread(message, channel, mentionedUser);
        newThread.addEmotion(emotionUser, emotionValue);
        return threadService.save(newThread);
    }

    private Thread getTestThread(String message, Channel channel, User mentionedUser,
        User emotionUser, String emotionValue, User commentUser, String commentMessage) {
        var newThread = getTestThread(message, channel, mentionedUser, emotionUser, emotionValue);
        newThread.addComment(getTestComment(commentUser, commentMessage));
        return threadService.save(newThread);
    }

    private Thread getTestThread(String message, Channel channel, User mentionedUser,
        User emotionUser, String emotionValue, User commentUser, String commentMessage,
        User commentEmotionUser, String commentEmotionValue) {
        var newThread = getTestThread(message, channel, mentionedUser, emotionUser, emotionValue,
            commentUser, commentMessage);
        newThread.getComments()
            .forEach(comment -> comment.addEmotion(commentEmotionUser, commentEmotionValue));
        return threadService.save(newThread);
    }
}