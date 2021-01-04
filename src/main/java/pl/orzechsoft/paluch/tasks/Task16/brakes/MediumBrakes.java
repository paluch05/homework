package pl.orzechsoft.paluch.tasks.Task16.brakes;

public class MediumBrakes implements Brakes {

    @Override
    public double getDeceleration() {
        return 4;
    }

    @Override
    public double getUses() {
        return 20;
    }
}