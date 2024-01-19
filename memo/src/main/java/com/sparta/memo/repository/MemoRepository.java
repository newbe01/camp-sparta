package com.sparta.memo.repository;

import com.sparta.memo.entity.Memo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

//@Component
@Repository
public interface MemoRepository extends JpaRepository<Memo, Long> {

    List<Memo> findAllByOrderByModifiedAtDesc();

    List<Memo> findAllByUsername(String username);

    List<Memo> findAllByContentsContainsOrderByModifiedAtDesc(@Param("contents") String content);

}
