package com.sparta.jpa2.userChannel;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Embeddable
public class UserChannelId implements Serializable {

    @Column(name = "user_id")
    private Long userId;

    @Column(name = "channel_id")
    private Long channelId;

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        UserChannelId userChannelId = (UserChannelId) o;
        return Objects.equals(getUserId(), userChannelId.getUserId()) && Objects.equals(
            getChannelId(), userChannelId.getChannelId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getUserId(), getChannelId());
    }
}
