package com.example.BookMyShow.Controller;

import com.example.BookMyShow.RequestDTOs.BookTicketRequest;
import com.example.BookMyShow.Services.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/ticket")
public class TicketController {
    @Autowired
    TicketService ticketService;


    @PostMapping("/bookTicket")
    public String bookTicket(@RequestBody BookTicketRequest bookTicketRequest)
    {
        return ticketService.bookTicket(bookTicketRequest);
    }
}
