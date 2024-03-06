package com.sparta.jpa2.emotion;

import com.sparta.jpa2.thread.Thread;
import com.sparta.jpa2.user.User;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
//@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Entity
public class ThreadEmotion extends Emotion {

    @ManyToOne
    @JoinColumn(name = "thread_id")
    private Thread thread;

    @Builder
    public ThreadEmotion(User user, Thread thread, String body) {
        this.user = user;
        this.thread = thread;
        this.body = body;
    }

}
