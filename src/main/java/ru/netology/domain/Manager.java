package ru.netology.domain;

import java.util.Arrays;

public class Manager {
    private Ticket[] tickets = new Ticket[0];

    public void addTicket (Ticket ticket) {
        Ticket[] tmp = new Ticket[tickets.length + 1];
        System.arraycopy(tickets, 0, tmp, 0, tickets.length);
        tmp[tmp.length - 1] = ticket;
        tickets = tmp;
    }

    public Ticket[] findTickets (int minPrice, int maxPrice) {
        Ticket[] result = new Ticket[0];
        for (Ticket ticket : tickets) {
            if (ticket.getPrice() >= minPrice && ticket.getPrice() <= maxPrice) {
                Ticket[] tmp = new Ticket[result.length + 1];
                System.arraycopy(result, 0, tmp, 0, result.length);
                tmp[tmp.length - 1] = ticket;
                result = tmp;
            }
        }
        Arrays.sort(result);
        return result;
    }

}