package day01;

public class Day01 {
    public static void main(String[] args) {
        // Rectangle
        Rectangle rectangle = new Rectangle(5, 3);
        System.out.println(rectangle.calculateArea());
        System.out.println(rectangle.calculatePerimeter());

        rectangle.resize(10, 4);
        System.out.println(rectangle.calculateArea());
        System.out.println(rectangle.calculatePerimeter());

        // Rectangle secondRectangle = new Rectangle(-4, 5);


        // BankAccount
        BankAccount bankAccount1 = new BankAccount(123, "Kate Smith");
        BankAccount bankAccount2 = new BankAccount(124, "Tom Smith", 1000);

        bankAccount1.deposit(500);
        System.out.println(bankAccount1.getBalance());
        bankAccount1.withdraw(100);
        System.out.println(bankAccount1.getBalance());

        bankAccount1.transferTo(200, bankAccount2);
        System.out.println(bankAccount1.getBalance());
        System.out.println(bankAccount2.getBalance());


        // User
        User user = new User();
        User user2 = user;
        user2.renameUser("Gabe");
        replaceUser(user);
        System.out.println(user.getName());
        System.out.println(user2.getName());
    }

    public static void replaceUser (User user) {
        user = new User();
    }
}
