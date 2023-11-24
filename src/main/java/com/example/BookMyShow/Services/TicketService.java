package com.example.BookMyShow.Services;

import com.example.BookMyShow.Models.*;
import com.example.BookMyShow.Repository.*;
import com.example.BookMyShow.RequestDTOs.BookTicketRequest;
import com.example.BookMyShow.Transformers.TicketTransformer;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TicketService {
    @Autowired
    TicketRepository ticketRepository;
    @Autowired
    ShowRepository showRepository;
    @Autowired
    TheaterRepository theaterRepository;
    @Autowired
    MovieRepository movieRepository;
    @Autowired
    UserRepository userRepository;

    public String bookTicket(BookTicketRequest bookTicketRequest)
    {
        Show show = findRightShow(bookTicketRequest);
        if(show == null)
        {
            return "Show not found!!!!";
        }
        List<ShowSeat> showSeatList = show.getShowSeatList();

        int totalPrice = 0;
        for(ShowSeat showSeat : showSeatList)
        {
            if(bookTicketRequest.getRequestSetNos().contains(showSeat.getSeatNo()))
            {
                showSeat.setAvailable(false);
                totalPrice += showSeat.getCost();
            }
        }
        User user = userRepository.findById(bookTicketRequest.getUserId()).get();

        Ticket ticket = Ticket.builder()
                .movieName(show.getMovie().getMovieName())
                .theaterAddress(show.getTheater().getAddress())
                .showDate(show.getShowDate())
                .showTime(show.getShowTime())
                .bookedSeats(bookTicketRequest.getRequestSetNos().toString())
                .user(user)
                .show(show)
                .totalPrice(totalPrice)
                .build();

        show.getTicketList().add(ticket);
        user.getTicketList().add(ticket);

        ticketRepository.save(ticket);

        return "Ticket Has Been Booked";
    }
    public Show findRightShow(BookTicketRequest bookTicketRequest)
    {
        Theater theater = theaterRepository.findById(bookTicketRequest.getTheaterId()).get();
        Movie movie = movieRepository.findMovieByMovieName(bookTicketRequest.getMovieName());

        Show show = showRepository.findShowByShowDateAndShowTimeAndMovieAndTheater(bookTicketRequest.getShowDate(),bookTicketRequest.getShowTime(),movie,theater);

        return show;
    }

    public ResponseEntity<?> getTicket(String email) throws Exception{
        User user = userRepository.findUserByEmail(email);

        if(user == null) return ResponseEntity.ofNullable("User Not found");

        List<Ticket> ticketList = user.getTicketList();
        List<TicketTransformer> ticketTransformerList = new ArrayList<>();
        for(Ticket ticket : ticketList)
        {
            if(email.equals(ticket.getUser().getEmail()))
            {
                TicketTransformer ticketTransformer = new TicketTransformer();

                ticketTransformer.setUserName(ticket.getUser().getUserName());
                ticketTransformer.setMovieName(ticket.getMovieName());
                ticketTransformer.setTotalPrice(ticket.getTotalPrice());
                ticketTransformer.setTheaterAddress(ticket.getTheaterAddress());
                ticketTransformer.setShowTime(ticket.getShowTime());
                ticketTransformer.setShowDate(ticket.getShowDate());
                ticketTransformer.setBookedSeats(ticket.getBookedSeats());

                ticketTransformerList.add(ticketTransformer);
            }
        }
        if(ticketTransformerList.size() == 0) return ResponseEntity.ok("Please Book Ticket First!!!!");

        return  ResponseEntity.ok(ticketTransformerList);
    }
}
