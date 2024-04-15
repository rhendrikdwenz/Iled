package com.intrukturled.finalproject.Model.request;

import com.intrukturled.finalproject.Entity.Participant;
import com.intrukturled.finalproject.Entity.Questions;
import com.intrukturled.finalproject.Entity.Trainer;
import lombok.*;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class InstrukturLedRequest {
    private Date date;
    private String trainerId; // Menggunakan String untuk menyimpan ID Trainer
    private String participantId; // Menggunakan String untuk menyimpan ID Participant
    private String questionsId; // Menggunakan String untuk menyimpan ID Questions
    private String additionalQuestions;
}

