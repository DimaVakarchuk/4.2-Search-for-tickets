package ru.netology.manager;

import lombok.AllArgsConstructor;
import ru.netology.domain.Tickets;
import ru.netology.repository.Repository;

import java.util.Arrays;

@AllArgsConstructor

public class Manager {
    private final Repository list;

    public Tickets[] findAll(String from, String to) {
        Tickets[] newList = new Tickets[0];
        for (Tickets ticket : list.getAll()) {
            if (ticket.getAirportArrival().equals(to) && ticket.getAirportDeparture().equals(from)) {
                Tickets[] tmp = new Tickets[newList.length + 1];
                System.arraycopy(newList, 0, tmp, 0, newList.length);
                tmp[tmp.length - 1] = ticket;
                newList = tmp;
            }
        }
        Arrays.sort(newList);
        return newList;
    }
}

