package day05.task3;

import java.util.List;

public class CollectionUtils {
    public static <T> void copy(List<? extends T> source, List<? super T> destination) {
        if (source == null || destination == null)
            throw new IllegalArgumentException("Lists can't be null");

        for (T elem : source) {
            destination.add(elem);
        }
    }
}
