package day05.task2;

import java.util.List;

public class NumberUtils {
    public static <T extends Number> double sum(List<T> numbers) {
        if (numbers == null) throw new IllegalArgumentException("Numbers can't be null");

        double res = 0;
        for (T i : numbers) {
            if (i == null) throw new IllegalArgumentException("Numbers can't contain null");
            res += i.doubleValue();
        }
        return res;
    }

    public static <T extends Comparable<T>> T max(List<T> elements) {
        if (elements == null) throw new IllegalArgumentException("Elements can't be null");
        if (elements.isEmpty()) throw new IllegalArgumentException("Elements can't be empty");

        T res = elements.getFirst();
        for (T elem : elements) {
            if (elem == null) throw new IllegalArgumentException("Elements can't contain null");
            if (elem.compareTo(res) > 0) {
                res = elem;
            }
        }
        return res;
    }
}
