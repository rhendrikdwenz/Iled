package com.intrukturled.finalproject.Entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Builder
@Table(name="instrukturled")
public class InstrukturLed {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;
    private Date date;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "trainer_id")
    private Trainer trainer;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "participant_id")
    private Participant participant;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "questions_id")
    private Questions questions;
    private String additionalQuestions;


}
