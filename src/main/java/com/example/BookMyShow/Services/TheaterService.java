package com.example.BookMyShow.Services;

import com.example.BookMyShow.Enums.SeatsType;
import com.example.BookMyShow.Models.Theater;
import com.example.BookMyShow.Models.TheaterSeats;
import com.example.BookMyShow.Repository.TheaterRepository;
import com.example.BookMyShow.RequestDTOs.AddTheaterRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TheaterService {

    @Autowired
    TheaterRepository theaterRepository;


    public String addTheater(AddTheaterRequest addTheaterRequest)
    {
        Theater theater = Theater.builder().name(addTheaterRequest.getName())
                .address(addTheaterRequest.getAddress())
                .city(addTheaterRequest.getCity())
                .build();

        createTheaterSeats(theater,addTheaterRequest);

        return "Theater and Seats has been saved to DB";
    }
    public void createTheaterSeats(Theater theater,AddTheaterRequest addTheaterRequest)
    {
        int noOfClassicSeats = addTheaterRequest.getNoOfClassicSeats();
        int noOfPremiumSeats = addTheaterRequest.getNoOfPremiumSeats();
        int noOfSeatsPerRow = addTheaterRequest.getNoOfSeatsPerRow();

        List<TheaterSeats> theaterSeatsList = new ArrayList<>();
        int row = 0;
        char ch = 'A';

        for(int i=1;i<=noOfClassicSeats;i++)
        {
            if(i%noOfSeatsPerRow == 1)
            {
                row++;
                ch = 'A';
            }
            String seatNo = row+""+ch;
            ch++;

            TheaterSeats theaterSeats = TheaterSeats.builder()
                    .seatsNo(seatNo)
                    .seatsType(SeatsType.CLASSIC)
                    .theater(theater)
                    .build();
            theaterSeatsList.add(theaterSeats);
        }

        //i will do for the premium seats
        ch = 'A';
        for(int i=1;i<=noOfPremiumSeats;i++)
        {
            if(i%noOfSeatsPerRow == 1)
            {
                row++;
                ch = 'A';
            }
            String seatNo = row+""+ch;
            ch = (char) (ch+1);


            TheaterSeats theaterSeats = TheaterSeats.builder()
                    .seatsNo(seatNo)
                    .seatsType(SeatsType.PREMIUM)
                    .theater(theater)
                    .build();
            theaterSeatsList.add(theaterSeats);
        }
        theaterRepository.save(theater);
    }
}
