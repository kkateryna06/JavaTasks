package day05.task1;

import java.util.ArrayList;
import java.util.List;

public class Task1 {
    public static void main(String[] args) {
        List<String> strings = new ArrayList<>(List.of("hello", "a", "b"));
        List<Integer> integers = new ArrayList<>(List.of(1, 2, 3, 4));

        // get first
        String string = ListUtils.getFirst(strings);
        System.out.println(string);

        int integer = ListUtils.getFirst(integers);
        System.out.println(integer);

        // swap
        ListUtils.swap(strings, 0, 2);
        ListUtils.printList(strings);

        ListUtils.swap(integers, 0, 2);
        ListUtils.printList(integers);

        ListUtils.swap(integers, 1, 1);
        ListUtils.printList(integers);

        // empty list
        try {
            String string1 = ListUtils.getFirst(new ArrayList<>());
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

        try {
            ListUtils.swap(new ArrayList<>(), 0, 2);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

        // null
        try {
            String string1 = ListUtils.getFirst(null);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

        try {
            ListUtils.swap(null, 0, 2);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

        // negative index
        try {
            ListUtils.swap(integers, 0, -1);
        } catch (IndexOutOfBoundsException e) {
            System.out.println(e.getMessage());
        }

        // invalid index
        try {
            ListUtils.swap(integers, 4, 0);
        } catch (IndexOutOfBoundsException e) {
            System.out.println(e.getMessage());
        }

    }
}
