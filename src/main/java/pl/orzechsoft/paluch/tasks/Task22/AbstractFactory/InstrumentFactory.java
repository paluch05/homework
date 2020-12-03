package pl.orzechsoft.paluch.tasks.Task22.AbstractFactory;

public class InstrumentFactory implements AbstractFactory<Instrument>{
    @Override
    public Instrument create(String instrumentType) {
        if ("Violin".equalsIgnoreCase(instrumentType)) {
            return new Violin();
        } else if ("Trombone".equalsIgnoreCase(instrumentType)) {
            return new Brass();
        }
        return null;
    }
}
