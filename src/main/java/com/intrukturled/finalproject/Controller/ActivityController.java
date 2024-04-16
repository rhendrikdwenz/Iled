package com.intrukturled.finalproject.Controller;

import com.intrukturled.finalproject.Entity.Activity;
import com.intrukturled.finalproject.Entity.Attendance;
import com.intrukturled.finalproject.Model.request.ActivityRequest;
import com.intrukturled.finalproject.Model.request.AttendanceRequest;
import com.intrukturled.finalproject.Model.response.WebResponse;
import com.intrukturled.finalproject.Service.ActivityService;
import com.intrukturled.finalproject.Service.AttendanceService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/activity")
public class ActivityController {
    @Autowired
    private ActivityService activityService;
    @PostMapping
    public ResponseEntity<?> addActivity(@Valid @RequestBody ActivityRequest activityRequest) {
        Activity newActivity = activityService.addActivity(activityRequest);
        WebResponse<Activity> response = WebResponse.<Activity>builder()
                .status(HttpStatus.CREATED.getReasonPhrase())
                .message("Success add data")
                .data(newActivity)
                .build();
        return ResponseEntity.ok(response);
    }
}
