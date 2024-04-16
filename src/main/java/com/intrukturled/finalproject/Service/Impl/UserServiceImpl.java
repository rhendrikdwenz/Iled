package com.intrukturled.finalproject.Service.Impl;

import com.intrukturled.finalproject.Entity.Role;
import com.intrukturled.finalproject.Entity.User;
import com.intrukturled.finalproject.Model.request.UserRequest;
import com.intrukturled.finalproject.Repository.UserRepository;
import com.intrukturled.finalproject.Service.UserService;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Service
@NoArgsConstructor
public class UserServiceImpl implements UserService {
    @Autowired

    private UserRepository userRepository;

    @Override
    public User addUser(UserRequest userRequest) {
        Set<Role> roles = new HashSet<>();
        User addUser = User.builder()
                .name(userRequest.getName())
                .address(userRequest.getAddress())
                .email(userRequest.getEmail())
                .roles(roles)
                .build();
        return userRepository.saveAndFlush(addUser);
    }

    @Override
    public User getUserById(String id) {
        Optional<User> optionalCustomer = userRepository.findById(id);
        if (optionalCustomer.isPresent()) return optionalCustomer.get();
        throw new ResponseStatusException(HttpStatus.NOT_FOUND, "User with id : " + id + " Not Found");
    }
}
