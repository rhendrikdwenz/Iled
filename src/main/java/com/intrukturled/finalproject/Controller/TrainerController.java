package com.intrukturled.finalproject.Controller;

import com.intrukturled.finalproject.Entity.Trainer;
import com.intrukturled.finalproject.Model.PagingResponse;
import com.intrukturled.finalproject.Model.WebResponse;
import com.intrukturled.finalproject.Model.request.TrainerRequest;
import com.intrukturled.finalproject.Model.response.TrainerResponse;
import com.intrukturled.finalproject.Service.TrainerService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/trainer")
@AllArgsConstructor
public class TrainerController {
    private final TrainerService trainerService;

    @PostMapping
    public ResponseEntity<WebResponse<TrainerResponse>> createAdmin(@RequestBody TrainerRequest trainerRequest){
        TrainerResponse newTrainer = trainerService.createTrainer(trainerRequest);
        WebResponse<TrainerResponse> response = WebResponse.<TrainerResponse>builder()
                .status(HttpStatus.CREATED.getReasonPhrase())
                .message("Success Resgister New Trainer")
                .data(newTrainer)
                .build();
        return ResponseEntity.ok(response);
    }


    @GetMapping
    public ResponseEntity<?> getAllTrainer(
            @RequestParam(defaultValue = "1") Integer page,
            @RequestParam(defaultValue = "10") Integer size
    ){

        Page<Trainer> trainerList = trainerService.getAllTrainer(page,size);

        PagingResponse pagingResponse = PagingResponse.builder()
                .page(page)
                .size(size)
                .totalPages(trainerList.getTotalPages())
                .totalElements(trainerList.getTotalElements())
                .build();

        WebResponse<List<Trainer>> response = WebResponse.<List<Trainer>>builder()
                .status(HttpStatus.OK.getReasonPhrase())
                .message("Success Get List Trainer")
                .paging(pagingResponse)
                .data(trainerList.getContent())
                .build();
        return ResponseEntity.ok(response);
    }



    @GetMapping(path = "/{id}")
    public ResponseEntity<?> getTrainerById(@PathVariable String id){
        Trainer findTrainer = trainerService.getTrainerById(id);
        WebResponse<Trainer> response = WebResponse.<Trainer>builder()
                .status(HttpStatus.OK.getReasonPhrase())
                .message("Success Get Trainer")
                .data(findTrainer)
                .build();
        return ResponseEntity.ok(response);
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<?> deleteTrainerById(@PathVariable String id){
        trainerService.deleteTrainerById(id);
        WebResponse<String> response = WebResponse.<String>builder()
                .status(HttpStatus.OK.getReasonPhrase())
                .message("Success Delete Trainer")
                .data("OK")
                .build();
        return ResponseEntity.ok(response);
    }

    @PutMapping
    public ResponseEntity<?> updateTrainerById(@RequestBody Trainer trainer){
        Trainer updateTrainer = trainerService.updateTrainer(trainer);
        WebResponse<Trainer> response = WebResponse.<Trainer>builder()
                .status(HttpStatus.OK.getReasonPhrase())
                .message("Success Update Trainer")
                .data(updateTrainer)
                .build();
        return ResponseEntity.ok(response);
    }

}


