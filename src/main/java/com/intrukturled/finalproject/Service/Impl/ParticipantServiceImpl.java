package com.intrukturled.finalproject.Service.Impl;

import com.intrukturled.finalproject.Entity.Participant;
import com.intrukturled.finalproject.Entity.Trainer;
import com.intrukturled.finalproject.Model.request.ParticipantRequest;
import com.intrukturled.finalproject.Model.response.ParticipantResponse;
import com.intrukturled.finalproject.Model.response.TrainerResponse;
import com.intrukturled.finalproject.Repository.ParticipantRepository;
import com.intrukturled.finalproject.Service.ParticipantService;
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
public class ParticipantServiceImpl implements ParticipantService {
    private final ParticipantRepository participantRepository;

    @Override
    public ParticipantResponse createParticipant(ParticipantRequest participantRequest) {
        Participant newParticipant = Participant.builder()
                .name(participantRequest.getName())
                .email(participantRequest.getEmail())
                .address(participantRequest.getAddress())
                .phoneNumber(participantRequest.getPhoneNumber())
                .build();
        Participant registParticipant = participantRepository.saveAndFlush(newParticipant);
        return ParticipantResponse.builder()
                .name(registParticipant.getName())
                .address(registParticipant.getAddress())
                .email(registParticipant.getEmail())
                .phoneNumber(registParticipant.getPhoneNumber())
                .build();
    }

    @Override
    public Page<Participant> getAllParticipant(Integer page, Integer size) {
        if (page <= 0 ){
            page = 1;
        }
        Pageable pageable = PageRequest.of(page -1,size);
        return participantRepository.findAll(pageable);
    }


    @Override
    public Participant getParticipantById(String id) {
        Optional<Participant> optionalParticipant = participantRepository.findById(id);
        if (optionalParticipant.isPresent()) return optionalParticipant.get();
        throw new ResponseStatusException(HttpStatus.NOT_FOUND,"Nasabah Not Found");
    }

    @Override
    public Participant updateParticipant(Participant participant) {
        this.getParticipantById(participant.getId());
        return participantRepository.save(participant);
    }

    @Override
    public void deleteParticipantById(String id) {
        this.getParticipantById(id);
        participantRepository.deleteById(id);
    }
}
