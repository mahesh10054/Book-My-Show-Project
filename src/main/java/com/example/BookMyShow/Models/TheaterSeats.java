package com.example.BookMyShow.Models;

import com.example.BookMyShow.Enums.SeatsType;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "theater_seats")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TheaterSeats {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer theaterSeatsId;
    private String seatsNo;

    @Enumerated(value = EnumType.STRING)
    private SeatsType seatsType;

    @ManyToOne
    @JoinColumn
    private Theater theater;

}
