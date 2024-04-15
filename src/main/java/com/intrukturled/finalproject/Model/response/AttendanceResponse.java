package com.intrukturled.finalproject.Model.response;

import com.intrukturled.finalproject.Entity.Activity;
import com.intrukturled.finalproject.Entity.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AttendanceResponse {
    private Long id;
    private User user;
    private Activity activity;
    private boolean present;
}
