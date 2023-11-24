package com.example.BookMyShow.Controller;

import com.example.BookMyShow.Models.Ticket;
import com.example.BookMyShow.RequestDTOs.BookTicketRequest;
import com.example.BookMyShow.Services.TicketService;
import com.example.BookMyShow.Transformers.TicketTransformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

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
    @GetMapping("/getTicket")
    public ResponseEntity<?> getTicket(@RequestParam String email) throws Exception
    {
            ResponseEntity ticketTransformer = ticketService.getTicket(email);

            return ticketTransformer;
    }
}
