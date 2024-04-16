package com.intrukturled.finalproject.Service;

import com.intrukturled.finalproject.Entity.User;
import com.intrukturled.finalproject.Model.request.UserRequest;

public interface UserService {
    User addUser(UserRequest userRequest);
    User getUserById(String id);
}
