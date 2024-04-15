package com.intrukturled.finalproject.Model.response;

import com.intrukturled.finalproject.Constant.QuestionStatus;
import com.intrukturled.finalproject.Entity.Participant;
import lombok.*;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class QuestionsResponse {
    private String questions;
    private Participant participant;
    private Date dateQuestions;
    private QuestionStatus questionStatus;
}
