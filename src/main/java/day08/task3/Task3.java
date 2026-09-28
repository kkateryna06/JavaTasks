package day08.task3;

public class Task3 {
    public enum ParcelStatus {
        CREATED,
        SENT,
        DELIVERED,
        CANCELLED
    }

    public static class InvalidStatusTransitionException extends RuntimeException {
        public InvalidStatusTransitionException(String message) {
            super(message);
        }
    }

    public static class Parcel {
        private final String trackingNumber;
        private ParcelStatus status;

        public Parcel(String trackingNumber) {
            if (trackingNumber == null || trackingNumber.isBlank())
                throw new IllegalArgumentException("Tracking number can't be null or blank");

            this.trackingNumber = trackingNumber;
            this.status = ParcelStatus.CREATED;
        }

        public void send() {
            if (status != ParcelStatus.CREATED)
                throw new InvalidStatusTransitionException(
                        "Cannot send parcel with status " + status
                );

            status = ParcelStatus.SENT;
        }

        public void deliver() {
            if (status != ParcelStatus.SENT)
                throw new InvalidStatusTransitionException(
                        "Cannot deliver parcel with status " + status
                );

            status = ParcelStatus.DELIVERED;
        }

        public void cancel() {
            if (status != ParcelStatus.CREATED && status != ParcelStatus.SENT)
                throw new InvalidStatusTransitionException(
                        "Cannot cancel parcel with status " + status
                );

            status = ParcelStatus.CANCELLED;
        }

        public ParcelStatus getStatus() {
            return status;
        }
    }

    public static void main(String[] args) {
        Parcel parcel1 = new Parcel("1");
        System.out.println(parcel1.getStatus());
        parcel1.send();
        System.out.println(parcel1.getStatus());
        parcel1.deliver();
        System.out.println(parcel1.getStatus());

        Parcel parcel2 = new Parcel("2");
        System.out.println(parcel2.getStatus());
        parcel2.cancel();
        System.out.println(parcel2.getStatus());

        Parcel parcel3 = new Parcel("3");
        try {
            parcel3.deliver();
        } catch (InvalidStatusTransitionException e) {
            System.out.println(e.getMessage());
        }
        System.out.println(parcel3.getStatus());

        try {
            parcel3.send();
            parcel3.deliver();
            parcel3.cancel();
        } catch (InvalidStatusTransitionException e) {
            System.out.println(e.getMessage());
        }
        System.out.println(parcel3.getStatus());

        try {
            parcel3.cancel();
            parcel3.send();
        } catch (InvalidStatusTransitionException e) {
            System.out.println(e.getMessage());
        }
        System.out.println(parcel3.getStatus());
    }
}
