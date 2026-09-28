package day02;

public class Order {
    private OrderStatus status;

    Order() {
        status = OrderStatus.NEW;
    }

    public OrderStatus getStatus() {
        return status;
    }

    public void pay() {
        if (status == OrderStatus.NEW) {
            status = OrderStatus.PAID;
        } else {
            throw new IllegalStateException("Order status must be NEW");
        }

    }

    public void ship() {
        if (status == OrderStatus.PAID) {
            status = OrderStatus.SHIPPED;
        } else {
            throw new IllegalStateException("Order status must be PAID");
        }
    }

    public void deliver() {
        if (status == OrderStatus.SHIPPED) {
            status = OrderStatus.DELIVERED;
        } else {
            throw new IllegalStateException("Order status must be SHIPPED");
        }
    }

    public void cancel() {
        if (status == OrderStatus.NEW || status == OrderStatus.PAID) {
            status = OrderStatus.CANCELLED;
        } else {
            throw new IllegalStateException("Order status must be NEW or PAID");
        }
    }
}
