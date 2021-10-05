package domain.service;

import domain.model.Animal;

import java.util.ArrayList;

public class AppService {
    private AnimalService animals = new AnimalServiceDB();

    public void addAnimal(Animal animal) {
        animals.addAnimal(animal);
    }

    public Animal findAnimalWithName(String naam) {
        return animals.findAnimalWithName(naam);
    }

    public ArrayList<Animal> getAllAnimals() {
        return animals.getAllAnimals();
    }

}
