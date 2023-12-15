package adventofcode2023.day15;

import java.util.List;

public class Hash {
    private List<String> vals;
    public Hash(String input) {
        vals = List.of(input.split(","));
    }

    public long doHash() {
        long result = 0;
        for(String s : vals) {
            result += hash(s);
        }
        return result;
    }

    public List<String> getVals() {
        return vals;
    }

    public static int hash(String in) {
        int currentValue = 0;

        for(char c : in.toCharArray()) {
            currentValue += c;
            currentValue *= 17;
            currentValue %= 256;
        }

        return currentValue;
    }
}
