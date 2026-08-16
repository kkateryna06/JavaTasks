package day03.task2;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WordCounter {
    private final Map<String, Integer> wordCounts;

    WordCounter() {
        this.wordCounts = new HashMap<>();
    }

    public void addWord(String word) {
        if (word == null || word.isBlank()) {
            throw new IllegalArgumentException("Word can't be null or blank");
        }
        word = word.toLowerCase();
        wordCounts.put(word, wordCounts.getOrDefault(word, 0) + 1);
    }

    public void addWords(List<String> words) {
        if (words == null) {
            throw new IllegalArgumentException("Words can't be null");
        } else {
            for (String word : words) {
                addWord(word);
            }
        }
    }

    public int getCount(String word) {
        if (word == null || word.isBlank()) {
            throw new IllegalArgumentException("Word can't be null or blank");
        } else {
            return wordCounts.getOrDefault(word.toLowerCase(), 0);
        }
    }

    public String getMostFrequentWord() {
        if (wordCounts.isEmpty()) {
            throw new IllegalStateException("WordCounts is empty");
        } else {
            String word = "";
            int bestCount = 0;

            for (String key : wordCounts.keySet()) {
                if (wordCounts.get(key) > bestCount) {
                    word = key;
                    bestCount = wordCounts.get(key);
                }
            }

            return word;
        }
    }

    public Map<String, Integer> getAllCounts() {
        return new HashMap<>(wordCounts);
    }
}
