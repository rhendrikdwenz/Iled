package com.intrukturled.finalproject.Repository;

import com.intrukturled.finalproject.Entity.Questions;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QuestionsRepository extends JpaRepository<Questions, String> {
}
