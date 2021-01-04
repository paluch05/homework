package pl.orzechsoft.paluch.tasks.Task16.transmission;

public class ShortTransmission implements Transmission {

    @Override
    public double getAcceleration() {
        return 5.5;
    }

    @Override
    public double getMaxSpeedPenalty() {
        return 0.3;
    }
}
