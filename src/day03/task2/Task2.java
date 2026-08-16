package day03.task2;

import java.util.List;

public class Task2 {
    public static void main(String[] args) {
        WordCounter wordCounter = new WordCounter();

        // add words
        wordCounter.addWords(List.of("Java", "Spring", "java", "JAVA", "SQL", "spring"));

        // get count
        System.out.println(wordCounter.getCount("java"));
        System.out.println(wordCounter.getCount("python"));
        try {
            System.out.println(wordCounter.getCount(null));
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

        // all counts
        System.out.println(wordCounter.getAllCounts());

        // most frequent word
        System.out.println(wordCounter.getMostFrequentWord());
    }
}
