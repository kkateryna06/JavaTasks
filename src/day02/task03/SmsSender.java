package day02.task03;

class SmsSender implements MessageSender {
    @Override
    public void sendMessage(String recipient, String message) {
        if (recipient != null && !recipient.isBlank()) {
            System.out.println("New sms to " + recipient + ": " + message);
        } else {
            throw new IllegalArgumentException("Recipient must be specified");
        }
    }
}