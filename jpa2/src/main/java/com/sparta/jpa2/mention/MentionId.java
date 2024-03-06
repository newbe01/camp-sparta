package com.sparta.jpa2.mention;

import com.sparta.jpa2.userChannel.UserChannelId;
import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Embeddable
public class MentionId implements Serializable {

    @Column(name = "user_id")
    private Long user_id;

    @Column(name = "thread_id")
    private Long thread_id;

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof MentionId mentionId)) {
            return false;
        }
        return Objects.equals(getUser_id(), mentionId.getUser_id())
            && Objects.equals(getThread_id(), mentionId.getThread_id());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getUser_id(), getThread_id());
    }
}
