package com.sparta.jpa2.emotion;

import com.sparta.jpa2.thread.Thread;
import com.sparta.jpa2.user.User;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MappedSuperclass;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
//@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
//@AllArgsConstructor
@MappedSuperclass
public class Emotion {

    @Getter(AccessLevel.NONE)
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id", nullable = false)
    private Long id;

    protected String body;

    @ManyToOne
    User user;


}
