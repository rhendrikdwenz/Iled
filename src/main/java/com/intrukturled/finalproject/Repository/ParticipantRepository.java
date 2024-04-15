package com.intrukturled.finalproject.Repository;

import com.intrukturled.finalproject.Entity.Participant;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ParticipantRepository extends JpaRepository<Participant, String> {
}
