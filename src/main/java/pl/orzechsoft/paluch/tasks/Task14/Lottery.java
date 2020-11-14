package pl.orzechsoft.paluch.tasks.Task14;

import java.util.HashMap;
import java.util.Random;
import java.util.UUID;

public class Lottery {
    private final HashMap<Integer, String> players;
    private final Random random;
    private final int maxNumber;

    public static void main(String[] args) {
        Lottery lottery = new Lottery(50, 200);
        String winner = lottery.getWinnerId();
        if (winner != null) {
            System.out.format("Winner is: " + winner);
        } else {
            System.out.println("There's no winner today!");
        }
    }

    public Lottery(int numberOfPlayers, int maxNumber) {
        if (maxNumber < numberOfPlayers) {
            throw new IllegalArgumentException("There must be more players than numbers!");
        }
        this.players = new HashMap<>();
        this.random = new Random();
        this.maxNumber = maxNumber;
        for (int i = 0; i < numberOfPlayers; i++) {
            int randomNumber = random.nextInt(maxNumber + 1);
            while (players.containsKey(randomNumber)) {
                randomNumber = random.nextInt(maxNumber + 1);
            }
            players.put(randomNumber, UUID.randomUUID().toString());
        }
    }

    public String getWinnerId() {
        int winnerNumber = random.nextInt(maxNumber + 1);
        System.out.println("The winning number today is... " + winnerNumber + "!");
        return players.get(winnerNumber);
    }
}