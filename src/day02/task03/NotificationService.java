package day02.task03;

public class NotificationService {
    private final MessageSender messageSender;

    NotificationService(MessageSender messageSender) {
        if (messageSender != null) {
            this.messageSender = messageSender;
        } else {
            throw new IllegalArgumentException("Message sender is required");
        }

    };

    public void notifyUser(String recipient, String message) {
        messageSender.sendMessage(recipient, message);
    }
}
