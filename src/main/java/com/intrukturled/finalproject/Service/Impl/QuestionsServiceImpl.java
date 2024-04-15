package com.intrukturled.finalproject.Service.Impl;

import com.intrukturled.finalproject.Constant.QuestionStatus;
import com.intrukturled.finalproject.Entity.InstrukturLed;
import com.intrukturled.finalproject.Entity.Participant;
import com.intrukturled.finalproject.Entity.Questions;
import com.intrukturled.finalproject.Entity.Trainer;
import com.intrukturled.finalproject.Model.request.QuestionsRequest;
import com.intrukturled.finalproject.Model.response.QuestionsResponse;
import com.intrukturled.finalproject.Model.response.TrainerResponse;
import com.intrukturled.finalproject.Repository.QuestionsRepository;
import com.intrukturled.finalproject.Service.ParticipantService;
import com.intrukturled.finalproject.Service.QuestionsService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.Date;
import java.util.Optional;

@Service
@AllArgsConstructor
public class QuestionsServiceImpl implements QuestionsService {
    private QuestionsRepository questionsRepository;
    private ParticipantService participantService;
    @Override
    public QuestionsResponse addQuestions(QuestionsRequest questionsRequest) {
        Participant participant = participantService.getParticipantById(String.valueOf(questionsRequest.getParticipantId()));
        Questions newQuestions = Questions.builder()
                .questions(questionsRequest.getQuestions())
                .participant(participant)
                .dateQuestions(new Date())
                .questionStatus(QuestionStatus.submitted)
                .build();
        Questions registQuestions = questionsRepository.saveAndFlush(newQuestions);
        return QuestionsResponse.builder()
                .questions(registQuestions.getQuestions())
                .participant(registQuestions.getParticipant())
                .dateQuestions(new Date())
                .questionStatus(QuestionStatus.submitted)
                .build();
    }


    @Override
    public Questions getQuestionsById(String id) {
        Optional<Questions> optionalQuestions = questionsRepository.findById(id);
        if (optionalQuestions.isPresent()) return optionalQuestions.get();
        throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Instruktur Led with id : " + id + " Not Found");
    }
}
