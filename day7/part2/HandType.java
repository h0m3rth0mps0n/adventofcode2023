package adventofcode2023.day7.part2;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

public enum HandType {
    HIGH_CARD, ONE_PAIR, TWO_PAIR, THREE_OF_A_KIND, FULL_HOUSE, FOUR_OF_A_KIND, FIVE_OF_A_KIND;

    private static int[] getFreqs(List<Card> cards) {
        int[] result = new int[15];
        for(int i = 0; i < cards.size(); i++) {
            result[cards.get(i).getValue()]++;
        }
        return result;
    }

    private static void assignWildcard(int[] cardFreqs) {
        int wildCardIdx = new Card("J").getValue();
        int numWildcards = cardFreqs[wildCardIdx];
        if(numWildcards == 0) return;

        cardFreqs[wildCardIdx] = 0;
        int highIdx = 0;
        for(int i = 0; i < cardFreqs.length; i++) {
            if(cardFreqs[i] > cardFreqs[highIdx]) {
                highIdx = i;
            }
        }
        cardFreqs[highIdx] += numWildcards;
    }

    public static HandType parse(List<Card> cards) {
        int[] cardFreqs = getFreqs(cards);
        assignWildcard(cardFreqs);
        int highFreq = Arrays.stream(cardFreqs).max().getAsInt();

        switch(highFreq) {
            case 5:
                return HandType.FIVE_OF_A_KIND;
            case 4:
                return HandType.FOUR_OF_A_KIND;
            case 3:
                int lowFreq = Arrays.stream(cardFreqs)
                        .filter(x -> x != 0)
                        .min()
                        .getAsInt();
                if(lowFreq == 2)
                    return FULL_HOUSE;
                return THREE_OF_A_KIND;
            case 2:
                long numPairs = Arrays.stream(cardFreqs)
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
