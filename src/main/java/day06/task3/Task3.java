package day06.task3;

import java.util.ArrayList;
import java.util.List;

public class Task3 {
    public static void main(String[] args) {
        Participant participant1 = new Participant(1, "Bob", 100, 19);
        Participant participant2 = new Participant(2, "Kate", 50, 22);
        Participant participant3 = new Participant(3, "Pam", 10, 21);
        Participant participant4 = new Participant(4, "Josh", 95, 38);
        Participant participant5 = new Participant(5, "Kate", 50, 19);

        List<Participant> participants = new ArrayList<>
                (List.of(participant1, participant4, participant2, participant5, participant3));

        // Comparable
        System.out.println("Comparable");
        System.out.println("Participant1 & participant2: " + participant1.compareTo(participant2));
        System.out.println("Participant2 & participant3: " + participant2.compareTo(participant3));
        System.out.println("Participant4 & participant2: " + participant4.compareTo(participant2));
        System.out.println("Participant3 & participant1: " + participant3.compareTo(participant1));
        System.out.println("Participant5 & participant5: " + participant5.compareTo(participant5));

        participants.sort(null);
        for (Participant participant : participants) System.out.print(participant.getId() + " ");

        System.out.println();
        System.out.println();

        // By score
        ParticipantByScoreComparator participantByScoreComparator = new ParticipantByScoreComparator();
        System.out.println("Compare by score");
        System.out.println("Participant1 & participant3: " +
                participantByScoreComparator.compare(participant1, participant3));
        System.out.println("Participant3 & participant4: " +
                participantByScoreComparator.compare(participant3, participant4));
        System.out.println("Participant4 & participant1: " +
                participantByScoreComparator.compare(participant4, participant1));
        System.out.println("Participant5 & participant4: " +
                participantByScoreComparator.compare(participant5, participant4));
        System.out.println("Participant1 & participant1: " +
                participantByScoreComparator.compare(participant1, participant1));

        participants.sort(new ParticipantByScoreComparator());
        for (Participant participant : participants) System.out.print(participant.getId() + " ");

        System.out.println();
        System.out.println();

        // By age
        System.out.println("Compare by age");
        ParticipantByAgeComparator participantByAgeComparator = new ParticipantByAgeComparator();
        System.out.println("Participant1 & participant5: " +
                participantByAgeComparator.compare(participant1, participant5));
        System.out.println("Participant2 & participant4: " +
                participantByAgeComparator.compare(participant2, participant4));
        System.out.println("Participant5 & participant2: " +
                participantByAgeComparator.compare(participant5, participant2));
        System.out.println("Participant4 & participant1: " +
                participantByAgeComparator.compare(participant4, participant1));
        System.out.println("Participant4 & participant4: " +
                participantByAgeComparator.compare(participant4, participant4));

        participants.sort(new ParticipantByAgeComparator());
        for (Participant participant : participants) System.out.print(participant.getId() + " ");

        System.out.println();
        System.out.println();

        // By name
        System.out.println("Compare by name");
        ParticipantByNameComparator participantByNameComparator = new ParticipantByNameComparator();
        System.out.println("Participant1 & participant5: " +
                participantByNameComparator.compare(participant1, participant5));
        System.out.println("Participant2 & participant3: " +
                participantByNameComparator.compare(participant2, participant3));
        System.out.println("Participant5 & participant4: " +
                participantByNameComparator.compare(participant5, participant4));
        System.out.println("Participant2 & participant5: " +
                participantByNameComparator.compare(participant2, participant5));
        System.out.println("Participant5 & participant5: " +
                participantByNameComparator.compare(participant5, participant5));

        participants.sort(new ParticipantByNameComparator());
        for (Participant participant : participants) System.out.print(participant.getId() + " ");
    }
}
