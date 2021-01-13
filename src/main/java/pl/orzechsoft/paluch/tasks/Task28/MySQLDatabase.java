package pl.orzechsoft.paluch.tasks.Task28;

import java.sql.*;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

public class MySQLDatabase implements Database<Phone> {

    private final String connectionString;


    public MySQLDatabase(String connectionString) {
        this.connectionString = connectionString;
    }

    @Override
    public List<Phone> getAll() throws SQLException {
        try (Connection connection = DriverManager.getConnection(connectionString)) {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("select * from phones");
            Collection<Phone> phonesFromResultSet = getPhonesFromResultSet(resultSet);
            return (List<Phone>) phonesFromResultSet;
        }
    }

    @Override
    public Phone get(String model) throws MyDatabaseException {
        try (Connection connection = DriverManager.getConnection(connectionString)) {
            PreparedStatement preparedStatement = connection.prepareStatement("select * from phones where model = ?");
            preparedStatement.setString(1, model);
            ResultSet resultSet = preparedStatement.executeQuery();
            Collection<Phone> phonesFromResultSet = getPhonesFromResultSet(resultSet);
            return phonesFromResultSet.iterator().next();
        } catch (SQLException e) {
            throw new MyDatabaseException("Obj not found");
        }
    }

    @Override
    public void update(Phone obj) throws MyDatabaseException {
        try (Connection connect = DriverManager.getConnection(connectionString)) {
            PreparedStatement statement = connect.prepareStatement("UPDATE phones SET storage = ?, model = ? where id= ?");
            statement.setInt(3, obj.getStorage());
            statement.setString(2, obj.getModel());
            statement.setString(1, obj.getId());
            int howManyObjAffected = statement.executeUpdate();
            if (howManyObjAffected == 0) {
                throw new MyDatabaseException("Obj wasn't updated");
            }
        } catch (SQLException e) {
            throw new MyDatabaseException("Unable to update obj");
        }
    }

    @Override
    public void deleteById(String id) throws MyDatabaseException {
        try (Connection connect = DriverManager.getConnection(connectionString)) {
            PreparedStatement statement = connect.prepareStatement("DELETE from phones where id = ?");
            statement.setString(1, id);

            int howManyObjAffected = statement.executeUpdate();
            if (howManyObjAffected == 0) {
                throw new MyDatabaseException("Obj with this ID doesn't exist");
            }
        } catch (SQLException e) {
            throw new MyDatabaseException("Obj wasn't deleted from db");
        }
    }

    @Override
    public void add(Phone obj) throws MyDatabaseException {
        try (Connection connect = DriverManager.getConnection(connectionString)) {
            PreparedStatement statement = connect.prepareStatement("INSERT into phones (id, model, storage) VALUES (?, ?, ?)");
            statement.setString(1, obj.getId());
            statement.setString(2, obj.getModel());
            statement.setInt(3, obj.getStorage());
            int howManyObjAffected = statement.executeUpdate();
            if (howManyObjAffected == 0) {
                throw new MyDatabaseException("Obj wasn't inserted into db");
            }
        } catch (SQLException e) {
            throw new MyDatabaseException("Unable to connect to database", e);
        }
    }

    private Collection<Phone> getPhonesFromResultSet(ResultSet resultSet) throws SQLException {
        List<Phone> result = new LinkedList<>();
        while (resultSet.next()) {
            String id = resultSet.getString("id");
            String model = resultSet.getString("model");
            int storage = resultSet.getInt("storage");
            result.add(new Phone(id, model, storage));
        }
        return result;
    }

    @Override
    public boolean contains(String id) {
        return false;
    }

}