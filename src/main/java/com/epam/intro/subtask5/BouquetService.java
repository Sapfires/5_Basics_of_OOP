package com.epam.intro.subtask5;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class BouquetService {
    @Autowired
    private FlowerRepository flowerRepository;
    @Autowired
    private PackageRepository packageRepository;
    public Bouquet createBouquet(BouquetOrder bouquetOrder) {
        Map<Flower, Integer> flowers = bouquetOrder.getOrderedFlowers()
                .entrySet()
                .stream()
                .collect(Collectors.toMap(it -> flowerRepository.getByCode(it.getKey()), Map.Entry::getValue));
        Package selectedPackage = packageRepository.getByCode(bouquetOrder.getPackageCode());
        return Bouquet.builder().flowers(flowers).bouquetPackage(selectedPackage).build();
    }
}
