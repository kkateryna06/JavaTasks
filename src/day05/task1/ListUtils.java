package day05.task1;

import java.util.List;

public class ListUtils {
    public static <T> T getFirst(List<T> elements) {
        if (elements == null) throw new IllegalArgumentException("Elements can't be null");
        else if (elements.isEmpty()) throw new IllegalArgumentException("Elements can't be empty");

        return elements.get(0);
    }

    public static <T> void swap(List<T> elements, int firstIndex, int secondIndex) {
        if (elements == null) throw new IllegalArgumentException("Elements can't be null");
        else if (elements.isEmpty()) throw new IllegalArgumentException("Elements can't be empty");
        else if (firstIndex > elements.size() - 1 || secondIndex > elements.size() - 1
            || firstIndex < 0 || secondIndex < 0)
            throw new IndexOutOfBoundsException("Index is out of bounds");
        T temp = elements.get(firstIndex);
        elements.set(firstIndex, elements.get(secondIndex));
        elements.set(secondIndex, temp);
    }

    public static <T> void printList(List<T> list) {
        for (T i : list) {
            System.out.print(i + " ");
        }
        System.out.println();
    }
}
