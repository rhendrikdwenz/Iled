package com.intrukturled.finalproject.Entity;


import com.intrukturled.finalproject.Constant.EQuestion;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "t_question")
public class Questions {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    @ManyToOne
    @JoinColumn(name = "participant_id")
    private User participant;

    private String content;
    @Enumerated(EnumType.STRING)
    private EQuestion eQuestion;
    @ManyToOne
    @JoinColumn(name = "activity_id")
    private Activity activity;
}
