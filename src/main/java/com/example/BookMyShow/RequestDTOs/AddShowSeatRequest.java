package com.example.BookMyShow.RequestDTOs;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
public class AddShowSeatRequest {
    private Integer showId;
    private Integer priceOfClassicSeats;
    private Integer priceOfPremiumSeats;
}
