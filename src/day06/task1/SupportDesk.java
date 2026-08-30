package day06.task1;

import java.util.ArrayDeque;
import java.util.Queue;

public class SupportDesk {
    private final Queue<SupportTicket> supportTickets = new ArrayDeque<>();

    public void accept(SupportTicket ticket) {
        if (ticket == null) throw new IllegalArgumentException("Ticket can't be null");

        supportTickets.offer(ticket);
    }

    public SupportTicket viewNext() {
        return supportTickets.peek();
    }

    public SupportTicket processNext() {
        return supportTickets.poll();
    }

    public int waitingCount() {
        return supportTickets.size();
    }

    public boolean hasTickets() {
        return supportTickets.peek() != null;
    }
}
