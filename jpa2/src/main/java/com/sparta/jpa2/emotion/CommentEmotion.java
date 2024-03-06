package com.sparta.jpa2.emotion;

import com.sparta.jpa2.comment.Comment;
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
@Entity
public class CommentEmotion extends Emotion{

    @ManyToOne
    @JoinColumn(name = "comment_id")
    private Comment comment;

    @Builder
    public CommentEmotion(User user, Comment comment, String body) {
        this.user = user;
        this.comment = comment;
        this.body = body;
    }

}
