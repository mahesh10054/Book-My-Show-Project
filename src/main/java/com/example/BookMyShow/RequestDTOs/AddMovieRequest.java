package com.example.BookMyShow.RequestDTOs;

import com.example.BookMyShow.Enums.Genre;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AddMovieRequest {
    private String movieName;
    private double rating;
    private Genre genre;
    private LocalDate releaseDate;
}
