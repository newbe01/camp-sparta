package com.sparta.jpa2.thread;

import com.sparta.jpa2.channel.Channel;
import com.sparta.jpa2.mention.Mention;
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
public class Thread {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(length = 500)
    private String message;

    @ManyToOne
    @JoinColumn(name = "channel_id")
    private Channel channel;

    @Builder.Default
    @OneToMany(mappedBy = "thread", cascade = CascadeType.ALL, orphanRemoval = true)
    Set<Mention> mentions = new LinkedHashSet<>();

    public void setChannel(Channel channel) {
        this.channel = channel;
        channel.addThreads(this);
    }

    public void addMention(User user) {
        Mention mention = Mention.builder().user(user).thread(this).build();
        this.mentions.add(mention);
        user.getMentions().add(mention);
    }
}
