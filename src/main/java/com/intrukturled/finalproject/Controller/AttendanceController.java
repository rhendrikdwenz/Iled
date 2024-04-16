package com.intrukturled.finalproject.Controller;

import com.intrukturled.finalproject.Entity.Attendance;
import com.intrukturled.finalproject.Entity.User;
import com.intrukturled.finalproject.Model.request.AttendanceRequest;
import com.intrukturled.finalproject.Model.request.UserRequest;
import com.intrukturled.finalproject.Model.response.WebResponse;
import com.intrukturled.finalproject.Service.AttendanceService;
import com.intrukturled.finalproject.Service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/attendance")
public class AttendanceController {
    @Autowired
    private AttendanceService attendanceService;
    @PostMapping
    public ResponseEntity<?> addAttendance(@Valid @RequestBody AttendanceRequest attendanceRequest) {
        Attendance newAttendance = attendanceService.addAttendance(attendanceRequest);
        WebResponse<Attendance> response = WebResponse.<Attendance>builder()
                .status(HttpStatus.CREATED.getReasonPhrase())
                .message("Success add data")
                .data(newAttendance)
                .build();
        return ResponseEntity.ok(response);
    }
}
