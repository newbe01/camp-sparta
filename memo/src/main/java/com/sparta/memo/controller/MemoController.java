package com.sparta.memo.controller;

import com.sparta.memo.dto.MemoRequestDto;
import com.sparta.memo.dto.MemoResponseDto;
import com.sparta.memo.entity.Memo;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RequestMapping("/api")
@RestController
public class MemoController {

    private final Map<Long, Memo> memoList = new HashMap<>();

    @PostMapping("/memos")
    public MemoResponseDto createMemo(@RequestBody MemoRequestDto requestDto) {
        // requestDto -> entity
        Memo memo = new Memo(requestDto);

        // max id
        Long maxId = memoList.size() > 0 ? Collections.max(memoList.keySet()) + 1 : 1;
        memo.setId(maxId);

        // create
        memoList.put(memo.getId(), memo);

        // entity -> responseDto
        return new MemoResponseDto(memo);
    }

    @GetMapping("/memos")
    public List<MemoResponseDto> getMemos() {
        // map to list
        return memoList.values().stream().map(MemoResponseDto::new).toList();
    }
}
