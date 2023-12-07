package adventofcode2023.day5;

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
}
