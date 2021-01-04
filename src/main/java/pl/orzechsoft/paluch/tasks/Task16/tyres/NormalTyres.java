package pl.orzechsoft.paluch.tasks.Task16.tyres;

public class NormalTyres implements Tyres {

    @Override
    public double getMaxTurnSpeed() {
        return 15;
    }

    @Override
    public int getMaxTurns() {
        return 20;
    }
}
