package com.epam.intro.subtask5;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashMap;
import java.util.Map;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class Bouquet {
    private Map<Flower, Integer> flowers = new HashMap<>();
    private Package bouquetPackage;
}
