package pl.orzechsoft.paluch.tasks.Task22.AbstractFactory;

public class Violin implements Instrument {
    @Override
    public String getInstrument() {
        return "Violin";
    }

    @Override
    public String kindOfsound() {
        return "warm";
    }
}
