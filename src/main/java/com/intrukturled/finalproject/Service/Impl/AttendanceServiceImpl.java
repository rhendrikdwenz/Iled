package com.intrukturled.finalproject.Service.Impl;

import com.intrukturled.finalproject.Entity.Activity;
import com.intrukturled.finalproject.Entity.Attendance;
import com.intrukturled.finalproject.Entity.User;
import com.intrukturled.finalproject.Model.request.AttendanceRequest;
import com.intrukturled.finalproject.Repository.ActivityRepository;
import com.intrukturled.finalproject.Repository.AttendanceRepository;
import com.intrukturled.finalproject.Repository.UserRepository;
import com.intrukturled.finalproject.Service.AttendanceService;
import com.intrukturled.finalproject.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service

public class AttendanceServiceImpl implements AttendanceService {
    @Autowired
    private AttendanceRepository attendanceRepository;
    @Autowired
    private UserService userService;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private ActivityRepository activityRepository;

    public Attendance addAttendance(AttendanceRequest attendanceRequest) {
        // Mendapatkan user berdasarkan ID
        User user = userRepository.findById(attendanceRequest.getUserId())
                .orElseThrow(() -> new IllegalArgumentException("User not found"));

        // Mendapatkan aktivitas berdasarkan ID
        Activity activity = activityRepository.findById(attendanceRequest.getActivityId())
                .orElseThrow(() -> new IllegalArgumentException("Activity not found"));

        // Membuat objek Attendance
        Attendance newAttendance = Attendance.builder()
                .user(user)
                .activity(activity)
                .present(attendanceRequest.getPresent())
                .build();

        // Menyimpan kehadiran ke dalam database
        return attendanceRepository.save(newAttendance);
    }

}
