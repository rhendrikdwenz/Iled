package com.intrukturled.finalproject.Model.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ActivityResponse {
    private String id;
    private Date date;
    private Date startTime;
    private Date endTime;
    private String notes;
}
