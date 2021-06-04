package com.epam.intro.subtask2;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

@Data
@NoArgsConstructor
public class Payment {
    private Map<Good, Integer> goods = new HashMap<>();

    @Builder
    @Data
    public static class Good {
        private String name;
        private double price;
        private Integer minAmount;
    }
    public String toString() {
        return goods
                .entrySet()
                .stream()
                .map(it -> it.getKey() + " = " + it.getValue())
                .collect(Collectors.joining("\n"))
                + "TOTALLY: "
                + goods.entrySet().stream().mapToDouble(it -> it.getKey().getPrice()* it.getValue()).sum();
    }
}
