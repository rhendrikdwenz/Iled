package com.intrukturled.finalproject.Entity;

import com.intrukturled.finalproject.Constant.QuestionStatus;
import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Builder
@Table(name="question")
public class Questions {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID )
    private String id;
    private String questions;
    private Participant participant;
    private Date dateQuestions;
    @Enumerated(EnumType.STRING)
    private QuestionStatus questionStatus;
}
