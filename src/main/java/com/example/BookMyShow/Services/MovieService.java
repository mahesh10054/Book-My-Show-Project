package com.example.BookMyShow.Services;

import com.example.BookMyShow.Models.Movie;
import com.example.BookMyShow.Repository.MovieRepository;
import com.example.BookMyShow.RequestDTOs.AddMovieRequest;
import com.example.BookMyShow.Transformers.MovieTransformers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MovieService {

    @Autowired
    MovieRepository movieRepository;

    public String addMovie(AddMovieRequest addMovieRequest) throws Exception{

        Movie movie = MovieTransformers.convertAddMovieRequestToEntity(addMovieRequest);

        movieRepository.save(movie);

        return "Movie Added Successfully On to the DB";
    }
}
