package adventofcode2023.day7.part1;

import adventofcode2022.Util;

import java.util.*;
import java.util.stream.Collectors;

public class Day7p1 {
    public static void main(String[] args) {
//        List<String> input = Util.getResourceLines("2023/day7sample.txt");
        List<String> input = Util.getResourceLines("2023/day7.txt");

        part1(input);
        part2();
    }


    public static void part1(List<String> input) {
        System.out.println("Part 1:");
        List<CamelCards> cc =
                input.stream().map(x -> new CamelCards(x))
                        .collect(Collectors.toList());
        Collections.sort(cc);

        long result = 0;
        for(int i = 0; i < cc.size(); i++) {
            CamelCards camelCards = cc.get(i);
            result += (i + 1) * camelCards.getBid();
        }
        System.out.println(result);
    }

    public static void part2() {
        System.out.println("Part 2:");
    }

}
