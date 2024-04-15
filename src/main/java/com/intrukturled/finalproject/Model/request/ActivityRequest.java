package com.intrukturled.finalproject.Model.request;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ActivityRequest {
    @NotNull(message = "Date must not be null")
    private Date date;

    @NotNull(message = "Start time must not be null")
    private Date startTime;

    @NotNull(message = "End time must not be null")
    private Date endTime;

    private String notes;
}
