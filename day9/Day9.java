package adventofcode2023.day9;

import adventofcode2022.Util;

import java.util.List;

public class Day9 {
    public static void main(String[] args) {
//        List<String> input = Util.getResourceLines("2023/day9sample.txt");
        List<String> input = Util.getResourceLines("2023/day9.txt");

        part1(input);
        part2(input);
    }

    public static void part1(List<String> input) {
        System.out.println("Part 1:");
        long result = 0;
        for(String line : input) {
            result += new Extrapolater(line).extrapolateEnd();
        }

        System.out.println(result);
    }

    public static void part2(List<String> input) {
        System.out.println("Part 2:");
        long result = 0;
        for(String line : input) {
            result += new Extrapolater(line).extrapolateStart();
        }
        System.out.println(result);
    }

}
