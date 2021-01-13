package pl.orzechsoft.paluch.tasks.Task27;

import com.fasterxml.jackson.annotation.JsonCreator;

public class Motorcycle {

    private String id;
    private String make;
    private String model;
    private int bhp;

    private Motorcycle(){
        // empty
    }

    public Motorcycle(String id, String make, String model, int bhp) {
        this.make = make;
        this.model = model;
        this.bhp = bhp;
        this.id = id;
    }

    public String getMake() {
        return make;
    }

    public String getModel() {
        return model;
    }

    public int getBhp() {
        return bhp;
    }

    public String getId() {
        return id;
    }
}
