package com.project.oglasnik.sales.domain.repository;

import com.project.oglasnik.sales.domain.model.Payment;
import com.project.oglasnik.sales.domain.model.PaymentId;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface PaymentRepository extends CrudRepository<Payment, PaymentId> {
    List<Payment> findAll();
    Payment findByPaymentId(PaymentId id);
}