package com.intrukturled.finalproject.Controller;

import com.intrukturled.finalproject.Entity.Participant;
import com.intrukturled.finalproject.Entity.Trainer;
import com.intrukturled.finalproject.Model.PagingResponse;
import com.intrukturled.finalproject.Model.WebResponse;
import com.intrukturled.finalproject.Model.request.ParticipantRequest;
import com.intrukturled.finalproject.Model.request.TrainerRequest;
import com.intrukturled.finalproject.Model.response.ParticipantResponse;
import com.intrukturled.finalproject.Model.response.TrainerResponse;
import com.intrukturled.finalproject.Service.ParticipantService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/participant")
@AllArgsConstructor
public class ParticipantController {
    private final ParticipantService participantService;

    @PostMapping
    public ResponseEntity<WebResponse<ParticipantResponse>> createAdmin(@RequestBody ParticipantRequest participantRequest){
        ParticipantResponse newParticipant = participantService.createParticipant(participantRequest);
        WebResponse<ParticipantResponse> response = WebResponse.<ParticipantResponse>builder()
                .status(HttpStatus.CREATED.getReasonPhrase())
                .message("Success Resgister New Participant")
                .data(newParticipant)
                .build();
        return ResponseEntity.ok(response);
    }


    @GetMapping
    public ResponseEntity<?> getAllParticipant(
            @RequestParam(defaultValue = "1") Integer page,
            @RequestParam(defaultValue = "10") Integer size
    ){

        Page<Participant> participantList = participantService.getAllParticipant(page,size);

        PagingResponse pagingResponse = PagingResponse.builder()
                .page(page)
                .size(size)
                .totalPages(participantList.getTotalPages())
                .totalElements(participantList.getTotalElements())
                .build();

        WebResponse<List<Participant>> response = WebResponse.<List<Participant>>builder()
                .status(HttpStatus.OK.getReasonPhrase())
                .message("Success Get List Participant")
                .paging(pagingResponse)
                .data(participantList.getContent())
                .build();
        return ResponseEntity.ok(response);
    }



    @GetMapping(path = "/{id}")
    public ResponseEntity<?> getParticipantById(@PathVariable String id){
        Participant findParticipant = participantService.getParticipantById(id);
        WebResponse<Participant> response = WebResponse.<Participant>builder()
                .status(HttpStatus.OK.getReasonPhrase())
                .message("Success Get Participant")
                .data(findParticipant)
                .build();
        return ResponseEntity.ok(response);
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<?> deleteTrainerById(@PathVariable String id){
        participantService.deleteParticipantById(id);
        WebResponse<String> response = WebResponse.<String>builder()
                .status(HttpStatus.OK.getReasonPhrase())
                .message("Success Delete Participant")
                .data("OK")
                .build();
        return ResponseEntity.ok(response);
    }

    @PutMapping
    public ResponseEntity<?> updateParticipantById(@RequestBody Participant participant){
        Participant updateParticipant = participantService.updateParticipant(participant);
        WebResponse<Participant> response = WebResponse.<Participant>builder()
                .status(HttpStatus.OK.getReasonPhrase())
                .message("Success Update Participant")
                .data(updateParticipant)
                .build();
        return ResponseEntity.ok(response);
    }

}
