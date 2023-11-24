package com.example.BookMyShow.Models;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@Entity
@Table(name = "ticket")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Ticket {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer ticketID;
    private String movieName;
    private Integer totalPrice;
    private String bookedSeats;
    private LocalDate showDate;
    private LocalTime showTime;
    private String theaterAddress;

    @JoinColumn
    @ManyToOne
    private Show show;


    @JoinColumn
    @ManyToOne
    private User user;

}
