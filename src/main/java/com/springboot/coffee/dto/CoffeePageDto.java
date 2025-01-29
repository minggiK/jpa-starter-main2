package com.springboot.coffee.dto;

import lombok.Getter;

import java.util.List;

@Getter
public class CoffeePageDto {
    //coffee 전체조회
    private List<CoffeeResponseDto> data;
    private PageInfo pageInfo;

    public static class PageInfo {
        private int page;
        private int size;
        private int totalElements;
        private int totalPages;

        public PageInfo(int page, int size, int totalElements, int totalPages) {
            this.page = page;
            this.size = size;
            this.totalElements = totalElements;
            this.totalPages = totalPages;
        }

    }
}
