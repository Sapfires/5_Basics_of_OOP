package com.epam.intro.subtask5;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

public class PackageRepository {
    private List<Package> packages = new ArrayList<>();

    public List<Package> getPackages() {
        return packages;
    }

    public void addPackages(List<Package> packages) {
        this.packages.addAll(packages);
    }

    public Package getByCode(Integer packageCode) {
        return packages.stream().filter(it -> it.getCode() == packageCode).findAny().get();
    }
}
