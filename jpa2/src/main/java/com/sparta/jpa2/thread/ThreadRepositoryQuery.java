package com.sparta.jpa2.thread;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


public interface ThreadRepositoryQuery {

    Page<Thread> search(ThreadSearchCond cond, Pageable pageable);

}
