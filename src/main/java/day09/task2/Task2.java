package day09.task2;

import org.apache.commons.lang3.StringUtils;

public class Task2 {
    public static class TextNormalizer {
        public static String normalize(String rawText) {
            if (StringUtils.isBlank(rawText)) {
                throw new IllegalArgumentException("String can't be null or blank");
            }

            return StringUtils.normalizeSpace(rawText);
        }
    }

    public static void main(String[] args) {
        System.out.println(TextNormalizer.normalize("  Hello   Java  "));
        System.out.println(TextNormalizer.normalize("Hello\t\nworld"));
        System.out.println(TextNormalizer.normalize("Java"));
        try {
            System.out.println(TextNormalizer.normalize(null));
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
        try {
            System.out.println(TextNormalizer.normalize(""));
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
        try {
            System.out.println(TextNormalizer.normalize(" \t\n "));
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}
