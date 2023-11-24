package com.example.BookMyShow.Transformers;

import com.example.BookMyShow.Models.Show;
import com.example.BookMyShow.RequestDTOs.AddShowRequest;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class TicketTransformer {

    private String userName;
    private String movieName;
    private Integer totalPrice;
    private String bookedSeats;
    private LocalDate showDate;
    private LocalTime showTime;
    private String theaterAddress;


}
