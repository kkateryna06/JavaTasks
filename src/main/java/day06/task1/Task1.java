package day06.task1;

public class Task1 {
    public static void main(String[] args) {
        SupportDesk supportDesk = new SupportDesk();
        supportDesk.accept(new SupportTicket(1, "Bob", "Problem1"));
        supportDesk.accept(new SupportTicket(2, "Mary", "Problem2"));
        supportDesk.accept(new SupportTicket(3, "Steve", "Problem3"));

        System.out.println(supportDesk.viewNext());
        System.out.println(supportDesk.viewNext());

        System.out.println(supportDesk.hasTickets());

        System.out.println(supportDesk.waitingCount());
        System.out.println(supportDesk.processNext());
        System.out.println(supportDesk.waitingCount());
        System.out.println(supportDesk.processNext());
        System.out.println(supportDesk.waitingCount());
        System.out.println(supportDesk.viewNext());

        System.out.println(supportDesk.processNext());
        System.out.println(supportDesk.viewNext());
        System.out.println(supportDesk.hasTickets());
        System.out.println(supportDesk.processNext());

        try {
            supportDesk.accept(null);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}
