package com.epam.intro.subtask5;

import java.util.ArrayList;
import java.util.List;

public class FlowerRepository {
    private List<Flower> flowers = new ArrayList<>();

    public List<Flower> getFlowers() {
        return flowers;
    }

    public void addFlowers(List<Flower> flowers) {
        this.flowers.addAll(flowers);
    }

    public Flower getByCode(Integer code) {
        return flowers.stream().filter(it -> it.getCode() == code).findAny().get();
    }
}
