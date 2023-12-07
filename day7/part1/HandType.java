package adventofcode2023.day7.part1;

import java.util.Map;

public enum HandType {
    HIGH_CARD, ONE_PAIR, TWO_PAIR, THREE_OF_A_KIND, FULL_HOUSE, FOUR_OF_A_KIND, FIVE_OF_A_KIND;

    public static HandType parse(Map<Card, Integer> freq) {
        int highFreq = freq.values().stream()
                .mapToInt(Integer::intValue)
                .max().getAsInt();

        switch(highFreq) {
            case 5:
                return HandType.FIVE_OF_A_KIND;
            case 4:
                return HandType.FOUR_OF_A_KIND;
            case 3:
                int lowFreq = freq.values().stream()
                        .mapToInt(Integer::intValue)
                        .min().getAsInt();
                if(lowFreq == 2)
                    return FULL_HOUSE;
                return THREE_OF_A_KIND;
            case 2:
                long numPairs = freq.values().stream().mapToInt(Integer::intValue)
                        .filter(x -> x == 2)
                        .count();
                if(numPairs == 2)
                    return TWO_PAIR;
                return ONE_PAIR;
            default:
                return HIGH_CARD;
            }
        }
}
