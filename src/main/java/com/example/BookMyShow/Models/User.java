package com.example.BookMyShow.Models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
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

    @Id
    private Integer userId;
    private String userName;
    private String mobileNo;
    private int age;
    private String email;
}
