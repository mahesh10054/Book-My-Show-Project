package com.example.BookMyShow.Models;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Table(name = "shows")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Show {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer showId;
    private LocalDate showDate;
    private LocalTime showTime;

    @ManyToOne
    @JoinColumn
    private Theater theater;

    @ManyToOne
    @JoinColumn
    private  Movie movie;
}
