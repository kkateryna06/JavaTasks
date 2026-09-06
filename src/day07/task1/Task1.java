package day07.task1;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class Task1 {
    public static List<String> filter(
            List<String> values,
            Predicate<String> condition
    ) {
        if (values == null) throw new IllegalArgumentException("Values can't be null");
        if (condition == null) throw new IllegalArgumentException("Condition can't be null");

        List<String> result = new ArrayList<>();
        for (String i : values) {
            if (i == null) throw new IllegalArgumentException("Values can't contain null");
            if (condition.test(i)) result.add(i);
        }

        return result;
    }

    public static void main(String[] args) {
        System.out.println(filter(List.of("aacafsd", "ab", "csasacdcd", "cdef", "asx", "      ", "add"),
                string -> string.length() > 4
        ));

        System.out.println(filter(List.of("Aaaa", "aa", "KkkkK", "ssSss", "aaaA", ""),
                string -> !string.isEmpty() && Character.isUpperCase(string.charAt(0))
        ));

        System.out.println(filter(List.of("ddddda", "xscdss", "Avvvv", "dgdgbAssa"),
                string -> string.toLowerCase().contains("a")
        ));

        System.out.println(filter(new ArrayList<>(), string -> !string.isBlank()));

        System.out.println(filter(List.of("ce", "ab", "sa", "sc", "asx", "adc", "add"),
                string -> string.length() > 4
        ));

        try {
            filter(null, string -> !string.isBlank());
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

        try {
            filter(List.of("a", "b", ""), null);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

        try {
            List<String> list = new ArrayList<>(List.of("a", "b", ""));
            list.add(null);
            filter(list, string -> !string.isBlank());
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}
