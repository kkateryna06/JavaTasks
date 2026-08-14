package day02.task03;

public class EmailSender implements MessageSender{
    @Override
    public void sendMessage(String recipient, String message) {
        if (recipient != null && !recipient.isBlank()) {
            System.out.println("New email to " + recipient + ": " + message);
        } else {
            throw new IllegalArgumentException("Recipient must be specified");
        }
    }
}
