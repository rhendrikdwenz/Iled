package com.intrukturled.finalproject.Model.response;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TrainerResponse {
    private String name;
    private String email;
    private String phoneNumber;
    private String address;
}
