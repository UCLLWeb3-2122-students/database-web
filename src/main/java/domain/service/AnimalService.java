package domain.service;

import domain.model.Animal;

import java.util.ArrayList;

public interface AnimalService {
    void addAnimal(Animal animal);

    Animal findAnimalWithName(String naam);

    ArrayList<Animal> getAllAnimals();
}
