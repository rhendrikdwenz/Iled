package com.intrukturled.finalproject.Model;


import lombok.*;

@Getter
@Builder
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class WebResponse<T> {
    private String status;
    private String message;
    private PagingResponse paging;
    private T data;
}
