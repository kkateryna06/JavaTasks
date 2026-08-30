package day06.task3;

import java.util.Comparator;

public class ParticipantByNameComparator implements Comparator<Participant> {
    @Override
    public int compare(Participant o1, Participant o2) {
        int result = o1.getName().compareTo(o2.getName());
        if (result == 0) {
            return o1.compareTo(o2);
        }
        return result;
    }
}
