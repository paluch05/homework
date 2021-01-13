package pl.orzechsoft.paluch.tasks.Task28;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class MyDatabase implements Database<Phone> {

    private Map<String, Phone> map = new HashMap<>();

    public MyDatabase() {
        Phone phone = new Phone("005", "Huawei", 64);
        Phone phone2 = new Phone("006", "Lenovo", 32);
        map.put(phone.getId(), phone);
        map.put(phone2.getId(), phone2);
    }

    @Override
    public List<Phone> getAll() {
        return new ArrayList<>(map.values());
    }

    @Override
    public Phone get(String id) {
        return map.get(id);
    }

    @Override
    public void update(Phone obj) {
        map.replace(obj.getId(), obj);
    }

    @Override
    public void deleteById(String id) {
        map.remove(id);
    }

    @Override
    public void add(Phone obj) {
        if (map.containsKey(obj.getId())) {
            throw new IllegalArgumentException("The object with requested ID already exists in the database");
        }
        map.put(obj.getId(), obj);
    }

    @Override
    public boolean contains(String id) {
        return map.containsKey(id);
    }
}
