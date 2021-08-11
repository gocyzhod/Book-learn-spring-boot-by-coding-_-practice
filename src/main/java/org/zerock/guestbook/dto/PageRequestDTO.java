package org.zerock.guestbook.dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;


@Builder
@AllArgsConstructor
//@NoArgsConstructor      // 만약 에러가 난다면 이 어노테이션 삭제
@Data

public class PageRequestDTO {

    private int page;
    private int size;

    private String type;
    private String keyword;

    public PageRequestDTO(){
        this.page = 1;
        this.size = 10;
    }

    public Pageable getPageable(Sort sort){

        return PageRequest.of(page -1 , size, sort); // JPA에서는 첫 페이지는 0부터 시작한다.
    }

}
