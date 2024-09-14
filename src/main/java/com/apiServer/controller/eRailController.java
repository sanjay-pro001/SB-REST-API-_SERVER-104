package com.apiServer.controller;


import com.apiServer.model.PassengerInfo;
import com.apiServer.response.Ticket;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/eRail")

public class eRailController {


        @GetMapping("/pnr/{seatNum}")
        public ResponseEntity<Ticket> getPassengerDetails(@PathVariable("seatNum") String seatNumber){
            Ticket ticket = new Ticket();
            if ("B9-001".equals(seatNumber)){
                ticket.setPassengerName("Anku Kohar");
                ticket.setFrom("Raipur");
                ticket.setTo("Balia");
                ticket.setJourneyDate("20-Oct-2024");
                ticket.setPrice(2389.00);
                ticket.setTrainNumber("12345");
                ticket.setSeatNumber(seatNumber);
                ticket.setTicketStatus("Confirmed");

            }
            return new ResponseEntity<>(ticket,HttpStatus.OK);

        }

        @PostMapping(value = "/book", produces = "application/json", consumes = "application/json")
        public ResponseEntity<Ticket> bookTicket(@RequestBody PassengerInfo passengerInfo){
            Ticket ticket = new Ticket();
            ticket.setPassengerName(passengerInfo.getFirstName() + passengerInfo.getLastName());
            ticket.setFrom(passengerInfo.getFrom());
            ticket.setTo(passengerInfo.getTo());
            ticket.setJourneyDate(passengerInfo.getJourneyDate());
            ticket.setPrice(248485.00);
            ticket.setTrainNumber(passengerInfo.getTrainNumber());
            ticket.setSeatNumber("B-09-55");
            ticket.setTicketStatus("Confirmed");

            return new ResponseEntity<>(ticket, HttpStatus.CREATED);
        }
}
