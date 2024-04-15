package com.intrukturled.finalproject.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
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
    private String id;
    private Date date;
    private Trainer trainer;
    private Questions questions;
    private Participant participant;

}
