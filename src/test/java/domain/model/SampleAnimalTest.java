package domain.model;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SampleAnimalTest {
    @Test
    public void CreateAnimalTest() {
        Animal animal = new Animal(5, "Zorro", "tijger", 3);
        assertEquals("Zorro", animal.getName());
        assertEquals("tijger", animal.getType());
        assertEquals(2, animal.getFood());
    }

    @Test(expected = IllegalArgumentException.class)
    public void CreateAnimalWithEmptyNameThrowsException() {
        Animal animal = new Animal(5, "", "tijger", 7);
    }
}
