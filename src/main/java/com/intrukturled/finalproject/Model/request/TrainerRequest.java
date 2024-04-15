package com.intrukturled.finalproject.Model.request;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TrainerRequest {
    private String name;
    private String email;
    private String phoneNumber;
    private String address;
}
