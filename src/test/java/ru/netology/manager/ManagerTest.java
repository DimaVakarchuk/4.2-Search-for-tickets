package ru.netology.manager;

import org.junit.jupiter.api.Test;
import ru.netology.domain.Tickets;
import ru.netology.repository.Repository;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class ManagerTest {
    Tickets[] list = {new Tickets(1, 5500, "PDL", "LED", 801),
            new Tickets(2, 3000, "TLV", "LED", 589),
            new Tickets(3, 1850, "TLV", "LED", 310),
            new Tickets(4, 1500, "TLV", "LED", 777),
            new Tickets(5, 770, "VKO", "LED", 120)};
    Repository repository = new Repository(list);
    Manager man = new Manager(repository);

    @Test
    void shouldFindAll() {
        Tickets[] expected = {new Tickets(4, 1500, "TLV", "LED", 777),
                new Tickets(3, 1850, "TLV", "LED", 310),
                new Tickets(2, 3000, "TLV", "LED", 589)};
        Tickets[] actual = man.findAll("LED", "TLV");
        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldFirstTicket() {
        Tickets[] expected = {new Tickets(1, 5500, "PDL", "LED", 801)};
        Tickets[] actual = man.findAll("LED", "PDL");
        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldNotFindTicket() {
        Tickets[] actual = man.findAll("LED", "AEW");
        Tickets[] expected = {};
        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldSortByPrice() {
        Tickets[] actual = man.findAll("LED", "TLV");
        Tickets prevTicket = null;
        for (Tickets ticket : actual) {
            if (prevTicket != null) {
                assertTrue(prevTicket.getPrice() < ticket.getPrice());
            }
            prevTicket = ticket;
        }
    }
}

