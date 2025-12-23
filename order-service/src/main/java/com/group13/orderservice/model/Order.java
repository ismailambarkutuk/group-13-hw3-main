package com.group13.orderservice.model;

/**
 * Domain model representing an Order in the online shopping system.
 *
 * <p>This model is intentionally simple for a microservices prototype:
 * it carries only the fields required to demonstrate the Order → Payment flow.</p>
 *
 * <p>Typical lifecycle statuses:
 * CREATED → (PAID | FAILED | PAYMENT_ERROR)</p>
 */
public class Order {

    /** Unique identifier of the order. */
    private Long id;

    /** Name of the product being purchased. */
    private String productName;

    /** Total price to be paid for this order. */
    private double price;

    /**
     * Current order status.
     * Expected values: CREATED, PAID, FAILED, PAYMENT_ERROR
     */
    private String status;

    /** Default constructor required for serialization/deserialization. */
    public Order() {
        // Intentionally empty.
    }

    /**
     * Constructs an Order with all fields.
     *
     * @param id          unique order id
     * @param productName product name
     * @param price       total price
     * @param status      current status
     */
    public Order(Long id, String productName, double price, String status) {
        this.id = id;
        this.productName = productName;
        this.price = price;
        this.status = status;
    }

    /** @return order id */
    public Long getId() {
        return id;
    }

    /** @param id order id */
    public void setId(Long id) {
        this.id = id;
    }

    /** @return product name */
    public String getProductName() {
        return productName;
    }

    /** @param productName product name */
    public void setProductName(String productName) {
        this.productName = productName;
    }

    /** @return total price */
    public double getPrice() {
        return price;
    }

    /** @param price total price */
    public void setPrice(double price) {
        this.price = price;
    }

    /** @return current order status */
    public String getStatus() {
        return status;
    }

    /** @param status current order status */
    public void setStatus(String status) {
        this.status = status;
    }
}