import java.time.LocalDateTime;

public class Order<T extends PurchaseDetails> {
    private int orderId;
    private int customerId;
    private Product product;
    private double quantity;
    private LocalDateTime time;
    private String status;
    private T orderDetails;


    public Order(int orderId, int customerId, Product product, double quantity, LocalDateTime time, String status, T orderDetails) {
        this.orderId = orderId;
        this.customerId = customerId;
        this.product = product;
        this.quantity = quantity;
        this.time = time;
        this.status = status;
        this.orderDetails = orderDetails;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public double getQuantity() {
        return quantity;
    }

    public void setQuantity(double quantity) {
        this.quantity = quantity;
    }

    public LocalDateTime getTime() {
        return time;
    }

    public void setTime(LocalDateTime time) {
        this.time = time;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public T getOrderDetails() {
        return orderDetails;
    }

    public void setOrderDetails(T orderDetails) {
        this.orderDetails = orderDetails;
    }

    @Override
    public String toString() {
        return "Order{" +
                "orderId=" + orderId +
                ", customerId=" + customerId +
                ", product=" + product +
                ", quantity=" + quantity +
                ", time=" + time +
                ", status='" + status + '\'' +
                ", orderDetails=" + orderDetails +
                '}';
    }
}

