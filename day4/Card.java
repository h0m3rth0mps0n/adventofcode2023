package adventofcode2023.day4;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static java.util.function.Predicate.not;

public class Card {
    List<Integer> winning;
    List<Integer> nums;

    private List<Integer> split(String in) {
        return Arrays.stream(in.split(" "))
                .filter(not(String::isBlank))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }

    public Card(String input) {
        String[] parts = input.split(":")[1].split("\\|");
        winning = split(parts[0]);
        nums = split(parts[1]);
    }

    public int getValue() {
        List<Integer> result = new ArrayList<>(nums);
        result.retainAll(winning);
        return result.size() == 0 ? 0 : (int) Math.pow(2, result.size() - 1);
    }

    public int getWinningCount() {
        List<Integer> result = new ArrayList<>(nums);
        result.retainAll(winning);
        return result.size();
    }

    @Override
    public String toString() {
        return "Card{" +
                "winning=" + winning +
                ", nums=" + nums +
                '}';
    }
}
