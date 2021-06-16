package com.epam.intro.subtask4;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class CaveService {
    private List<Treasure> treasures = new ArrayList<>();
    public void addTreasures(List<Treasure> treasures) {
        this.treasures.addAll(treasures);
    }
    public List<Treasure> getAll() {
        return treasures;
    }
    public Treasure getMostExpensive() {
        return treasures.stream().sorted(Comparator.comparingDouble(Treasure::getPrice).reversed()).findFirst().get();
    }
    public List<Treasure> getBySum (Double sum) {
        treasures.sort(Comparator.comparingDouble(Treasure::getPrice));
        List<Treasure> result = new ArrayList<>();
        for (Treasure treasure : treasures) {
            if (result.stream().mapToDouble(Treasure::getPrice).sum() + treasure.getPrice() > sum) {
                break;
            }else {
                result.add(treasure);
            }
        }
        return result;
    }
}
