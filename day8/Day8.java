package adventofcode2023.day8;

import adventofcode2022.Util;
import adventofcode2023.Algorithms;

import java.util.List;

public class Day8 {
    public static void main(String[] args) {
//        List<String> input = Util.getResourceLines("2023/day8sample3.txt");
        List<String> input = Util.getResourceLines("2023/day8.txt");

//        part1(input);
        part2(input);
    }

    public static void part1(List<String> input) {
        System.out.println("Part 1:");
        long steps = new DesertTraveller(input).traverse("AAA", "ZZZ");
        System.out.printf("Took %d steps\n", steps );
    }

    public static void part2(List<String> input) {
        System.out.println("Part 2:");
        GhostTraveller ghostTraveller = new GhostTraveller(input);
        List<Node> endNodes = ghostTraveller.getEndNodes();

        long result = 0;
        for(Node start : ghostTraveller.getStartNodes()) {
            long steps = ghostTraveller.traverse(start, endNodes);
            if(start.equals(ghostTraveller.getStartNodes().get(0))) {
                result = steps;
            } else {
                result = Algorithms.lcm(result, steps);
            }
        }
        System.out.println(result);
    }

}
