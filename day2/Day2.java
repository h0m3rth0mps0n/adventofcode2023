package adventofcode2023.day2;

import adventofcode2022.Util;

import java.util.ArrayList;
import java.util.List;

public class Day2 {
    public static void main(String[] args) {
//        List<String> input = Util.getResourceLines("2023/day2sample.txt");
        List<String> input = Util.getResourceLines("2023/day2.txt");

        List<Game> games = new ArrayList<>();
        for(String s : input) {
            games.add(Game.parse(s));
        }

        part1(games);
        part2(games);
    }

    public static void part1(List<Game> games) {
        System.out.println("Part 1:");
        int result = games.stream()
                .filter(x -> x.isPossible(12, 13, 14))
                .mapToInt(Game::getId)
                .sum();

        System.out.println(result);
    }

    public static void part2(List<Game> games) {
        System.out.println("Part 2:");
        int result = games.stream()
                .map(Game::getMinimal)
                .mapToInt(Cubes::getPower)
                .sum();
        System.out.println(result);
    }
}
