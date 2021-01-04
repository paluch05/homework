package pl.orzechsoft.paluch.tasks.Task16;

import pl.orzechsoft.paluch.tasks.Task16.brakes.Brakes;
import pl.orzechsoft.paluch.tasks.Task16.engine.Engine;
import pl.orzechsoft.paluch.tasks.Task16.transmission.Transmission;
import pl.orzechsoft.paluch.tasks.Task16.tyres.Tyres;

import java.util.List;

public abstract class RaceCar {

    protected Brakes brakes;
    protected Engine engine;
    protected Transmission transmission;
    protected Tyres tyres;

    public Brakes getBrakes() {
        return brakes;
    }

    public Engine getEngine() {
        return engine;
    }

    public Transmission getTransmission() {
        return transmission;
    }

    public Tyres getTyres() {
        return tyres;
    }

    protected abstract void prepareForRace(List<Integer> track);

    protected abstract String getName();
}
