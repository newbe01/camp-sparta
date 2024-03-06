package com.sparta.jpa2.mention;

import com.sparta.jpa2.comment.Comment;
import com.sparta.jpa2.common.TimeStamp;
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
public class CommentMention extends TimeStamp {

    @EmbeddedId
    private CommentMentionId commentMentionId = new CommentMentionId();

    @ManyToOne
    @MapsId("userId")
    @JoinColumn(name = "user_id")
    User user;

    @ManyToOne
    @MapsId("commentId")
    @JoinColumn(name = "comment_id")
    Comment comment;

    @Builder
    public CommentMention(User user, Comment comment) {
        this.user = user;
        this.comment = comment;
    }

}
