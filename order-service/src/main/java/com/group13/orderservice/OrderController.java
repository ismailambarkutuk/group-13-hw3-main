package com.group13.orderservice;

import com.group13.orderservice.model.Order;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.Map;

/**
 * REST controller for Order Service.
 *
 * <p>This service demonstrates microservice-to-microservice communication by
 * creating an order and then calling the Payment Service via REST.</p>
 *
 * <p>Endpoints:
 * POST /orders → Creates an order and triggers payment</p>
 */
@RestController
@RequestMapping("/orders")
public class OrderController {

    /** REST client used to call external services (Payment Service). */
    private final RestTemplate restTemplate = new RestTemplate();

    /**
     * Creates an order and requests payment from Payment Service.
     *
     * <p>Flow:
     * 1) Create a sample Order
     * 2) Call Payment Service (/payments/pay)
     * 3) Update order status according to payment response
     * 4) Return combined result (order + payment)</p>
     *
     * @return a response map containing the order and payment result
     */
    @PostMapping
    public Map<String, Object> createOrder() {

        // 1) Create a sample order (prototype simplification).
        Order order = new Order(
                1L,
                "Laptop",
                1500.0,
                "CREATED"
        );

        // 2) Payment Service endpoint (static URL for prototype).
        String paymentUrl = "http://localhost:8084/payments/pay";

        // 3) Build payment request payload.
        Map<String, Object> paymentRequest = Map.of(
                "orderId", order.getId(),
                "amount", order.getPrice()
        );

        // 4) Call Payment Service and get response.
        Map<String, Object> paymentResponse =
                restTemplate.postForObject(
                        paymentUrl,
                        paymentRequest,
                        Map.class
                );

        // 5) Defensive check: if payment service returns no response.
        if (paymentResponse == null) {
            order.setStatus("PAYMENT_ERROR");
            return Map.of("order", order);
        }

        // 6) Update order status based on payment result.
        String paymentStatus = (String) paymentResponse.get("status");

        if ("SUCCESS".equals(paymentStatus)) {
            order.setStatus("PAID");
        } else {
            order.setStatus("FAILED");
        }

        // 7) Return aggregated response (order + payment).
        return Map.of(
                "order", order,
                "payment", paymentResponse
        );
    }
}