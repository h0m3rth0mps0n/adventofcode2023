package adventofcode2023.day13;

import adventofcode2022.Util;

import java.util.List;

public class Day13 {
    public static void main(String[] args) {
//        List<String> input = Util.getResourceLines("2023/day13sample.txt");
        List<String> input = Util.getResourceLines("2023/day13.txt");

        part1(input);
        part2(input);
    }

    public static void part1(List<String> input) {
        System.out.println("Part 1:");
        List<Reflector> reflectors = Reflector.parseList(input);
        System.out.println(Reflector.computeResult(reflectors));
    }

    public static void part2(List<String> input) {
        System.out.println("Part 2:");
        List<Reflector> reflectors = SmudgedReflector.parseList(input);
        System.out.println(Reflector.computeResult(reflectors));
    }

}
