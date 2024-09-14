package com.apiServer.response;


import lombok.Data;


@Data
public class Ticket {
    private String passengerName;
    private String from;
    private String to;
    private String journeyDate;
    private Double price;
    private String trainNumber;
    private String seatNumber;
    private String ticketStatus;

}
