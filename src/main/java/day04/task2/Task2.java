package day04.task2;

public class Task2 {
    public static void main(String[] args) {
        Temperature temperature = new Temperature(20);
        Temperature increasedTemperature = temperature.increase(5);
        Temperature decreasedTemperature = temperature.decrease(5);

        System.out.println(temperature.getCelsius());
        System.out.println(increasedTemperature.getCelsius());
        System.out.println(decreasedTemperature.getCelsius());

        try {
            temperature.decrease(300);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

        try {
            temperature.increase(-1);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}
