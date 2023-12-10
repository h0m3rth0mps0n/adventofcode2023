package adventofcode2023.day10.p1;

import adventofcode2022.Util;

import java.util.List;

public class Day10 {
    public static void main(String[] args) {
        List<String> input = Util.getResourceLines("2023/day10sample.txt");
//        List<String> input = Util.getResourceLines("2023/day10.txt");

        part1(input);
        part2(input);
    }

    public static void part1(List<String> input) {
        System.out.println("Part 1:");
        System.out.println(new Sketch(input).traverse() / 2);
    }

    public static void part2(List<String> input) {
        System.out.println("Part 2:");
        Sketch sketch = new Sketch(input);
        sketch.traverse();
        sketch.printLoop();
    }

}
