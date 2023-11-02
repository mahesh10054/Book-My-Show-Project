package com.example.BookMyShow.Services;

import com.example.BookMyShow.Models.Movie;
import com.example.BookMyShow.Models.Show;
import com.example.BookMyShow.Models.Theater;
import com.example.BookMyShow.Repository.MovieRepository;
import com.example.BookMyShow.Repository.ShowRepository;
import com.example.BookMyShow.Repository.TheaterRepository;
import com.example.BookMyShow.RequestDTOs.AddShowRequest;
import com.example.BookMyShow.Transformers.ShowTransformers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import javax.swing.text.html.Option;
import java.util.Optional;

@Service
public class ShowService {
    @Autowired
    ShowRepository showRepository;

    @Autowired
    TheaterRepository theaterRepository;

    @Autowired
    MovieRepository movieRepository;

    public String addShow(AddShowRequest addShowRequest)
    {
        Show show = ShowTransformers.convertAddRequestToEntity(addShowRequest);

        Optional<Theater> optionalTheater = theaterRepository.findById(addShowRequest.getTheaterId());
        Theater theater = optionalTheater.get();

        Movie movie = movieRepository.findMovieByMovieName(addShowRequest.getMovieName());

        show.setMovie(movie);
        show.setTheater(theater);

        theater.getShowList().add(show);
        movie.getShowList().add(show);

        showRepository.save(show);

        return "Show has been saved to the DB with showId "+show.getShowId();
    }

    public String createShowSeats(Integer showId) {


    }
}
