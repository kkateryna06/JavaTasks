package day02;

public class Day02 {
    public static void main(String[] args) {
        Order order = new Order();
        System.out.println(order.getStatus());
        order.pay();
        System.out.println(order.getStatus());
        order.ship();
        System.out.println(order.getStatus());
        order.deliver();
        System.out.println(order.getStatus());
        try {
            order.cancel();
        } catch (IllegalStateException e) {
            System.out.print(e.getMessage());
        }


        Shape circle = new Circle("black", 10);
        Shape rectangle = new Rectangle("yellow", 10, 7);
        circle.printInfo();
        rectangle.printInfo();
    }
}

enum OrderStatus {
    NEW, PAID, SHIPPED, DELIVERED, CANCELLED
}
