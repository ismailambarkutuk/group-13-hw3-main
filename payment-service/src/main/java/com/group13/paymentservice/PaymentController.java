package com.group13.paymentservice;

import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ThreadLocalRandom;

/**
 * REST controller for Payment Service.
 *
 * <p>This microservice simulates payment processing.
 * It receives an orderId and amount, then returns a payment result.</p>
 *
 * <p>Endpoints:
 * POST /payments/pay → Attempts to pay for an order</p>
 */
@RestController
@RequestMapping("/payments")
public class PaymentController {

    /**
     * Processes a payment request.
     *
     * <p>For demo purposes, payment success is randomized (80% success rate)
     * to simulate real-world scenarios where payment may fail.</p>
     *
     * @param req request body containing "orderId" and "amount"
     * @return payment result including paymentId and status
     */
    @PostMapping("/pay")
    public Map<String, Object> pay(@RequestBody Map<String, Object> req) {

        // Extract required request fields.
        Object orderId = req.get("orderId");
        Object amount = req.get("amount");

        // Validate request payload.
        if (orderId == null || amount == null) {
            return Map.of(
                    "status", "FAILED",
                    "message", "orderId and amount are required"
            );
        }

        // Simulate payment result (80% success).
        boolean success = ThreadLocalRandom.current().nextInt(100) < 80;

        // Return payment response.
        return Map.of(
                "paymentId", UUID.randomUUID().toString(),
                "orderId", orderId,
                "amount", amount,
                "status", success ? "SUCCESS" : "FAILED"
        );
    }
}