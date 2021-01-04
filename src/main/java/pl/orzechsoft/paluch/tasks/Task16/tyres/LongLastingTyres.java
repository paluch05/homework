package pl.orzechsoft.paluch.tasks.Task16.tyres;

public class LongLastingTyres implements Tyres {

    @Override
    public double getMaxTurnSpeed() {
        return 10;
    }

    @Override
    public int getMaxTurns() {
        return 100;
    }
}
