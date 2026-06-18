package com.userservice.service;

import com.userservice.entity.User;
import com.userservice.exception.ResourceNotFoundException;
import com.userservice.models.UserRequest;
import com.userservice.models.UserResponse;
import com.userservice.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    private UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User saveUser(UserRequest userRequest) {
        User user = new User(userRequest.name(), userRequest.email());
        return userRepository.save(user);
    }

    public UserResponse getUserById(long id) {
        User user = userRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("User with Id "+ id +" not found"));
        UserResponse userResponse = new UserResponse(user.getId(),user.getName(),user.getEmail());
        return userResponse;
    }

    public List<UserResponse> getAllUsers() {
        List<User> users = userRepository.findAll();
        List<UserResponse> userResponseList = new ArrayList<>();
        for(User user : users){
            userResponseList.add(new UserResponse(user.getId(),user.getName(),user.getEmail()));
        }
        return userResponseList;
    }

    public void deleteByUserId(long id) {
        userRepository.deleteById(id);
    }

    public UserResponse updateUser(long id, UserRequest userRequest) {
        User user = userRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("User with Id "+ id +" not found"));
        user.setName(userRequest.name());
        user.setEmail(userRequest.email());
        User updatedUser = userRepository.save(user);
        return new UserResponse(updatedUser.getId(),updatedUser.getName(),updatedUser.getEmail());
    }
}
