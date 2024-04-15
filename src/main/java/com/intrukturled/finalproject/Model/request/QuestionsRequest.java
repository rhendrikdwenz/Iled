package com.intrukturled.finalproject.Model.request;

import com.intrukturled.finalproject.Constant.QuestionStatus;
import com.intrukturled.finalproject.Entity.Participant;
import lombok.*;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class QuestionsRequest {
    private String questions;
    private String participantId;
}
