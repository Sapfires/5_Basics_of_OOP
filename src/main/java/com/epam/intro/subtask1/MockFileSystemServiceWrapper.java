package com.epam.intro.subtask1;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

@Getter
@Service
public class MockFileSystemServiceWrapper {
    @Autowired
    private FileSystemService fileSystemService;

    private CustomDirectory home;
    private CustomDirectory users;
    private CustomDirectory adminsDirectory;
    private CustomDirectory guestsDirectory;
    private CustomFile workBookTemplate;
    private CustomFile adminsWorkBook;
    private CustomFile guestsWorkBook;
    @PostConstruct
    public void scheduledTask() {
        home = fileSystemService.createDirectory("home");
        users = fileSystemService.createDirectory("users");
        adminsDirectory = fileSystemService.createDirectory("admins", users);
        guestsDirectory = fileSystemService.createDirectory("guests", users);
        workBookTemplate = fileSystemService.createFile("workBookTemplate.txt", users, "Наша Таня громка плачит");
        adminsWorkBook = fileSystemService.createFile("adminsWorkBook.txt", adminsDirectory, "Уранила в речку мячек");
        guestsWorkBook = fileSystemService.createFile("guestsWorkBook.txt", guestsDirectory, "Тише Танечка не плач");
        fileSystemService.println(home);
        fileSystemService.println(users);
        fileSystemService.println(adminsDirectory);
        fileSystemService.println(guestsDirectory);
        fileSystemService.println(workBookTemplate);
        fileSystemService.println(adminsWorkBook);
        fileSystemService.println(guestsWorkBook);
        fileSystemService.clear();
    }
}

