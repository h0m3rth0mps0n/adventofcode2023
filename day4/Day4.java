package adventofcode2023.day4;

import adventofcode2022.Util;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Day4 {
    public static void main(String[] args) {
//        List<String> input = Util.getResourceLines("2023/day4sample.txt");
        List<String> input = Util.getResourceLines("2023/day4.txt");
        List<Card> cards = input.stream()
                        .map(x -> new Card(x))
                        .collect(Collectors.toList());
//        cards.stream().forEach(System.out::println);
        part1(cards);
        part2(cards);
    }

    public static void part1(List<Card> cards) {
        System.out.println("Part 1:");
        int result = cards.stream()
                        .mapToInt(Card::getValue)
                        .sum();
        System.out.println(result);

    }

    public static void part2(List<Card> cards) {
        System.out.println("Part 2:");
        List<Integer> copies = new ArrayList<>();
        for(Card c : cards) {
            copies.add(1);
        }

        for(int i = 0; i < cards.size(); i++) {
            Card c = cards.get(i);
            int count = c.getWinningCount();
            for(int j = i + 1; j <= i + count; j++) {
                copies.set(j,
                        copies.get(j) + copies.get(i)
                );
            }
        }
        int result = copies.stream().mapToInt(Integer::intValue).sum();
        System.out.println(result);
    }

}
