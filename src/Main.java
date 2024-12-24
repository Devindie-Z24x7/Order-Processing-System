import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        List<Order<? extends PurchaseDetails>> orders = new ArrayList<>();


        // Dummy data for categories
        Category electronics = new Category(1, "Electronics");
        Category groceries = new Category(2, "Groceries");
        Category furniture = new Category(3, "Furniture");
        Category clothing = new Category(4, "Clothing");

        // Dummy data for products
        Product laptop = new Product(1, "Laptop", 1200.00, 50, electronics.getCategoryId());
        Product phone = new Product(2, "Smartphone", 800.00, 100, electronics.getCategoryId());
        Product apple = new Product(3, "Apple", 0.50, 200, groceries.getCategoryId());
        Product sofa = new Product(4, "Sofa", 300.00, 20, furniture.getCategoryId());
        Product tshirt = new Product(5, "T-Shirt", 20.00, 500, clothing.getCategoryId());
        Product tv = new Product(6, "Smart TV", 1500.00, 30, electronics.getCategoryId());

        // Dummy data for customers
        Customer customer1 = new Customer(101, "Alice", "123 Main St", "alice@example.com", "123-456-7890", new ArrayList<>());
        Customer customer2 = new Customer(102, "Bob", "456 Elm St", "bob@example.com", "987-654-3210", new ArrayList<>());
        Customer customer3 = new Customer(103, "Charlie", "789 Oak St", "charlie@example.com", "555-555-5555", new ArrayList<>());
        Customer customer4 = new Customer(104, "Diana", "321 Pine St", "diana@example.com", "444-444-4444", new ArrayList<>());

        // Create specific order details
        OnlinePurchase onlineDetails1 = new OnlinePurchase("123 Main St, Cityville");
        OnlinePurchase onlineDetails2 = new OnlinePurchase("456 Elm St, Townsville");
        InStorePurchase inStoreDetails1 = new InStorePurchase("Downtown Store");
        InStorePurchase inStoreDetails2 = new InStorePurchase("Mall Store");

        // Add different types of orders
        orders.add(new Order<>(1, customer1.getCustomerId(), laptop, 1, LocalDateTime.now().minusDays(3), "Processing", onlineDetails1));
        orders.add(new Order<>(2, customer2.getCustomerId(), phone, 2, LocalDateTime.now().minusDays(2), "Delivered", onlineDetails2));
        orders.add(new Order<>(3, customer3.getCustomerId(), apple, 10, LocalDateTime.now().minusDays(1), "Delivered", inStoreDetails1));
        orders.add(new Order<>(4, customer4.getCustomerId(), sofa, 1, LocalDateTime.now(), "Cancelled", inStoreDetails2));
        orders.add(new Order<>(5, customer1.getCustomerId(), tv, 1, LocalDateTime.now().minusDays(5), "Processing", onlineDetails1));
        orders.add(new Order<>(6, customer2.getCustomerId(), tshirt, 3, LocalDateTime.now().minusDays(7), "Completed", inStoreDetails2));
        orders.add(new Order<>(7, customer3.getCustomerId(), tv, 2, LocalDateTime.now().minusHours(6), "Processing", onlineDetails2));
        orders.add(new Order<>(8, customer4.getCustomerId(), apple, 20, LocalDateTime.now().minusDays(10), "Delivered", inStoreDetails1));

        //sort orders by date
        List<Order<?>> orderSortedByDate = orders.stream()
                .sorted(Comparator.comparing(Order::getTime))
                .toList();
        System.out.println("Orders sorted by Date:");
        orderSortedByDate.forEach(System.out::println);

        // Sort orders by total value (unit price * quantity)
        List<Order<?>> ordersSortedByValue= orders.stream()
                .sorted(Comparator.<Order<?>>comparingDouble(order -> order.getProduct().getUnitPrice() * order.getQuantity()).reversed())
                .toList();
        System.out.println("\nOrders sorted by Total Value:");
        ordersSortedByValue.forEach(order -> {
                    double totalValue = order.getProduct().getUnitPrice() * order.getQuantity();
                    System.out.println(order + " | Total Value: $" + totalValue);});


        //filter processing orders
        List<Order<?>> processingOrders = orders.stream()
                .filter(order -> "Processing".equals(order.getStatus()))
                .toList();

        System.out.println("\nOrders with 'Processing' status:");
        processingOrders.forEach(System.out::println);

        //filter cancelled orders
        List<Order<?>> cancelledOrders = orders.stream()
                .filter(order -> "Cancelled".equals(order.getStatus()))
                .toList();

        System.out.println("\nOrders with 'Cancelled' status:");
        cancelledOrders.forEach(System.out::println);

        //filter order more than $1000
        List<Order<?>> highestValueOrders = orders.stream()
                .filter(order-> order.getProduct().getUnitPrice()*order.getQuantity() >= 1000)
                .toList();

        System.out.println("\nOrders with the highest value");
        highestValueOrders.forEach(order -> {
            double totalValue = order.getProduct().getUnitPrice() * order.getQuantity();
            System.out.println(order + " | Total Value: $" + totalValue);});

        //filter products with category
        List<Order<?>> electronicsOrders = orders.stream()
                .filter(order -> (order.getProduct().getCategoryId() == electronics.getCategoryId()))
                .toList();

        System.out.println("\nOrders with Electronic Items:");
        electronicsOrders.forEach(order -> {
            String productName = order.getProduct().getProductName();
            System.out.println("Order ID: " + order.getOrderId() +
                    ", Customer ID: " + order.getCustomerId() +
                    ", Product Name: " + productName +
                    ", Quantity: " + order.getQuantity() +
                    ", Total Value: $" + (order.getProduct().getUnitPrice() * order.getQuantity()) +
                    ", Status: " + order.getStatus() +
                    ", Order Date: " + order.getTime());
        });

        // Group orders by customer ID
        Map<Integer, List<Order<?>>> ordersByCustomer = orders.stream()
                .collect(Collectors.groupingBy(Order::getCustomerId));

        System.out.println("\nOrders grouped by Customer:");
        ordersByCustomer.forEach((customerId, customerOrders) -> {
            System.out.println("Customer ID: " + customerId);
            customerOrders.forEach(System.out::println);
        });

        // Check if all orders are delivered
        boolean allDelivered = orders.stream()
                .allMatch(order -> "Delivered".equals(order.getStatus()));

        System.out.println("\nAre all orders delivered? " + allDelivered);





    }
    }
