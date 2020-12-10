package ru.netology.domain;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class Tickets implements Comparable<Tickets> {
    private int id;
    private int price;
    private String airportArrival;
    private String airportDeparture;
    private int travelTime;

    @Override
    public int compareTo(Tickets o) {
        return price - o.getPrice();
    }

}
