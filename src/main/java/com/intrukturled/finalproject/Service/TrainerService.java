package com.intrukturled.finalproject.Service;

import com.intrukturled.finalproject.Entity.Trainer;
import com.intrukturled.finalproject.Model.request.TrainerRequest;
import com.intrukturled.finalproject.Model.response.TrainerResponse;
import org.springframework.data.domain.Page;

public interface TrainerService {
    TrainerResponse createTrainer(TrainerRequest trainerRequest);

    Page<Trainer> getAllTrainer(Integer page, Integer size);

    Trainer getTrainerById(String id);

    Trainer updateTrainer(Trainer trainer);

    void deleteTrainerById(String id);

}
