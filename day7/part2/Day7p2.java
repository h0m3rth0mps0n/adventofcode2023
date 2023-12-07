package adventofcode2023.day7.part2;

import adventofcode2022.Util;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Day7p2 {
    public static void main(String[] args) {
//        List<String> input = Util.getResourceLines("2023/day7sample.txt");
        List<String> input = Util.getResourceLines("2023/day7.txt");

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
}
