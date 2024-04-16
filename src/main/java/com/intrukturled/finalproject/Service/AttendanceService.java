package com.intrukturled.finalproject.Service;

import com.intrukturled.finalproject.Entity.Attendance;
import com.intrukturled.finalproject.Model.request.AttendanceRequest;

public interface AttendanceService {
    Attendance addAttendance(AttendanceRequest attendanceRequest);
}
