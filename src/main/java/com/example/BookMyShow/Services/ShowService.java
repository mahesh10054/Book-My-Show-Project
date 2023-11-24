package com.example.BookMyShow.Services;

import com.example.BookMyShow.Enums.SeatsType;
import com.example.BookMyShow.Models.*;
import com.example.BookMyShow.Repository.*;
import com.example.BookMyShow.RequestDTOs.AddShowRequest;
import com.example.BookMyShow.RequestDTOs.AddShowSeatRequest;
import com.example.BookMyShow.Transformers.ShowTransformers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ShowService {
    @Autowired
    ShowRepository showRepository;
    @Autowired
    TheaterRepository theaterRepository;
    @Autowired
    MovieRepository movieRepository;
    @Autowired
    ShowSeatRepository showSeatRepository;

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

    public String createShowSeats(AddShowSeatRequest showSeatRequest) {

        Show show = showRepository.findById(showSeatRequest.getShowId()).get();
        Theater theater = show.getTheater();
        List<TheaterSeats> theaterSeatsList = theater.getTheaterSeatsList();

        List<ShowSeat> showSeatList = new ArrayList<>();

        for (TheaterSeats theaterSeats : theaterSeatsList)
        {
            ShowSeat showSeat = ShowSeat.builder()
                    .seatNo(theaterSeats.getSeatsNo())
                    .seatsType(theaterSeats.getSeatsType())
                    .isAvailable(true)
                    .isFoodAttached(false)
                    .show(show)
                    .build();

            if(theaterSeats.getSeatsType().equals(SeatsType.CLASSIC))
            {
                showSeat.setCost(showSeatRequest.getPriceOfClassicSeats());
            }
            else {
                showSeat.setCost(showSeatRequest.getPriceOfPremiumSeats());
            }
            showSeatList.add(showSeat);
        }
        show.setShowSeatList(showSeatList);

        showSeatRepository.saveAll(showSeatList);

        return "The Show Seats Have been Saved";
    }
}
