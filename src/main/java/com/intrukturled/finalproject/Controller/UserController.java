package com.intrukturled.finalproject.Controller;

import com.intrukturled.finalproject.Entity.User;
import com.intrukturled.finalproject.Model.request.UserRequest;
import com.intrukturled.finalproject.Model.response.WebResponse;
import com.intrukturled.finalproject.Service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;
    @PostMapping
    public ResponseEntity<?> addUser(@Valid @RequestBody UserRequest userRequest) {
        User newUser = userService.addUser(userRequest);
        WebResponse<User> response = WebResponse.<User>builder()
                .status(HttpStatus.CREATED.getReasonPhrase())
                .message("Success add data")
                .data(newUser)
                .build();
        return ResponseEntity.ok(response);
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<?> getUserById(@PathVariable String id) {
        User findUser = userService.getUserById(id);
        WebResponse<User> response = WebResponse.<User>builder()
                .status(HttpStatus.OK.getReasonPhrase())
                .message("Success Get By Id ")
                .data(findUser)
                .build();
        return ResponseEntity.ok(response);
    }
}
