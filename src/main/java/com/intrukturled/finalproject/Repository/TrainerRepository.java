package com.intrukturled.finalproject.Repository;

import com.intrukturled.finalproject.Entity.Trainer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TrainerRepository extends JpaRepository<Trainer, String> {
}
