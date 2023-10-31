package com.example.BookMyShow.Models;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "user")
@Builder
public class User {

    private String userName;
    private String mobileNo;
    private int age;
    private String email;
}
