package com.example.BookMyShow.Controller;

import com.example.BookMyShow.RequestDTOs.AddMovieRequest;
import com.example.BookMyShow.Services.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/movie")
public class MovieController {

    @Autowired
    MovieService movieService;

    @PostMapping("/addMovie")
    public ResponseEntity addMovie(@RequestBody AddMovieRequest addMovieRequest)
    {
        try {
            String result = movieService.addMovie(addMovieRequest);

            return new ResponseEntity<>(result, HttpStatus.OK);
        }catch (Exception e)
        {
            return new ResponseEntity("Please Enter Valid Unic Movie Name",HttpStatus.NOT_FOUND);
        }
    }
    @DeleteMapping("/deleteMovie{movieName}")
    public ResponseEntity deleteMovie(@PathVariable String movieName)
    {
        try {
            String result = movieService.deleteMovie(movieName);

            return new ResponseEntity<>(result, HttpStatus.OK);
        }catch (Exception e)
        {
            return new ResponseEntity("Please Enter Valid Movie Name",HttpStatus.NOT_FOUND);
        }
    }

}
