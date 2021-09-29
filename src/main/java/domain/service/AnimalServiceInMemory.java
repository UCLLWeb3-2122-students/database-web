package domain.service;

import java.util.ArrayList;

import domain.model.Animal;

public class AnimalServiceInMemory implements AnimalService {
    private int id = 0;

    private final ArrayList<Animal> animals = new ArrayList<>();

    public AnimalServiceInMemory() {
        this.add(new Animal(id, "Witje", "Kat", 3));
        this.add(new Animal(id, "Zwartje", "Konijn", 1));
    }

    public void add(Animal animal) {
        if (animal == null)
            throw new IllegalArgumentException("Geef een bestaand dier");
        if (findAnimalWithName(animal.getName()) != null)
            throw new IllegalArgumentException("Je mag een dier maar één keer toevoegen");
        animals.add(animal);
        id++;
    }

    public Animal findAnimalWithName(String naam) {
        if (naam == null || naam.isEmpty())
            throw new IllegalArgumentException("Naam mag niet leeg zijn");
        for (Animal dier : animals) {
            if (dier.getName().equals(naam))
                return dier;
        }
        return null;
    }

    public ArrayList<Animal> getAll() {
        return animals;
    }


}