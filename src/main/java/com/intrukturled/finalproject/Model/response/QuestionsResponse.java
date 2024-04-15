package com.intrukturled.finalproject.Model.response;

import com.intrukturled.finalproject.Constant.EQuestion;
import com.intrukturled.finalproject.Entity.Activity;
import com.intrukturled.finalproject.Entity.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class QuestionsResponse {
    private String id;
    private User participant;
    private String content;
    private EQuestion status;
    private Activity activity;
}
