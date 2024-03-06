package com.sparta.jpa2.common;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Builder
public class PageDTO {

    private Integer currentPage;

    private Integer size;

    private String sortBy;

    public Pageable toPageable() {
        return PageRequest.of(currentPage - 1, size, Sort.by(sortBy).descending());
    }

}
