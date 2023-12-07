package adventofcode2023.day6;

import adventofcode2022.Util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Day6 {
    public static List<Integer> parseLine(String line) {
        String vals = line.split(":")[1];
        return Arrays.stream(vals.split(" "))
                        .filter(Predicate.not(String::isEmpty))
                        .map(Integer::parseInt)
                        .collect(Collectors.toList());
    }

    public static void main(String[] args) {
//        List<String> input = Util.getResourceLines("2023/day6sample.txt");
        List<String> input = Util.getResourceLines("2023/day6.txt");

        part1(input);
        part2(input);
    }

    public static void part1(List<String> input) {
        System.out.println("Part 1:");
        List<Integer> times = parseLine(input.get(0));
        List<Integer> records = parseLine(input.get(1));
        List<Race> races = new ArrayList<>();
        for(int i = 0; i < times.size(); i++) {
            races.add(new Race(times.get(i), records.get(i)));
        }

        long result = races.stream()
                        .mapToLong(Race::getWinningCombos)
                        .reduce(1, (x,y) -> x*y);
        System.out.println(result);
    }

    public static void part2(List<String> input) {
        System.out.println("Part 2:");
        Long time = Long.parseLong(input.get(0).split(":")[1].replace(" ", ""));
        Long record = Long.parseLong(input.get(1).split(":")[1].replace(" ", ""));
        Race race = new Race(time, record);
        System.out.println(race.getWinningCombos());

    }

}
