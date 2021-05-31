package com.epam.intro.subtask1;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class FileSystemService {
    private List<CustomDirectory> directories = new ArrayList<>();

    public CustomFile createFile(String name, CustomDirectory path, String text) {
        CustomFile customFile = CustomFile.builder()
                .name(name)
                .path(path)
                .text(Text.builder()
                        .value(text)
                        .build())
                .build();
        path.getCustomFiles().add(customFile);
        return customFile;
    }

    public CustomFile createFile(String name, CustomDirectory path) {
        return createFile(name, path, null);
    }

    public CustomDirectory createDirectory(String name, CustomDirectory parent) {
        CustomDirectory customDirectory = CustomDirectory.builder()
                .name(name)
                .parent(parent)
                .customFiles(new ArrayList<>())
                .customDirectories(new ArrayList<>())
                .build();
        if (parent != null) {
            parent.getCustomDirectories().add(customDirectory);
        }
        return customDirectory;
    }

    public CustomDirectory createDirectory(String name) {
        CustomDirectory rootDirectory = createDirectory(name, null);
        directories.add(rootDirectory);
        return rootDirectory;
    }

    public void rename(CustomFile customFile, String name) {
        customFile.setName(name);
    }

    public void rename(CustomDirectory customDirectory, String name) {
        customDirectory.setName(name);
    }

    public void println(CustomFile customFile) {
        printlnPath(customFile.getPath());
        System.out.println(customFile.getName());
        System.out.println(customFile.getText().getValue());
    }

    public void println(CustomDirectory customDirectory) {
        printlnPath(customDirectory);
        customDirectory.getCustomDirectories().stream().map(CustomDirectory::getName).forEach(System.out::println);
        customDirectory.getCustomFiles().stream().map(CustomFile::getName).forEach(System.out::println);
    }

    private void printlnPath(CustomDirectory customDirectory) {
        String path = "";
        CustomDirectory currentDirectory = customDirectory;
        while (currentDirectory != null) {
            path = "/" + currentDirectory.getName() + path;
            currentDirectory = currentDirectory.getParent();
        }
        System.out.println(path);
    }

    public void editFile(CustomFile customFile, int position, String extraText) {
        String originalValue = customFile.getText().getValue();
        customFile.getText().setValue(originalValue.substring(0, position) + extraText + originalValue.substring(position));
    }

    public void delete(CustomFile customFile) {
        customFile.getPath().getCustomFiles().remove(customFile);
    }

    public void delete(CustomDirectory customDirectory) {
        if (customDirectory.getParent() != null) {
            customDirectory.getParent().getCustomDirectories().remove(customDirectory);
        } else {
            directories.remove(customDirectory);
        }
    }

    public void clear() {
        directories = new ArrayList<>();
    }
}
