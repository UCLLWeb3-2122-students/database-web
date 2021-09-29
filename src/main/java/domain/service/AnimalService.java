package domain.service;

import domain.model.Animal;

import java.util.ArrayList;

public interface AnimalService {
    void add(Animal animal);

    Animal findAnimalWithName(String naam);

    ArrayList<Animal> getAll();
}
