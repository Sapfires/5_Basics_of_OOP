package com.epam.intro.subtask5;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class BouquetOrder {
    private Map<Integer, Integer> orderedFlowers;
    private Integer packageCode;
}
