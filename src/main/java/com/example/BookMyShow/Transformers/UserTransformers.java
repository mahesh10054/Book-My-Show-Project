package com.example.BookMyShow.Transformers;

import com.example.BookMyShow.Models.User;
import com.example.BookMyShow.RequestDTOs.AddUserRequest;

public class UserTransformers {

    public static User convertAddUserRequestToEntity(AddUserRequest addUserRequest)
    {

        User user = User.builder()
                .age(addUserRequest.getAge())
                .email(addUserRequest.getEmail())
                .mobileNo(addUserRequest.getMobileNo())
                .userName(addUserRequest.getUserName())
                .build();

        return user;
    }
}
