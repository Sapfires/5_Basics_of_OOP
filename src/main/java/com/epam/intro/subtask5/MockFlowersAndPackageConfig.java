package com.epam.intro.subtask5;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;

@Configuration
public class MockFlowersAndPackageConfig {
    @Bean
    public PackageRepository packageRepository() {
        Package one = Package.builder().color(Color.BLUE).packageMaterial(PackageMaterial.PAPER).code(1).build();
        Package two = Package.builder().color(Color.GREEN).packageMaterial(PackageMaterial.CELLOPHANE).code(2).build();
        Package three = Package.builder().color(Color.PURPLE).packageMaterial(PackageMaterial.FOIL).code(3).build();
        PackageRepository packageRepository = new PackageRepository();
        List<Package> packages = new ArrayList<>();
        packages.add(one);
        packages.add(two);
        packages.add(three);
        packageRepository.addPackages(packages);
        return packageRepository;
    }
    @Bean
    public FlowerRepository flowerRepository() {
        Flower one = Flower.builder().sort(Sort.ROSE).color(Color.WHITE).price(900.0).code(1).build();
        Flower two = Flower.builder().sort(Sort.ASTER).color(Color.PURPLE).price(120.0).code(2).build();
        Flower three = Flower.builder().sort(Sort.TULIP).color(Color.RED).price(510.0).code(3).build();
        FlowerRepository flowerRepository = new FlowerRepository();
        List<Flower> flowers = new ArrayList<>();
        flowers.add(one);
        flowers.add(two);
        flowers.add(three);
        flowerRepository.addFlowers(flowers);
        return flowerRepository;
    }

}
