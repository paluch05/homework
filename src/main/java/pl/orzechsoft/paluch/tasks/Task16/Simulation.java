package pl.orzechsoft.paluch.tasks.Task16;

import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Collectors;

public class Simulation {

    public static void main(String[] args) {
        List<Integer> track = List.of(200, 1000, 100, 400, 300, 200, 50, 50, 50, 3000);
        List<Integer> track2 = List.of(10000, 10000);
        List<Integer> track3 = List
                .of(2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2,
                        2, 2, 2, 2, 2, 2, 2);
        List<Integer> track4 = List.of(10, 10, 10, 10, 10);

        RaceCar car = new AniaRaceCar();
        car.prepareForRace(track);

        List<RaceCar> cars = List.of(car);

        List<RaceCar> winners = simulate(cars, track);

        System.out.println("We have our winners!");
        System.out.println(winners.stream().map(RaceCar::getName).collect(Collectors.joining(", ")));
    }

    private static List<RaceCar> simulate(List<RaceCar> cars, List<Integer> track) {
        Map<RaceCar, Double> results = new HashMap<>();
        for (RaceCar car : cars) {
            System.out.println("Car " + car.getName() + " starting");
            if (car.getBrakes().getUses() < track.size()) {
                System.out
                        .println("Car " + car.getName() + " crashed because it couldn't brake after " + car
                                .getBrakes().getUses() + " turns");
                continue;
            }
            double maxSpeed =
                    car.getEngine().getMaxSpeed() / 3.6 * (1 - car.getTransmission().getMaxSpeedPenalty());
            double acceleration = car.getTransmission().getAcceleration() * (1 - car.getEngine()
                    .getAccelerationPenalty());
            double deceleration =
                    -1 * car.getBrakes().getDeceleration() * (1 - car.getEngine().getAccelerationPenalty());
            double currentSpeed = 0;
            double maxTurnSpeed = car.getTyres().getMaxTurnSpeed() / 3.6;
            double totalTime = 0;
            for (int straightPart : track) {
                double t;
                System.out.println("Car " + car.getName() + " started " + straightPart + "m long part");
                boolean canReachTurnSpeed = currentSpeed >= maxTurnSpeed
                        || currentSpeed * (maxTurnSpeed - currentSpeed) / acceleration + (maxTurnSpeed - currentSpeed) * (maxTurnSpeed - currentSpeed) / (2 * acceleration)
                        < straightPart;
                if (!canReachTurnSpeed) {
                    t = Math.sqrt(2 * straightPart / acceleration);
                    currentSpeed += acceleration * t;
                } else {
                    double v = Math.sqrt(Math.abs((2 * straightPart * acceleration * deceleration
                            + deceleration * currentSpeed * currentSpeed
                            - acceleration * maxTurnSpeed * maxTurnSpeed) / (deceleration - acceleration)));
                    if (v > maxSpeed) {
                        double deltaV = maxSpeed - currentSpeed;
                        double t1 = deltaV / acceleration;
                        double deltaV2 = maxSpeed - maxTurnSpeed;
                        double t2 = Math.abs(deltaV2 / deceleration);
                        double partAtConstantSpeed = straightPart -
                                (0.5 * deltaV * deltaV / acceleration + currentSpeed * deltaV / acceleration) -
                                (-0.5 * deltaV2 * deltaV2 / Math.abs(deceleration) - maxSpeed * deltaV2 / Math.abs(deceleration));
                        double t3 = partAtConstantSpeed / maxSpeed;
                        t = t1 + t2 + t3;
                    } else {
                        double deltaV = v - currentSpeed;
                        double t1 = deltaV / acceleration;
                        double deltaV2 = v - maxTurnSpeed;
                        double t2 = Math.abs(deltaV2 / deceleration);
                        t = t1 + t2;
                    }
                    currentSpeed = Math.min(v, maxTurnSpeed);
                }
                totalTime += t;
            }
            totalTime = totalTime + 10 * (track.size() / car.getTyres().getMaxTurns());
            results.put(car, totalTime);
            System.out
                    .println("Car " + car.getName() + " has beaten the track in " + totalTime + "s");
        }

        return results.entrySet().stream().sorted(Comparator.comparingDouble(Entry::getValue))
                .map(Entry::getKey).collect(
                        Collectors.toList());
    }

}