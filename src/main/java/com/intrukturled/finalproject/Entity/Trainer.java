package com.intrukturled.finalproject.Entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Builder
@Table(name="trainer")
public class Trainer {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;
    private String name;
    @Column(unique = true)
    private String email;

    @Column(unique = true, name = "phone_number")
    private String phoneNumber;
    private String address;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(nullable = false,updatable = false, name = "join_date")
    @JsonFormat(pattern = "yyyy-MM-dd hh:mm:ss a", timezone = "Asia/Jakarta")
    private Date joinDate;

    @PrePersist
    protected void onCreate(){
        joinDate = new Date();
    }


}
