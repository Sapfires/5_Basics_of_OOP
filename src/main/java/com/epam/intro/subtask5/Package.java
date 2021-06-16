package com.epam.intro.subtask5;

import io.swagger.models.auth.In;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class Package {
    private Color color;
    private PackageMaterial packageMaterial;
    private Integer code;
}
