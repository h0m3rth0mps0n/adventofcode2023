package adventofcode2023.day7.part2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Hand implements Comparable<Hand> {
    private List<Card> cards;
    private HandType handType;
    private String in;

    public List<Card> getCards() {
        return cards;
    }

    public HandType getHandType() {
        return handType;
    }

    public String getIn() {
        return in;
    }

    public Hand(String value) {
        in = value;
        cards = new ArrayList<>();
        for(int i = 0; i < value.length(); i++) {
            cards.add(new Card(value.charAt(i)));
        }

        handType = HandType.parse(cards);
    }

    @Override
    public String toString() {
        return "Hand{" +
                "handType=" + handType +
                ", in='" + in + '\'' +
                '}';
    }

    @Override
    public int compareTo(Hand o) {
        int result = handType.compareTo(o.handType);
        if(result != 0) return result;
        for(int i = 0; i < cards.size(); i++) {
            result = cards.get(i).compareTo(o.cards.get(i));
            if(result != 0) return result;
        }
        return 0;
    }
}
