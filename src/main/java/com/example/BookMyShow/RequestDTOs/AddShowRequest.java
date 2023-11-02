package com.example.BookMyShow.RequestDTOs;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AddShowRequest {
    private LocalDate showDate;
    private LocalTime showTime;
    private  String movieName;
    private Integer theaterId;

}
