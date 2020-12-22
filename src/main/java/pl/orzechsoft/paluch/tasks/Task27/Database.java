package pl.orzechsoft.paluch.tasks.Task27;

import java.util.List;

public interface Database<T> {

    List<T> getAll();
    T get(String id);
    void update(T obj);
    void deleteById(String id);
    void add(T obj);
    boolean contains(String id);
}
