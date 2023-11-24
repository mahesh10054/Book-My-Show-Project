package com.example.BookMyShow.Transformers;

import com.example.BookMyShow.Models.Movie;
import com.example.BookMyShow.RequestDTOs.AddMovieRequest;

public class MovieTransformers {
    public static Movie convertAddMovieRequestToEntity(AddMovieRequest addMovieRequest)
    {
        Movie movie = Movie.builder()
                .movieName(addMovieRequest.getMovieName())
                .genre(addMovieRequest.getGenre())
                .releaseDate(addMovieRequest.getReleaseDate())
                .rating(addMovieRequest.getRating())
                .build();

        return movie;
    }
}
