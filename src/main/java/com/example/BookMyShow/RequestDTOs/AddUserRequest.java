package com.example.BookMyShow.RequestDTOs;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
public class AddUserRequest {
    private String userName;
    private String email;
    private String mobileNo;
    private int age;

}
