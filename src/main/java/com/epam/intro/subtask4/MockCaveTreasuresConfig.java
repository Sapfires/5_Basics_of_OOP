package com.epam.intro.subtask4;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Configuration
public class MockCaveTreasuresConfig {
    @Bean
    public CaveService cave() {
        List<Treasure> treasures =
                IntStream.range(0, 100)
                        .boxed()
                        .map(it -> Treasure.builder()
                                .name(UUID.randomUUID().toString().substring(1, 5))
                                .price(Double.valueOf(it))
                                .build())
                        .collect(Collectors.toList());
        CaveService caveService = new CaveService();
        caveService.addTreasures(treasures);
        return caveService;
    }

}
