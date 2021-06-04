package com.epam.intro.subtask1;

import com.epam.intro.subtask1.CustomDirectory;
import com.epam.intro.subtask1.MockFileSystemServiceWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/subtask1")
@RestController
public class SubTask1Controller {

    @Autowired
    private MockFileSystemServiceWrapper fileSystemServiceWrapper;

    @GetMapping("/home")
    public CustomDirectory getHome() {
        return fileSystemServiceWrapper.getHome();
    }
    @GetMapping("/users")
    public CustomDirectory getUsers() {
        return fileSystemServiceWrapper.getUsers();
    }
    @GetMapping("/admins")
    public CustomDirectory getAdmins() {
        return fileSystemServiceWrapper.getAdminsDirectory();
    }
    @GetMapping("/guests")
    public CustomDirectory getGuests() {
        return fileSystemServiceWrapper.getGuestsDirectory();
    }
}
