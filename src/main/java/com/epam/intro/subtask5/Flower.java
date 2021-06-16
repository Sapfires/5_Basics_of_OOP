package com.epam.intro.subtask5;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class Flower {
    private Color color;
    private Sort sort;
    private Double price;
    private Integer code;
}
