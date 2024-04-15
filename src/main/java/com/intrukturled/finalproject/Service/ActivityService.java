package com.intrukturled.finalproject.Service;

import com.intrukturled.finalproject.Entity.Activity;
import com.intrukturled.finalproject.Model.request.ActivityRequest;
import com.intrukturled.finalproject.Model.response.ActivityResponse;
import org.springframework.data.domain.Page;

public interface ActivityService {
    ActivityResponse createActivity(ActivityRequest activityRequest);

    Page<Activity> getAllActivity(Integer page, Integer size);

    Activity getActivityById(String id);

    void deleteActivityById(String id);
}
