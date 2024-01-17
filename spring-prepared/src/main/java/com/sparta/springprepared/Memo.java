package com.sparta.springprepared;

import lombok.*;

@RequiredArgsConstructor
//@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class Memo {

    private String username;
    private final String contents;

}