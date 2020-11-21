package pl.orzechsoft.paluch.tasks.Task16;


import pl.orzechsoft.paluch.tasks.Task16.brakes.MediumBrakes;
import pl.orzechsoft.paluch.tasks.Task16.brakes.StrongBrakes;
import pl.orzechsoft.paluch.tasks.Task16.brakes.WeakBrakes;
import pl.orzechsoft.paluch.tasks.Task16.engine.HugeEngine;
import pl.orzechsoft.paluch.tasks.Task16.engine.NormalEngine;
import pl.orzechsoft.paluch.tasks.Task16.engine.SportEngine;
import pl.orzechsoft.paluch.tasks.Task16.transmission.NormalTransmission;
import pl.orzechsoft.paluch.tasks.Task16.transmission.ShortTransmission;
import pl.orzechsoft.paluch.tasks.Task16.tyres.LongLastingTyres;
import pl.orzechsoft.paluch.tasks.Task16.tyres.NormalTyres;
import pl.orzechsoft.paluch.tasks.Task16.tyres.SportTyres;
import java.util.Comparator;
import java.util.List;

public class AniaRaceCar extends RaceCar {

    @Override
    protected void prepareForRace(List<Integer> track) {
        int maxStraight = track.stream().max(Comparator.comparingInt(Integer::intValue)).get();
        if (track.size() <=5) {
            tyres = new SportTyres();
        } else if (track.size() <= 20) {
            tyres = new NormalTyres();
        } else {
            tyres = new LongLastingTyres();
        }
        if (maxStraight <= 200) {
            engine = new HugeEngine();
            transmission = new ShortTransmission();
        } else if (maxStraight <= 1000) {
            engine = new NormalEngine();
            transmission = new NormalTransmission();
        } else {
            engine = new SportEngine();
            transmission = new ShortTransmission();
        }
        if (track.size() <= 10) {
            brakes = new StrongBrakes();
        } else if (track.size() <= 20) {
            brakes = new MediumBrakes();
        } else {
            brakes = new WeakBrakes();
        }
    }

    @Override
    protected String getName() {
        return "Fura";
    }
}
