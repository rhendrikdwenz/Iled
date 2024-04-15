package com.intrukturled.finalproject.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;


@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "t_activity")
public class Activity  {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;
    private String notes;
    private Date date;
    private Date startTime;
    private Date endTime;
}

