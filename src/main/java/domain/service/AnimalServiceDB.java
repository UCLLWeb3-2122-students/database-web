package domain.service;

import domain.model.Animal;
import util.DbConnectionService;

import java.sql.*;
import java.util.ArrayList;

public class AnimalServiceDB implements AnimalService {
    private Connection connection;
    private String schema;

    public AnimalServiceDB() {
        this.connection = DbConnectionService.getDbConnection();
        this.schema = DbConnectionService.getSchema();
    }

    @Override
    public void add(Animal animal) {
        String query = String.format("insert into %s.animal (name,type,food) values (?,?,?)", schema);
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, animal.getName());
            preparedStatement.setString(2, animal.getType());
            preparedStatement.setInt(3, animal.getFood());
            preparedStatement.execute();
        } catch (SQLException e) {
            throw new DbException(e.getMessage());
        }

    }

    @Override
    public Animal findAnimalWithName(String naam) {
        return null;
    }

    @Override
    public ArrayList<Animal> getAll() {
        ArrayList<Animal> animals = new ArrayList<>();
        String sql = String.format("SELECT * from %s.animal", schema);
        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet result = statement.executeQuery();
            while (result.next()) {
                int id = result.getInt("id");
                String name = result.getString("name");
                String type = result.getString("type");
                int food = result.getInt("food");
                animals.add(new Animal(id, name, type, food));
            }
        } catch (SQLException e) {
            throw new DbException(e.getMessage());
        }
        return animals;
    }
}
