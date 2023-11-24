package com.example.BookMyShow.Services;

import com.example.BookMyShow.Models.User;
import com.example.BookMyShow.Repository.UserRepository;
import com.example.BookMyShow.RequestDTOs.AddUserRequest;
import com.example.BookMyShow.Transformers.UserTransformers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    UserRepository userRepository;

    public String addUser(AddUserRequest addUserRequest) {

        User user = UserTransformers.convertAddUserRequestToEntity(addUserRequest);

        userRepository.save(user);

        return "User Has Been Added in DB";
    }
}
