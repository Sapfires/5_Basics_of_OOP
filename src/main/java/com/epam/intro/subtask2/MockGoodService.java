package com.epam.intro.subtask2;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Service
public class MockGoodService {
    public List<Payment.Good> generateGoods(int amount) {
        return IntStream.range(0, amount)
                .boxed()
                .map(it -> Payment.Good.builder()
                        .name(UUID.randomUUID().toString().substring(1, 5))
                        .minAmount(1)
                        .price(it)
                        .build())
                .collect(Collectors.toList());
    }
}
