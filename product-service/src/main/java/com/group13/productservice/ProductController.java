package com.group13.productservice;

import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * REST controller for Product Service.
 *
 * <p>This microservice provides product information.
 * For prototype simplicity, products are stored as an in-memory static list.</p>
 *
 * <p>Endpoints:
 * GET /products → Returns all products
 * GET /products/{id} → Returns a single product by id</p>
 */
@CrossOrigin(origins = "http://localhost:8083")  // ✅ UI (order-service) buradan geliyor
@RestController
@RequestMapping("/products")
public class ProductController {

    /** In-memory product list used for demonstration purposes. */
    private static final List<Map<String, Object>> PRODUCTS = List.of(
            Map.of("id", "p1", "name", "Keyboard", "price", 1200),
            Map.of("id", "p2", "name", "Mouse", "price", 500),
            Map.of("id", "p3", "name", "Monitor", "price", 6500)
    );

    /**
     * Returns all available products.
     *
     * @return list of products
     */
    @GetMapping
    public List<Map<String, Object>> getAllProducts() {
        return PRODUCTS;
    }

    /**
     * Returns product details by product id.
     *
     * @param id product identifier
     * @return product map (id, name, price)
     * @throws RuntimeException if product is not found
     */
    @GetMapping("/{id}")
    public Map<String, Object> getProductById(@PathVariable String id) {
        return PRODUCTS.stream()
                .filter(p -> p.get("id").equals(id))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Product not found"));
    }
}
