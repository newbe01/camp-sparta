package com.sparta.jpa2.thread;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ThreadSearchCond {

    private Long mentionedUserId;
    private Long channelId;


}
