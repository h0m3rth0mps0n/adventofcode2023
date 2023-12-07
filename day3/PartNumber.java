package adventofcode2023.day3;

public class PartNumber {
    String value;
    int position;

    public PartNumber(String number, int position) {
        this.value = number;
        this.position = position;
    }

    public int getValue() {
        return Integer.parseInt(value);
    }

    @Override
    public String toString() {
        return "PartNumber{" +
                "value=" + value +
                ", position=" + position +
                '}';
    }
}
