package com.example.BookMyShow.Models;

import com.example.BookMyShow.Enums.City;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
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

    private Integer theaterId;
    private String name;
    private String address;
    private City city;

    @OneToMany(mappedBy = "theater",cascade = CascadeType.ALL)
    private List<TheaterSeats> theaterSeats = new ArrayList<>();
}
