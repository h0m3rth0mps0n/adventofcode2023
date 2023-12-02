package adventofcode2023.day2;

import java.util.ArrayList;
import java.util.List;

public class Game {
    private int id;
    List<Cubes> rounds;

    public Game() {
        rounds = new ArrayList<>();
    }

    public int getId() {
        return id;
    }

    public boolean isPossible(int red, int green, int blue) {
        for(Cubes c : rounds) {
            if(!c.isPossible(red, green, blue)) return false;
        }
        return true;
    }

    public Cubes getMinimal() {
        Cubes result = new Cubes();
        result.red = Integer.MIN_VALUE;
        result.green = Integer.MIN_VALUE;
        result.blue = Integer.MIN_VALUE;

        for(Cubes c : rounds) {
            result.red = Math.max(result.red, c.red);
            result.green = Math.max(result.green, c.green);
            result.blue = Math.max(result.blue, c.blue);
        }
        return result;
    }

    @Override
    public String toString() {
        return "Game{" +
                "id=" + id +
                ", rounds=" + rounds +
                '}';
    }

    public static Game parse(String str) {
        Game result = new Game();
        String[] parts = str.split(":");
        result.id = Integer.parseInt(parts[0].split(" ")[1]);
        String[] gameParts = parts[1].split(";");
        for(String round : gameParts) {
            result.rounds.add(Cubes.parse(round));
        }
        return result;
    }
}
