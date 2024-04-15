package com.intrukturled.finalproject.Controller;

import com.intrukturled.finalproject.Model.WebResponse;
import com.intrukturled.finalproject.Model.request.ParticipantRequest;
import com.intrukturled.finalproject.Model.request.QuestionsRequest;
import com.intrukturled.finalproject.Model.response.ParticipantResponse;
import com.intrukturled.finalproject.Model.response.QuestionsResponse;
import com.intrukturled.finalproject.Service.QuestionsService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/questions")
@AllArgsConstructor
public class QuestionsController {
    private final QuestionsService questionsService;

    @PostMapping
    public ResponseEntity<WebResponse<QuestionsResponse>> addQuestions(@RequestBody QuestionsRequest questionsRequest){
        QuestionsResponse newQuestions = questionsService.addQuestions(questionsRequest);
        WebResponse<QuestionsResponse> response = WebResponse.<QuestionsResponse>builder()
                .status(HttpStatus.CREATED.getReasonPhrase())
                .message("Success Resgister New Participant")
                .data(newQuestions)
                .build();
        return ResponseEntity.ok(response);
    }
}
