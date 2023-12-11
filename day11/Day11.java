package adventofcode2023.day11;

import adventofcode2022.Util;

import java.util.ArrayList;
import java.util.List;

public class Day11 {
    public static void main(String[] args) {
//        List<String> input = Util.getResourceLines("2023/day11sample.txt");
        List<String> input = Util.getResourceLines("2023/day11.txt");

        part1(input);
        part2(input);
    }

    public static void part1(List<String> input) {
        System.out.println("Part 1:");
        CosmicExpansion ce = new CosmicExpansion(input);
        ce.expand(2);

        System.out.println(ce.computeDistances());

    }

    public static void part2(List<String> input) {
        System.out.println("Part 2:");
        CosmicExpansion ce = new CosmicExpansion(input);
        ce.expand(1000000);

        System.out.println(ce.computeDistances());

    }

}
