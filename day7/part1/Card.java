package adventofcode2023.day7.part1;

public class Card implements Comparable<Card>{
    private String name;
    private int value;

    public Card(char name) {
        this("" + name);
    }

    public Card(String name) {
        this.name = name;
        switch(name) {
            case "A":
                value = 14;
                break;
            case "K":
                value = 13;
                break;
            case "Q":
                value = 12;
                break;
            case "J":
                value = 11;
                break;
            case "T":
                value = 10;
                break;
            default:
                value = Integer.parseInt(name);
        }
    }

    public int getValue() {
        return value;
    }

    @Override public int hashCode() {
        return name.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if(! (obj instanceof Card) ) return false;
        return ((Card) obj).value == value;
    }

    @Override
    public int compareTo(Card o) {
        return value - o.getValue();
    }
}
