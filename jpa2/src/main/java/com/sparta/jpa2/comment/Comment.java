package com.sparta.jpa2.comment;

import com.sparta.jpa2.emotion.CommentEmotion;
import com.sparta.jpa2.mention.CommentMention;
import com.sparta.jpa2.thread.Thread;
import com.sparta.jpa2.user.User;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
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
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id", nullable = false)
    private Long id;

    private String message;

    @ManyToOne
    @JoinColumn(name = "thread_id")
    private Thread thread;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @Builder.Default
    @OneToMany(mappedBy = "comment", cascade = CascadeType.ALL, orphanRemoval = true)
    Set<CommentMention> mentions = new LinkedHashSet<>();

    @Builder.Default
    @OneToMany(mappedBy = "comment", cascade = CascadeType.ALL, orphanRemoval = true)
    Set<CommentEmotion> emotions = new LinkedHashSet<>();

    public void setUser(User user) {
        this.user = user;
    }

    public void setThread(Thread thread) {
        this.thread = thread;
    }

    public void addEmotion(User user, String body) {
        var emotion = CommentEmotion.builder().user(user).comment(this).body(body).build();
        this.emotions.add(emotion);
    }


}
