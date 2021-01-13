package pl.orzechsoft.paluch.tasks.Task28;

import java.sql.SQLException;
import java.util.List;

public interface Database<T> {

    List<T> getAll() throws SQLException;
    T get(String model) throws MyDatabaseException;
    void update(T obj) throws MyDatabaseException;
    void deleteById(String id) throws MyDatabaseException;
    void add(T obj) throws MyDatabaseException;
    boolean contains(String id);
}
