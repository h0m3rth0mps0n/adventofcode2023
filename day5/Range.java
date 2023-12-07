package adventofcode2023.day5;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Range {
    private long sourceStart;
    private long destinationStart;
    private long rangeLength;
    private long conversion;
    public Range(String in) {
        List<Long> vals = Arrays.stream(in.split(" "))
                .map(Long::parseLong)
                .collect(Collectors.toList());

        assert(vals.size() == 3);
        destinationStart = vals.get(0);
        sourceStart = vals.get(1);
        rangeLength = vals.get(2);
        conversion = destinationStart - sourceStart;
    }

    private boolean inRange(long rangeStart, long val) {
        return val >= rangeStart && val <= rangeStart + rangeLength - 1;
    }

    public boolean sourceInRange(long val) {
        return inRange(sourceStart, val);
    }

    public long map(long val) {
        if(!sourceInRange(val)) {
            throw new IllegalArgumentException();
        }
        return val + conversion;
    }

    public long getSourceStart() {
        return sourceStart;
    }

    public long getDestinationStart() {
        return destinationStart;
    }
}
