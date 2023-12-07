package adventofcode2023.day7.part1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Hand implements Comparable<Hand> {
    private List<Card> cards;
    private Map<Card, Integer> freq;
    private HandType handType;
    private String in;

    private void addToMap(Card key) {
        if(!freq.containsKey(key)) {
            freq.put(key, 0);
        }
        freq.put(key, freq.get(key) + 1);
    }

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
        freq = new HashMap<>();
        for(int i = 0; i < value.length(); i++) {
            cards.add(new Card(value.charAt(i)));
            addToMap(cards.get(i));
        }
        handType = HandType.parse(freq);
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
