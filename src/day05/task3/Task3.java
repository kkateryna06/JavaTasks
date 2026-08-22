package day05.task3;

import java.util.ArrayList;
import java.util.List;

public class Task3 {


    public static void main(String[] args) {
        // Integer - Number
        List<Number> numberList = new ArrayList<>();
        List<Integer> integerList = new ArrayList<>(List.of(1, 2, 3));

        CollectionUtils.copy(integerList, numberList);
        System.out.println(numberList);
        System.out.println(integerList);

        // Integer - Object
        List<Object> objectsList = new ArrayList<>();
        CollectionUtils.copy(integerList, objectsList);
        System.out.println(objectsList);

        // Double - Number
        List<Double> doubleList = new ArrayList<>(List.of(1.1, 2.5, 6.1));
        CollectionUtils.copy(doubleList, numberList);
        System.out.println(numberList);

        // String - CharSequence
        List<String> stringList = new ArrayList<>(List.of("a", "b", "abc"));
        List<CharSequence> charSequenceList = new ArrayList<>();
        CollectionUtils.copy(stringList, charSequenceList);
        System.out.println(charSequenceList);

        // empty source
        List<Object> emptyList = new ArrayList<>();
        CollectionUtils.copy(new ArrayList<>(), emptyList);
        System.out.println(emptyList);

        // null source and destination
        try {
            CollectionUtils.copy(null, emptyList);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

        try {
            CollectionUtils.copy(emptyList, null);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

        // source contains null
        integerList.add(null);
        CollectionUtils.copy(integerList, emptyList);
        System.out.println(emptyList);
    }
}
