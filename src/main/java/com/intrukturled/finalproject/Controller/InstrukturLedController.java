package com.intrukturled.finalproject.Controller;

import com.intrukturled.finalproject.Entity.InstrukturLed;
import com.intrukturled.finalproject.Model.WebResponse;
import com.intrukturled.finalproject.Model.request.InstrukturLedRequest;
import com.intrukturled.finalproject.Service.InstruktureLedService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/instrukturled")
public class InstrukturLedController {
    @Autowired
    private InstruktureLedService instruktureLedService;

    @PostMapping
    public ResponseEntity<?> addInstrukturLed(@Valid @RequestBody InstrukturLedRequest instrukturLedRequest) {
        InstrukturLed newInstrukturLed = instruktureLedService.addInstrukturLed(instrukturLedRequest);
        WebResponse<InstrukturLed> response = WebResponse.<InstrukturLed>builder()
                .status(HttpStatus.CREATED.getReasonPhrase())
                .message("Success add data")
                .data(newInstrukturLed)
                .build();
        return ResponseEntity.ok(response);
    }

}
