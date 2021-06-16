package com.epam.intro.subtask4;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.List;

@RequestMapping("/subtask4/treasure")
@RestController
public class SubTask4Controller {
    @Autowired
    private CaveService caveService;
    @GetMapping("/all")
    public List<Treasure> getAll() {
        return caveService.getAll();
    }
    @GetMapping("/most-expensive")
    public Treasure getMostExpensive() {
        return caveService.getMostExpensive();
    }
    @GetMapping("/by-sum/{sum}")
    public List<Treasure> getBySum(@PathVariable Double sum) {
        return caveService.getBySum(sum);
    }
}
