package adventofcode2023.day7.part2;

public class CamelCards implements Comparable<CamelCards>{
    private Hand hand;
    private int bid;

    public CamelCards(String in) {
        String[] parts = in.split(" ");
        hand = new Hand(parts[0]);
        bid = Integer.parseInt(parts[1]);
    }

    public int getBid() {
        return bid;
    }

    public Hand getHand() {
        return hand;
    }

    @Override
    public String toString() {
        return "CamelCards{" +
                "hand=" + hand +
                ", bid=" + bid +
                '}';
    }


    @Override
    public int compareTo(CamelCards o) {
        return hand.compareTo(o.hand);
    }
}
