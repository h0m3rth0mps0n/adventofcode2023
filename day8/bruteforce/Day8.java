package adventofcode2023.day8.bruteforce;

import adventofcode2022.Util;

import java.util.List;

public class Day8 {
    public static void main(String[] args) {
//        List<String> input = Util.getResourceLines("2023/day8sample3.txt");
        List<String> input = Util.getResourceLines("2023/day8.txt");

        part1(input);
        part2(input);
    }

    public static void part1(List<String> input) {
        System.out.println("Part 1:");
        long steps = new DesertTraveller(input).traverse();
        System.out.printf("Took %d steps\n", steps );
    }

    public static void part2(List<String> input) {
        System.out.println("Part 2:");
        long steps = new GhostTraveller(input).traverse();
        System.out.printf("Took %d steps\n", steps );
    }

}
