package com.project.oglasnik.sales.controller;

import com.project.oglasnik.sales.domain.events.PaymentAdded;
import com.project.oglasnik.sales.domain.events.PaymentDeleted;
import com.project.oglasnik.sales.domain.model.PaymentId;
import com.project.oglasnik.sales.domain.repository.CompanyRepository;
import com.project.oglasnik.sales.domain.model.Payment;
import com.project.oglasnik.sales.domain.repository.PaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.web.bind.annotation.*;
import com.project.oglasnik.sales.domain.events.CompanyCreated;

import javax.validation.constraints.NotNull;
import java.time.Instant;
import java.util.List;

@RestController
public class PaymentController {

    @Autowired
    PaymentRepository paymentRepository;
    ApplicationEventPublisher eventPublisher;

    @RequestMapping("/payments")
    public List<Payment> getAllPaymenets()
    {
        return paymentRepository.findAll();
    }

    @RequestMapping("/payment/{paymentId}")
    public Payment getPayment(@PathVariable @NotNull PaymentId paymentId) {
        return paymentRepository.findByPaymentId(paymentId);
    }

    @RequestMapping(method= RequestMethod.POST, value="/payments")
    public void addPayment(@RequestBody Payment payment) {
        eventPublisher.publishEvent(new PaymentAdded(payment.getId(), Instant.now()));
        paymentRepository.save(payment);
    }

    @RequestMapping(method= RequestMethod.DELETE, value="/payment/{paymentId}")
    public void deletePayment(@PathVariable PaymentId paymentId, @RequestBody Payment payment) {
        eventPublisher.publishEvent(new PaymentDeleted(payment.getId(), Instant.now()));
        Payment newPayment = paymentRepository.findByPaymentId(paymentId);
        paymentRepository.delete(newPayment);
    }
}