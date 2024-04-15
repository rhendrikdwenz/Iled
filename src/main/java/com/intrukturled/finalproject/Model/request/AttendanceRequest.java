package com.intrukturled.finalproject.Model.request;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AttendanceRequest {
    @NotNull(message = "participant must not be blank")
    private String participantId;

    @NotNull(message = "Activity ID must not be null")
    private String activityId;

    @NotNull(message = "Present flag must not be null")
    private Boolean present;
}