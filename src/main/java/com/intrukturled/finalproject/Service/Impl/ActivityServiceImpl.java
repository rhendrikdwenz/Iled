package com.intrukturled.finalproject.Service.Impl;

import com.intrukturled.finalproject.Entity.Activity;
import com.intrukturled.finalproject.Model.request.ActivityRequest;
import com.intrukturled.finalproject.Model.response.ActivityResponse;
import com.intrukturled.finalproject.Repository.ActivityRepository;
import com.intrukturled.finalproject.Service.ActivityService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;

@Service
@AllArgsConstructor
public class ActivityServiceImpl implements ActivityService {
    private final ActivityRepository activityRepository;

    @Override
    public ActivityResponse createActivity(ActivityRequest activityRequest) {
        Activity newActivity = Activity.builder()
                .date(activityRequest.getDate())
                .startTime(activityRequest.getStartTime())
                .endTime(activityRequest.getEndTime())
                .notes(activityRequest.getNotes())
                .build();
        Activity registActivity = activityRepository.saveAndFlush(newActivity);
        return ActivityResponse.builder()
                .id(registActivity.getId())
                .date(registActivity.getDate())
                .startTime(registActivity.getStartTime())
                .endTime(registActivity.getEndTime())
                .notes(registActivity.getNotes())
                .build();
    }

    @Override
    public Page<Activity> getAllActivity(Integer page, Integer size) {
        if (page <= 0 ){
            page = 1;
        }
        Pageable pageable = PageRequest.of(page -1,size);
        return activityRepository.findAll(pageable);
    }

    @Override
    public Activity getActivityById(String id) {
        Optional<Activity> optionalActivity = activityRepository.findById(id);
        if (optionalActivity.isPresent()) return optionalActivity.get();
        throw new ResponseStatusException(HttpStatus.NOT_FOUND,"Nasabah Not Found");
    }

    @Override
    public void deleteActivityById(String id) {
        this.getActivityById(id);
        activityRepository.deleteById(id);
    }
}
