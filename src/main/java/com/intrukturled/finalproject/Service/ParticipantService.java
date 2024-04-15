package com.intrukturled.finalproject.Service;

import com.intrukturled.finalproject.Entity.Participant;
import com.intrukturled.finalproject.Model.request.ParticipantRequest;
import com.intrukturled.finalproject.Model.response.ParticipantResponse;
import org.springframework.data.domain.Page;

public interface ParticipantService {
    ParticipantResponse createParticipant(ParticipantRequest participantRequest);

    Page<Participant> getAllParticipant(Integer page, Integer size);

    Participant getParticipantById(String id);

    Participant updateParticipant(Participant participant);

    void deleteParticipantById(String id);

}
