package com.sparta.jpa2.userChannel;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserChannelRepository extends JpaRepository<UserChannel, Long> {

}
