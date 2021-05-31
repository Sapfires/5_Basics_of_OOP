package com.epam.intro.subtask1;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class CustomFile {
    private CustomDirectory path;
    private String name;
    private Text text;
}
