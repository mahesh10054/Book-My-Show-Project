package com.example.BookMyShow.Controller;

import com.example.BookMyShow.RequestDTOs.AddShowRequest;
import com.example.BookMyShow.RequestDTOs.AddShowSeatRequest;
import com.example.BookMyShow.Services.ShowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/show")
public class ShowController {
    @Autowired
    ShowService showService;

    @PostMapping("/addShow")
    public ResponseEntity addShow(@RequestBody AddShowRequest addShowRequest)
    {
        String result = showService.addShow(addShowRequest);

        return new ResponseEntity(result, HttpStatus.OK);
    }

    @PostMapping("/createShowSeats")
    public ResponseEntity createShowSeats(@RequestBody AddShowSeatRequest addShowSeatsRequest)
    {
        String result = showService.createShowSeats(addShowSeatsRequest);

        return new ResponseEntity(result,HttpStatus.OK);
    }
}
