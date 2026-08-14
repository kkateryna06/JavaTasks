package day02.task03;

public class Task03 {
    public static void main(String[] args) {
        NotificationService emailService = new NotificationService(new EmailSender());
        NotificationService smsService = new NotificationService(new SmsSender());

        emailService.notifyUser("Katya", "aaaa");
        smsService.notifyUser("Ben", "qqqa");
    }
}
