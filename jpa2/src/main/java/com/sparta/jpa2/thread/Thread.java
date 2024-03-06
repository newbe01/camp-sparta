package com.sparta.jpa2.thread;

import com.sparta.jpa2.channel.Channel;
import com.sparta.jpa2.comment.Comment;
import com.sparta.jpa2.common.TimeStamp;
import com.sparta.jpa2.emotion.ThreadEmotion;
import com.sparta.jpa2.mention.ThreadMention;
import com.sparta.jpa2.user.User;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import java.util.LinkedHashSet;
import java.util.Set;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Entity
public class Thread extends TimeStamp {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(length = 500)
    private String message;

    @Builder
    public Thread(String message) {
        this.message = message;
    }

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "channel_id")
    private Channel channel;

    @Builder.Default
    @OneToMany(mappedBy = "thread", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Comment> comments = new LinkedHashSet<>();

    @Builder.Default
    @OneToMany(mappedBy = "thread", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<ThreadMention> mentions = new LinkedHashSet<>();

    @Builder.Default
    @OneToMany(mappedBy = "thread", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<ThreadEmotion> emotions = new LinkedHashSet<>();

    public void setUser(User user) {
        this.user = user;
    }

    public void setChannel(Channel channel) {
        this.channel = channel;
        channel.addThread(this);
    }

    public void addMention(User user) {
        var mention = ThreadMention.builder().user(user).thread(this).build();
        this.mentions.add(mention);
        user.getThreadMentions().add(mention);
    }

    public void addComment(Comment comment) {
        this.comments.add(comment);
        comment.setThread(this);
    }

    public void addEmotion(User user, String body) {
        var emotion = ThreadEmotion.builder().user(user).thread(this).body(body).build();
        this.emotions.add(emotion);
    }

}
