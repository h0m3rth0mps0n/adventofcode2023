package adventofcode2023.day15;

import adventofcode2022.Util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Day15 {
    public static void main(String[] args) {
//        List<String> input = Util.getResourceLines("2023/day15sample.txt");
        List<String> input = Util.getResourceLines("2023/day15.txt");

        part1(input);
        part2(input);
    }

    public static void part1(List<String> input) {
        System.out.println("Part 1:");
        Hash hash = new Hash(input.get(0));
        System.out.println(hash.doHash());

    }

    public static void part2(List<String> input) {
        System.out.println("Part 2:");
        Boxes boxes = new Boxes();

        for(String val : input.get(0).split(",")) {
            boxes.processLens(new Lens(val));
//            System.out.printf("After \"%s\":\n", val);
//            System.out.println(boxes);
        }

        System.out.println(boxes.getFocusingPower());

    }

}
