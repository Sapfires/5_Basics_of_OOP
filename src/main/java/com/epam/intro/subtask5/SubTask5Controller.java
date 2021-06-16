package com.epam.intro.subtask5;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;
import java.util.Map;

@RequestMapping("/subtask5")
@RestController
public class SubTask5Controller {
    @Autowired
    private FlowerRepository flowerRepository;
    @Autowired
    private PackageRepository packageRepository;
    @Autowired
    private BouquetService bouquetService;
    @GetMapping("/flower/all")
    public List<Flower> getAllFlowers() {
        return flowerRepository.getFlowers();
    }
    @GetMapping("/package/all")
    public List<Package> getAllPackages() {
        return packageRepository.getPackages();
    }
    @PostMapping("/bouquet")
    public Bouquet createBouquet(@RequestBody BouquetOrder bouquetOrder) {
        return bouquetService.createBouquet(bouquetOrder);
    }
}
