package com.epam.intro.subtask2;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping("/subtask2")
@RestController
public class SubTask2Controller {
    @Autowired
    private MockGoodService mockGoodService;
    @Autowired
    private PaymentService paymentService;
    @GetMapping("/payment/{amount}")
    public String generatePayment(@PathVariable Integer amount) {
        List<Payment.Good> goods = mockGoodService.generateGoods(amount);
        return paymentService.buildPayment(goods).toString();
    }
}
