package com.example.BookMyShow.Models;

import com.example.BookMyShow.Enums.SeatsType;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "show_seats")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ShowSeat {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer showSeatsId;

    private String seatNo;
    @Enumerated(value = EnumType.STRING)
    private SeatsType seatsType;
    private Integer cost;
    private boolean isAvailable;
    private boolean isFoodAttached;

    @JoinColumn
    @ManyToOne
    private Show show;
}
