package pl.orzechsoft.paluch.tasks.Task22.AbstractFactory;

public class Brass implements Instrument {
    @Override
    public String getInstrument() {
        return "Trombone";
    }

    @Override
    public String kindOfsound() {
        return "Loud";
    }
}
