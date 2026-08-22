package day05.task2;

import java.util.ArrayList;
import java.util.List;

public class Task2 {
    public static void main(String[] args) {
        // sum
        System.out.println(NumberUtils.sum(List.of(1, 2, 3, 4)));
        System.out.println(NumberUtils.sum(List.of(1.1, 2.1, 3.1)));
        System.out.println(NumberUtils.sum(new ArrayList<>()));

        try {
            NumberUtils.sum(null);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

        try {
            List<Integer> integers = new ArrayList<>();
            integers.add(1); integers.add(2); integers.add(null);
            NumberUtils.sum(integers);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

        // compare to
        System.out.println(NumberUtils.max(List.of(1, 2, 8, 10, 1)));
        System.out.println(NumberUtils.max(List.of("a", "b", "abc", "def")));
        System.out.println(NumberUtils.max(List.of(1)));

        try {
            NumberUtils.max(new ArrayList<Integer>());
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

        try {
            NumberUtils.max(null);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

        try {
            List<Integer> integers = new ArrayList<>();
            integers.add(1); integers.add(2); integers.add(null);
            NumberUtils.max(integers);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}
