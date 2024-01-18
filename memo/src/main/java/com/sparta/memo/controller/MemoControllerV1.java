package com.sparta.memo.controller;

import com.sparta.memo.dto.MemoRequestDto;
import com.sparta.memo.dto.MemoResponseDto;
import com.sparta.memo.entity.Memo;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RequestMapping("/api/v1")
@RestController
public class MemoControllerV1 {

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

    @PutMapping("memos/{id}")
    public Long updateMemo(@PathVariable Long id, @RequestBody MemoRequestDto requestDto) {
        // 메모 존재 확인
        if (memoList.containsKey(id)) {
            // get memo
            Memo memo = memoList.get(id);

            // update memo
            memo.update(requestDto);
            return memo.getId();
        } else {
            throw new IllegalArgumentException("선택한 메모 존재하지 않음");
        }
    }

    @DeleteMapping("memos/{id}")
    public Long deleteMemo(@PathVariable Long id) {
        // 메모 존재 확인
        if (memoList.containsKey(id)) {
            // delete memo
            memoList.remove(id);
            return id;
        } else {
            throw new IllegalArgumentException("선택한 메모 존재하지 않음");
        }
    }

}
