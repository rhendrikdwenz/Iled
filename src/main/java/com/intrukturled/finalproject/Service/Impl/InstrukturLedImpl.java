package com.intrukturled.finalproject.Service.Impl;

import com.intrukturled.finalproject.Entity.InstrukturLed;
import com.intrukturled.finalproject.Entity.Participant;
import com.intrukturled.finalproject.Entity.Questions;
import com.intrukturled.finalproject.Entity.Trainer;
import com.intrukturled.finalproject.Model.request.InstrukturLedRequest;
import com.intrukturled.finalproject.Repository.InstrukturLedRepository;
import com.intrukturled.finalproject.Service.InstruktureLedService;
import com.intrukturled.finalproject.Service.ParticipantService;
import com.intrukturled.finalproject.Service.QuestionsService;
import com.intrukturled.finalproject.Service.TrainerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;

@Service
public class InstrukturLedImpl implements InstruktureLedService {
    @Autowired
    private TrainerService trainerService;
    @Autowired
    private ParticipantService participantService;
    @Autowired
    private QuestionsService questionsService;
    @Autowired
    private InstrukturLedRepository instrukturLedRepository;
    @Override
    public InstrukturLed addInstrukturLed(InstrukturLedRequest instrukturLedRequest) {
        Trainer trainer = trainerService.getTrainerById(instrukturLedRequest.getTrainer().getId());
        Participant participant = participantService.getParticipantById(instrukturLedRequest.getParticipant().getId());
        Questions questions = questionsService.getQuestionsById(instrukturLedRequest.getQuestions().getId());
        InstrukturLed instrukturLed = InstrukturLed.builder()
                .date(instrukturLedRequest.getDate())
                .trainer(trainer)
                .participant(participant)
                .questions(questions)
                .additionalQuestions(instrukturLedRequest.getAdditionalQuestions())
                .build();
        return instrukturLedRepository.saveAndFlush(instrukturLed);
    }

    @Override
    public InstrukturLed getById(String id) {
        Optional<InstrukturLed> optionalInstrukturLed = instrukturLedRepository.findById(id);
        if (optionalInstrukturLed.isPresent()) return optionalInstrukturLed.get();
        throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Instruktur Led with id : " + id + " Not Found");
    }

    @Override
    public InstrukturLed updateInstrukturLed(InstrukturLed instrukturLed) {
        return instrukturLedRepository.save(instrukturLed);
    }
}
