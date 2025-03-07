package id.ac.ui.cs.advprog.eshop.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

public class PaymentTest {
    private List<Product> products;
    private Order order;
    private Map<String, String> paymentData;

    @BeforeEach
    void setUp() {
        this.products = new ArrayList<>();

        Product product1 = new Product();
        product1.setProductId("b7b2fc8f-57c2-4fd9-bf69-abb4ad6db208");
        product1.setProductName("Originite Prime");
        product1.setProductQuantity(21);

        Product product2 = new Product();
        product2.setProductId("7d3d1f79-02b9-4f61-9fa2-48ed8a6cd9e0");
        product2.setProductName("Orundum");
        product2.setProductQuantity(100);

        this.products.add(product1);
        this.products.add(product2);

        order = new Order("21c8f5a5-897d-4604-b85f-f8a10edfe087",
                this.products, 1708560000L, "Dokutah");

        paymentData = new HashMap<>();
    }

    @Test
    void testCreatePaymentNullData() {
        assertThrows(IllegalArgumentException.class, () -> new Payment(order.getId(),
                "VOUCHER", null));
    }

    @Test
    void testCreatePaymentDefaultStatus() {
        Payment payment = new Payment(order.getId(), "VOUCHER", paymentData);
        assertEquals("REJECTED", payment.getStatus());
    }

    @Test
    void testCreatePaymentSuccessStatus() {
        Payment payment = new Payment(order.getId(), "VOUCHER", "SUCCESS", paymentData);
        assertEquals("SUCCESS", payment.getStatus());
    }

    @Test
    void testCreatePaymentInvalidStatus() {
        assertThrows(IllegalArgumentException.class, () -> new Payment(order.getId(),
                "Voucher", "CANCELLED", paymentData));
    }

    @Test
    void testUpdatePaymentStatusSuccess() {
        Payment payment = new Payment(order.getId(), "VOUCHER", paymentData);
        payment.setStatus("SUCCESS");
        assertEquals("SUCCESS", payment.getStatus());
    }

    @Test
    void testUpdatePaymentStatusInvalid() {
        Payment payment = new Payment(order.getId(), "VOUCHER", paymentData);
        assertThrows(IllegalArgumentException.class, () -> payment.setStatus("CANCELLED"));
    }
}