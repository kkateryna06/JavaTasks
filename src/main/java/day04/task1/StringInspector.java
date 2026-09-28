package day04.task1;

public class StringInspector {
    public static void main(String[] args) {
        String first = "Java";
        String second = "Java";
        String third = new String("Java");
        String fourth = third.intern();

        // true
        System.out.println(first == second);
        // false
        System.out.println(first == third);
        // true
        System.out.println(first.equals(third));
        // true
        System.out.println(first == fourth);
        // false
        System.out.println(third == fourth);

        String language = "java";
        language.toUpperCase();
        // java
        System.out.println(language);

        String languageUpperCase = language.toUpperCase();
        // JAVA
        System.out.println(languageUpperCase);
    }
}
