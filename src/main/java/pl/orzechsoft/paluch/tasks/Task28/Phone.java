package pl.orzechsoft.paluch.tasks.Task28;

public class Phone {

    private String id;
    private String model;
    private int storage;

    public Phone(String id, String model, int storage) {
        this.id = id;
        this.model = model;
        this.storage = storage;
    }

    public String getId() {
        return id;
    }

    public String getModel() {
        return model;
    }

    public int getStorage() {
        return storage;
    }
}


