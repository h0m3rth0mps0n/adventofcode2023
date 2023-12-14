package adventofcode2023.day14;

import adventofcode2022.Util;
import adventofcode2023.day13.Reflector;
import adventofcode2023.day13.SmudgedReflector;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Day14 {
    public static void main(String[] args) {
//        List<String> input = Util.getResourceLines("2023/day14sample.txt");
        List<String> input = Util.getResourceLines("2023/day14.txt");

        part1(input);
        part2(input);
    }

    public static void part1(List<String> input) {
        System.out.println("Part 1:");

        RockField rockField = new RockField(input);
        rockField.moveNorth();
        System.out.println(rockField.getLoad());
    }

    public static void part2(List<String> input) {
        System.out.println("Part 2:");

        RockField rockField = new RockField(input);
        rockField.moveCycle(1000000000);
        System.out.println(rockField.getLoad());



//        for(Map.Entry entry : states.entrySet()) {
//            System.out.println(entry.getValue());
//        }
    }

}
