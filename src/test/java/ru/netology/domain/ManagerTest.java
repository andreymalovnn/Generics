package ru.netology.domain;

import org.testng.annotations.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ManagerTest {
    //5, 1, 3, 2, 4
    Manager manager = new Manager();
    Ticket ticket1 = new Ticket(101, 4480, "GOJ", "SVO", 90);
    Ticket ticket2 = new Ticket(102, 7548, "GOJ", "LED", 120);
    Ticket ticket3 = new Ticket(103, 5237, "GOJ", "SVO", 90);
    Ticket ticket4 = new Ticket(104, 9424, "GOJ", "LED", 120);
    Ticket ticket5 = new Ticket(105, 2926, "GOJ", "KZN", 50);


    @Test
    public void ShouldFindAndSortAllByPrice() {
        manager.addTicket(ticket1);
        manager.addTicket(ticket2);
        manager.addTicket(ticket3);
        manager.addTicket(ticket4);
        manager.addTicket(ticket5);
        Ticket[] actual = manager.findTickets(2926, 9424);
        Ticket[] expected = {ticket5, ticket1, ticket3, ticket2, ticket4};
        assertArrayEquals(actual, expected);
    }

    @Test
    public void ShouldFindAndSortFromMiddleToMaxPrice() {
        manager.addTicket(ticket1);
        manager.addTicket(ticket2);
        manager.addTicket(ticket3);
        manager.addTicket(ticket4);
        manager.addTicket(ticket5);
        Ticket[] actual = manager.findTickets(5237, 9424);
        Ticket[] expected = {ticket3, ticket2, ticket4};
        assertArrayEquals(actual, expected);
    }

    @Test
    public void ShouldFindAndSortFromMinToMiddlePrice() {
        manager.addTicket(ticket1);
        manager.addTicket(ticket2);
        manager.addTicket(ticket3);
        manager.addTicket(ticket4);
        manager.addTicket(ticket5);
        Ticket[] actual = manager.findTickets(2926, 5237);
        Ticket[] expected = {ticket5, ticket1, ticket3};
        assertArrayEquals(actual, expected);
    }

    @Test
    public void ShouldFindOneTicket() {
        manager.addTicket(ticket4);
        Ticket[] actual = manager.findTickets(2926, 9424);
        Ticket[] expected = {ticket4};
        assertArrayEquals(actual, expected);
    }

    @Test
    public void ShouldFindNothing() {
        Ticket[] actual = manager.findTickets(2926, 9424);
        Ticket[] expected = new Ticket[0];
        assertArrayEquals(actual, expected);
    }

}