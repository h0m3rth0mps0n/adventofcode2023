package adventofcode2023.day5.v2;

import java.util.*;

public class Mapper {
    private List<Range> rangeList;
    public Mapper(List<String> input, int startIdx) {
        rangeList = new ArrayList<>();

        String line;
        while( startIdx < input.size() && !(line = input.get(startIdx++)).isEmpty() ) {
            rangeList.add(new Range(line));
        }

        Collections.sort(rangeList, Comparator.comparing(Range::getSourceStart));
    }

    public Mapper(List<Range> rangeList) {
        this.rangeList = rangeList;
        Collections.sort(rangeList, Comparator.comparing(Range::getSourceStart));
    }

    private Range getRangeFor(long val) {
        for(Range r : rangeList) {
            if(r.getSourceStart() > val) {
                return null;
            }
            if(r.sourceInRange(val)) {
                return r;
            }
        }
        return null;
    }

    public long map(long val) {
        Range range = getRangeFor(val);
        return range != null ? range.map(val) : val;
    }

    private void addRange(Range newRange) {
        List<Range> result = new ArrayList<>();
        for(Range r : rangeList) {

        }
    }

    public Mapper splitRanges(Mapper in) {
        System.out.println(rangeList);
        System.out.println(in.rangeList);

        List<Range> splitRanges = new ArrayList<>();

        for(Range r : rangeList) {
            for(Range r2 : in.rangeList) {
                System.out.println(r + " vs " + r2 + " --> " + r.overlaps(r2));
            }
        }
        return null;
    }
}
