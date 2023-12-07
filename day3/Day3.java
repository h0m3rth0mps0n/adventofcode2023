package adventofcode2023.day3;

import adventofcode2022.Util;

import java.util.List;
import java.util.stream.Collectors;

public class Day3 {
    public static void main(String[] args) {
//        List<String> input = Util.getResourceLines("2023/day3sample.txt");
        List<String> input = Util.getResourceLines("2023/day3.txt");
        Schematic schematic = new Schematic(input);
        part1(schematic);
        part2(schematic);
    }

    public static void part1(Schematic schematic) {
        System.out.println("Part 1:");
        int result = schematic.getPartNumbers()
                .stream()
                .mapToInt(PartNumber::getValue)
                .sum();
        System.out.println(result);
//        System.out.println(schematic.getPartNumbers()
//                .stream()
//                .map(PartNumber::toString)
//                .collect(Collectors.joining("\n"))
//        );



    }

    public static void part2(Schematic schematic) {
        System.out.println("Part 2:");
        int result = schematic.getGears()
                .stream()
                .mapToInt(Gear::getRatio)
                .sum();

        System.out.println(result);
    }

}
