package com.intrukturled.finalproject.Service;

import com.intrukturled.finalproject.Entity.Activity;
import com.intrukturled.finalproject.Model.request.ActivityRequest;

public interface ActivityService {
    Activity addActivity(ActivityRequest activityRequest);

}
