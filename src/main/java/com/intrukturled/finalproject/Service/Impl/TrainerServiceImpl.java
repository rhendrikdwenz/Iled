package com.intrukturled.finalproject.Service.Impl;

import com.intrukturled.finalproject.Entity.Trainer;
import com.intrukturled.finalproject.Model.request.TrainerRequest;
import com.intrukturled.finalproject.Model.response.TrainerResponse;
import com.intrukturled.finalproject.Repository.TrainerRepository;
import com.intrukturled.finalproject.Service.TrainerService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;

@Service
@AllArgsConstructor
public class TrainerServiceImpl implements TrainerService {
    final private TrainerRepository trainerRepository;
    @Override
    public TrainerResponse createTrainer(TrainerRequest trainerRequest) {
        Trainer newTrainer = Trainer.builder()
                .name(trainerRequest.getName())
                .email(trainerRequest.getEmail())
                .address(trainerRequest.getAddress())
                .phoneNumber(trainerRequest.getPhoneNumber())
                .build();
        Trainer registTrainer = trainerRepository.saveAndFlush(newTrainer);
        return TrainerResponse.builder()
                .name(registTrainer.getName())
                .address(registTrainer.getAddress())
                .email(registTrainer.getEmail())
                .phoneNumber(registTrainer.getPhoneNumber())
                .build();
    }

    @Override
    public Page<Trainer> getAllTrainer(Integer page, Integer size) {
        if (page <= 0 ){
            page = 1;
        }
        Pageable pageable = PageRequest.of(page -1,size);
        return trainerRepository.findAll(pageable);
    }

    @Override
    public Trainer getTrainerById(String id) {
        Optional<Trainer> optionalTrainer = trainerRepository.findById(id);
        if (optionalTrainer.isPresent()) return optionalTrainer.get();
        throw new ResponseStatusException(HttpStatus.NOT_FOUND,"Nasabah Not Found");
    }

    @Override
    public Trainer updateTrainer(Trainer trainer) {
        this.getTrainerById(trainer.getId());
        return trainerRepository.save(trainer);
    }

    @Override
    public void deleteTrainerById(String id) {
        this.getTrainerById(id);
        trainerRepository.deleteById(id);
    }
}
