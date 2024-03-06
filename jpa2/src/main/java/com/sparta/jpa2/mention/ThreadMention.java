package com.sparta.jpa2.mention;

import com.sparta.jpa2.common.TimeStamp;
import com.sparta.jpa2.thread.Thread;
import com.sparta.jpa2.user.User;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;
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
public class ThreadMention extends TimeStamp {

    @EmbeddedId
    private ThreadMentionId threadMentionId = new ThreadMentionId();

    @ManyToOne
    @MapsId("userId")
    @JoinColumn(name = "user_id")
    User user;

    @ManyToOne
    @MapsId("threadId")
    @JoinColumn(name = "thread_id")
    Thread thread;

    @Builder
    public ThreadMention(User user, Thread thread) {
        this.user = user;
        this.thread = thread;
        var id = new ThreadMentionId();
        id.setUserId(user.getId());
        id.setThreadId(thread.getId());
        this.threadMentionId = id;
    }
}
