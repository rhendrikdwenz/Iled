package com.intrukturled.finalproject.Service;

import com.intrukturled.finalproject.Entity.Questions;
import com.intrukturled.finalproject.Model.request.QuestionsRequest;
import com.intrukturled.finalproject.Model.response.QuestionsResponse;

public interface QuestionsService {
    QuestionsResponse addQuestions(QuestionsRequest questionsRequest);
    Questions getQuestionsById(String id);
}
