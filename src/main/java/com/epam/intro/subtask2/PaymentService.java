package com.epam.intro.subtask2;

import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class PaymentService {
    public Payment buildPayment(List<Payment.Good> goods) {
        Payment payment = new Payment();
        goods.forEach(it -> {
            Integer amount = payment.getGoods().get(it);
            payment.getGoods().put(it, amount == null ? it.getMinAmount() : amount + it.getMinAmount());
        });
        return payment;
    }
}
