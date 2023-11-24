package com.example.BookMyShow.RequestDTOs;

import com.example.BookMyShow.Enums.City;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
public class AddTheaterRequest {
    private String name;
    private String address;
    private City city;
    private Integer noOfClassicSeats;
    private Integer noOfPremiumSeats;
    private Integer noOfSeatsPerRow;

}
