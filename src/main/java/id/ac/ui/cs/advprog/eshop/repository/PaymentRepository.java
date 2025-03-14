package id.ac.ui.cs.advprog.eshop.repository;

import id.ac.ui.cs.advprog.eshop.model.Payment;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class PaymentRepository {
    private List<Payment> paymentData = new ArrayList<>();

    public Payment add(Payment payment) {
        paymentData.add(payment);
        return payment;
    }

    public Payment update(Payment payment) {
        Payment savedPayment = findById(payment.getId());
        if (savedPayment == null) {
            return null;
        }
        paymentData.remove(savedPayment);
        paymentData.add(payment);
        return payment;
    }

    public Payment findById(String id) {
        for (Payment payment : paymentData) {
            if (payment.getId().equals(id)) {
                return payment;
            }
        }
        return null;
    }

    public List<Payment> findAll() {
        return new ArrayList<>(paymentData);
    }
}