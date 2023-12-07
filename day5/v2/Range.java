package adventofcode2023.day5.v2;

import java.util.ArrayList;
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

        init(vals.get(0), vals.get(1), vals.get(2));
    }

    public Range(long destinationStart, long sourceStart, long rangeLength) {
        init(destinationStart, sourceStart, rangeLength);
    }

    private void init(long destinationStart, long sourceStart, long rangeLength) {
        this.destinationStart = destinationStart;
        this.sourceStart = sourceStart;
        this.rangeLength = rangeLength;
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

    public long getSourceEnd() {
        return sourceStart + rangeLength - 1;
    }

    public long getDestinationStart() {
        return destinationStart;
    }

    public long getDestinationEnd() {
        return destinationStart + rangeLength - 1;
    }

    public boolean overlaps(Range r) {
        Range small = sourceStart <= r.sourceStart ? this : r;
        Range large = small == this ? r : this;

        return small.sourceStart + small.rangeLength > large.sourceStart;
    }

    public List<Range> split(Range r) {
        List<Range> result = new ArrayList<>();

        if(!overlaps(r)) {
            result.add(this);
            result.add(r);
            return result;
        }

        Range smallStart = getSourceStart() <= r.getSourceStart() ? this : r;
        Range largeStart = smallStart == this ? r : this;

        Range smallEnd = getSourceEnd() <= r.getSourceEnd() ? this : r;
        Range largeEnd = smallEnd == this ? r : this;

        long lowStart = smallStart.getSourceStart();
        long midStart = largeStart.getSourceStart();
        long highStart = smallEnd.getSourceEnd() + 1;

        Range low = new Range(
                smallStart.map(lowStart),
                lowStart,
                midStart - lowStart
        );
        Range mid = new Range(
                largeStart.map(midStart),
                midStart,
                highStart - midStart);
        Range high = new Range(
                largeEnd.map(highStart),
                highStart,
                largeEnd.getSourceEnd() - highStart + 1);
        result.add(low);
        result.add(mid);
        result.add(high);
        return result;
    }

    @Override
    public String toString() {
        return String.format("[%d-%d] {%d}", getSourceStart(), getSourceEnd(), conversion);
//        return "Range{" +
//                "sourceStart=" + sourceStart +
//                ", destinationStart=" + destinationStart +
//                ", rangeLength=" + rangeLength +
//                ", conversion=" + conversion +
//                '}';
    }
}
