package com.intrukturled.finalproject.Repository;

import com.intrukturled.finalproject.Entity.Schedule;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ScheduleRepository extends JpaRepository<Schedule, String> {
}
