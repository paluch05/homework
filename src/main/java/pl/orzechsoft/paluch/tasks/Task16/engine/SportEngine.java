package pl.orzechsoft.paluch.tasks.Task16.engine;

public class SportEngine implements Engine {

    @Override
    public int getMaxSpeed() {
        return 180;
    }

    @Override
    public double getAccelerationPenalty() {
        return 0;
    }
}
