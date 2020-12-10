package ru.netology.repository;

import ru.netology.domain.Tickets;

import java.util.NoSuchElementException;


public class Repository {
    Tickets[] list;

    public Repository(Tickets[] list) {
        this.list = list;
    }

    public Tickets[] getAll() {
        return list;
    }

    Tickets findById(int id) {
        for (Tickets item : list) {
            if (item.getId() == id) {
                return item;
            }
        }
        return null;
    }


    void removeById(int id) {
        Tickets ticketById = findById(id);
        if (ticketById == null) {
            throw new NoSuchElementException();
        } else {

            int length = list.length - 1;
            Tickets[] newArray = new Tickets[length];
            int count = 0;
            for (Tickets ticket : list) {
                if (ticket != ticketById) {
                    newArray[count++] = ticket;
                }
            }
        }
    }


}
