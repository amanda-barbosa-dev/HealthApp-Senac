package com.example.demo.model.bularioapi;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

    public  class SearchMedResponse {

            @JsonProperty("content")
            List<Content> content;

            @JsonProperty("totalPages")
            int totalPages;

            @JsonProperty("totalElements")
            int totalElements;

            @JsonProperty("last")
            boolean last;

            @JsonProperty("numberOfElements")
            int numberOfElements;

            @JsonProperty("first")
            boolean first;

            @JsonProperty("sort")
            String sort;

            @JsonProperty("size")
            int size;

            @JsonProperty("number")
            int number;

            public SearchMedResponse() {
            }

            public SearchMedResponse(List<Content> content, int totalPages, int totalElements, boolean last, int numberOfElements, boolean first, String sort, int size, int number) {
                    this.content = content;
                    this.totalPages = totalPages;
                    this.totalElements = totalElements;
                    this.last = last;
                    this.numberOfElements = numberOfElements;
                    this.first = first;
                    this.sort = sort;
                    this.size = size;
                    this.number = number;
            }

            public List<Content> getContent() {
                    return content;
            }

            public void setContent(List<Content> content) {
                    this.content = content;
            }

            @Override
            public String toString() {
                    return "SearchMedResponse{" +
                            "size=" + size +
                            '}';
            }
    }

