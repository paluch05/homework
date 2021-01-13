package pl.orzechsoft.paluch.tasks.Task27;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;


public class HashMapDatabase implements Database<Motorcycle> {

    private Map<String, Motorcycle> map = new HashMap<>();

    public HashMapDatabase() {
        Motorcycle motorcycle = new Motorcycle("005", "Ducati", "Monster", 50);
        Motorcycle motorcycle2 = new Motorcycle("aaa", "Yamaha", "Tracer", 110);
        map.put(motorcycle.getId(), motorcycle);
        map.put(motorcycle2.getId(), motorcycle2);
    }

    @Override
    public List<Motorcycle> getAll() {
        return new ArrayList<>(map.values());
    }

    @Override
    public Motorcycle get(String id) {
        return map.get(id);
    }

    @Override
    public void update(Motorcycle obj) {
        map.replace(obj.getId(),obj);
    }

    @Override
    public void deleteById(String id) {
        map.remove(id);
    }

    @Override
    public void add(Motorcycle obj) {
        if (map.containsKey(obj.getId())){
            throw new IllegalArgumentException("The object with requested ID already exists in the database");
        }
        map.put(obj.getId(), obj);
    }

    @Override
    public boolean contains(String id) {
        return map.containsKey(id);
    }
}
