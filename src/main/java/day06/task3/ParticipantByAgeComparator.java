package day06.task3;

import java.util.Comparator;

public class ParticipantByAgeComparator implements Comparator<Participant> {
    @Override
    public int compare(Participant o1, Participant o2) {
        int result = Integer.compare(o1.getAge(), o2.getAge());
        if (result == 0) {
            result = Integer.compare(o2.getScore(), o1.getScore());
            if (result == 0) {
                return o1.compareTo(o2);
            }
            return result;
        }
        return result;
    }
}
