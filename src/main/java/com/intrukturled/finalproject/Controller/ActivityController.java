package com.intrukturled.finalproject.Controller;

import com.intrukturled.finalproject.Entity.Activity;
import com.intrukturled.finalproject.Model.PagingResponse;
import com.intrukturled.finalproject.Model.WebResponse;
import com.intrukturled.finalproject.Model.request.ActivityRequest;
import com.intrukturled.finalproject.Model.response.ActivityResponse;
import com.intrukturled.finalproject.Service.ActivityService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/activity")
@AllArgsConstructor
public class ActivityController {
    private final ActivityService activityService;
    @PostMapping
    public ResponseEntity<WebResponse<ActivityResponse>> createActivity(@RequestBody ActivityRequest activityRequest){
        ActivityResponse newActivity = activityService.createActivity(activityRequest);
        WebResponse<ActivityResponse> response = WebResponse.<ActivityResponse>builder()
                .status(HttpStatus.CREATED.getReasonPhrase())
                .message("Success Register New Activity")
                .data(newActivity)
                .build();
        return ResponseEntity.ok(response);
    }


    @GetMapping
    public ResponseEntity<?> getAllActivity(
            @RequestParam(defaultValue = "1") Integer page,
            @RequestParam(defaultValue = "10") Integer size
    ){

        Page<Activity> activityList = activityService.getAllActivity(page,size);

        PagingResponse pagingResponse = PagingResponse.builder()
                .page(page)
                .size(size)
                .totalPages(activityList.getTotalPages())
                .totalElements(activityList.getTotalElements())
                .build();

        WebResponse<List<Activity>> response = WebResponse.<List<Activity>>builder()
                .status(HttpStatus.OK.getReasonPhrase())
                .message("Success Get List Activity")
                .paging(pagingResponse)
                .data(activityList.getContent())
                .build();
        return ResponseEntity.ok(response);
    }



    @GetMapping(path = "/{id}")
    public ResponseEntity<?> getActivityById(@PathVariable String id){
        Activity findActivity = activityService.getActivityById(id);
        WebResponse<Activity> response = WebResponse.<Activity>builder()
                .status(HttpStatus.OK.getReasonPhrase())
                .message("Success Get Activity")
                .data(findActivity)
                .build();
        return ResponseEntity.ok(response);
    }


    @DeleteMapping(path = "/{id}")
    public ResponseEntity<?> deleteTrainerById(@PathVariable String id){
        activityService.deleteActivityById(id);
        WebResponse<String> response = WebResponse.<String>builder()
                .status(HttpStatus.OK.getReasonPhrase())
                .message("Success Delete Activity")
                .data("OK")
                .build();
        return ResponseEntity.ok(response);
    }
}
