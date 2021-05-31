package com.epam.intro.subtask1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

@EnableScheduling
@Configuration
public class SpringConfig {
    @Autowired
    private FileSystemService fileSystemService;
    @Scheduled(fixedDelay = 1000)
    public void scheduledTask() {
        CustomDirectory home = fileSystemService.createDirectory("home");
        CustomDirectory users = fileSystemService.createDirectory("users");
        CustomDirectory adminsDirectory = fileSystemService.createDirectory("admins", users);
        CustomDirectory guestsDirectory = fileSystemService.createDirectory("guests", users);
        CustomFile workBookTemplate = fileSystemService.createFile("workBookTemplate.txt", users, "Наша Таня громка плачит");
        CustomFile adminsWorkBook = fileSystemService.createFile("adminsWorkBook.txt", adminsDirectory, "Уранила в речку мячек");
        CustomFile guestsWorkBook = fileSystemService.createFile("guestsWorkBook.txt", guestsDirectory, "Тише Танечка не плач");
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
