package com.intrukturled.finalproject.Repository;

import com.intrukturled.finalproject.Entity.Questions;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface QuestionsRepository extends JpaRepository<Questions, String>, JpaSpecificationExecutor<Questions> {

}
