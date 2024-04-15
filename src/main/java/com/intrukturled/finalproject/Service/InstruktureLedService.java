package com.intrukturled.finalproject.Service;

import com.intrukturled.finalproject.Entity.InstrukturLed;
import com.intrukturled.finalproject.Model.request.InstrukturLedRequest;

public interface InstruktureLedService {
    InstrukturLed addInstrukturLed(InstrukturLedRequest instrukturLedRequest);
    InstrukturLed getById(String id);
    InstrukturLed updateInstrukturLed(InstrukturLed instrukturLed);
}
