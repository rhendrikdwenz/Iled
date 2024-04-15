package com.intrukturled.finalproject.Model.request;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class QuestionsRequest {
    @NotBlank(message = "Participant ID must not be blank")
    private String participantId;

    @NotBlank(message = "Content must not be blank")
    private String content;
    @NotBlank(message = "Activity must not be blank")
    private String activity;
}