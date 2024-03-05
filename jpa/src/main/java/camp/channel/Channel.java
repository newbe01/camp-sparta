package camp.channel;

import camp.thread.Thread;
import camp.user.User;
import camp.userChannel.UserChannel;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
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
public class Channel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    private String name;

    @Enumerated(EnumType.STRING)
    private Type type;

    @Builder.Default
    @OneToMany(mappedBy = "channel")
    private Set<Thread> threads = new LinkedHashSet<>();

    @Builder.Default
    @OneToMany(mappedBy = "channel")
    private Set<UserChannel> userChannels = new LinkedHashSet<>();

    public UserChannel joinUser(User user) {
        UserChannel userChannel = UserChannel.builder().user(user).channel(this).build();
        this.userChannels.add(userChannel);
        user.getUserChannels().add(userChannel);
        return userChannel;
    }

    public void addThreads(Thread thread) {
        this.threads.add(thread);
    }

    private enum Type {
        PUBLIC, PRIVATE,
    }
}
