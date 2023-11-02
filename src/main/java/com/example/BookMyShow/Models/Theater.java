package com.example.BookMyShow.Models;

import com.example.BookMyShow.Enums.City;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "theater")
@Builder
public class Theater {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer theaterId;
    private String name;
    private String address;
    @Enumerated(value = EnumType.STRING)
    private City city;

    @OneToMany(mappedBy = "theater",cascade = CascadeType.ALL)
    private List<TheaterSeats> theaterSeats = new ArrayList<>();

    @OneToMany(mappedBy = "theater",cascade = CascadeType.ALL)
    private List<Show> showList = new ArrayList<>();

}
