package in.kuros.blog.publisher;

public class Order {

    private String orderNumber;

    public Order() {
    }

    public Order(final String orderNumber) {
        this.orderNumber = orderNumber;
    }

    public void setOrderNumber(final String orderNumber) {
        this.orderNumber = orderNumber;
    }

    public String getOrderNumber() {
        return orderNumber;
    }

    @Override
    public String toString() {
        return orderNumber;
    }
}
