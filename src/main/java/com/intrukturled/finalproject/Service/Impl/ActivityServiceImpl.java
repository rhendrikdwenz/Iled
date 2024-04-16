package com.intrukturled.finalproject.Service.Impl;

import com.intrukturled.finalproject.Entity.Activity;
import com.intrukturled.finalproject.Model.request.ActivityRequest;
import com.intrukturled.finalproject.Repository.ActivityRepository;
import com.intrukturled.finalproject.Service.ActivityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ActivityServiceImpl implements ActivityService {
    @Autowired
    private ActivityRepository activityRepository;
    @Override
    public Activity addActivity(ActivityRequest activityRequest) {
        Activity newActivity = Activity.builder()
                .date(activityRequest.getDate())
                .startTime(activityRequest.getStartTime())
                .endTime(activityRequest.getEndTime())
                .build();
        return activityRepository.saveAndFlush(newActivity);
    }
}
