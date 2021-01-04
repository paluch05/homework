package pl.orzechsoft.paluch.tasks.Task16.engine;

public class HugeEngine implements Engine {

    @Override
    public int getMaxSpeed() {
        return 280;
    }

    @Override
    public double getAccelerationPenalty() {
        return 0.3;
    }
}
