import java.util.List;

public class Customer {
    private int customerId;
    private String customerName;
    private String address;
    private String email;
    private String phone;
    private List<Integer> orders;

    public Customer(int customerId, String customerName, String address, String email, String phone, List<Integer> orders) {
        this.customerId = customerId;
        this.customerName = customerName;
        this.address = address;
        this.email = email;
        this.phone = phone;
        this.orders = orders;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public List<Integer> getOrders() {
        return orders;
    }

    public void setOrders(List<Integer> orders) {
        this.orders = orders;
    }
}
