package com.epam.intro.subtask1;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Builder
public class CustomDirectory {
    private List<CustomFile> customFiles;
    private List<CustomDirectory> customDirectories;
    private CustomDirectory parent;
    private String name;
}
