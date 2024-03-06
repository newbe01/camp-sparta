package com.sparta.jpa2.user;

import com.sparta.jpa2.mention.CommentMention;
import com.sparta.jpa2.mention.ThreadMention;
import com.sparta.jpa2.userChannel.UserChannel;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.util.LinkedHashSet;
import java.util.Set;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Builder
@AllArgsConstructor
@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(length = 25)
    private String username;

    @Column(length = 25)
    private String password;

//    @Embedded
//    @AttributeOverrides({
//        @AttributeOverride(name = "street", column = @Column(name = "home_street"))
//    })
//    private Address address;

    @Builder.Default
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    Set<UserChannel> userChannels = new LinkedHashSet<>();

    @Builder.Default
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    Set<CommentMention> commentMentions = new LinkedHashSet<>();

    @Builder.Default
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    Set<ThreadMention> threadMentions = new LinkedHashSet<>();

}
