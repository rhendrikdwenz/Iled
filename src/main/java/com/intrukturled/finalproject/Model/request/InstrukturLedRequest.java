package com.intrukturled.finalproject.Model.request;

import lombok.*;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class InstrukturLedRequest {
    private Date date;
    private Trainer trainer;
    private Participant participant;
    private Questions questions;
    private String additionalQuestions;
}
