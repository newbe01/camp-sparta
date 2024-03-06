package com.sparta.jpa2.common;

import com.sparta.jpa2.user.User;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MappedSuperclass;
import java.time.LocalDateTime;
import lombok.Getter;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Getter
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public class TimeStamp {

//    @CreatedDate
    private LocalDateTime createdAt;

//    @LastModifiedDate
    private LocalDateTime modifiedAt;

    @CreatedBy
    @ManyToOne
    private User createdBy;

    @LastModifiedBy
    @ManyToOne
    private User modifiedBy;

    public void updateCreatedAt() {
        this.createdAt = LocalDateTime.now();
    }

    public void updateModifiedAt() {
        this.modifiedAt = LocalDateTime.now();
    }

}
