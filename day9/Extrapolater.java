package adventofcode2023.day9;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class Extrapolater {
    LinkedList<Integer> vals;
    public Extrapolater(String in) {
        vals = new LinkedList(Arrays.stream(in.split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toList()));
    }

    public long extrapolateEnd() {
        List<LinkedList<Integer>> lines = buildTree();

        for(int i = lines.size() - 1; i >= 0; i--) {
            if(i == lines.size() - 1) {
                lines.get(i).add(0);
            } else {
                LinkedList<Integer> currentLine = lines.get(i);
                LinkedList<Integer> nextLine = lines.get(i + 1);
                int currentLineVal = lastInList(currentLine);
                int nextLineVal = lastInList(nextLine);
                currentLine.add(currentLineVal + nextLineVal);
            }
        }

        return lastInList(lines.get(0));
    }

    public long extrapolateStart() {
        List<LinkedList<Integer>> lines = buildTree();

        for(int i = lines.size() - 1; i >= 0; i--) {
            if(i == lines.size() - 1) {
                lines.get(i).add(0);
            } else {
                LinkedList<Integer> currentLine = lines.get(i);
                LinkedList<Integer> nextLine = lines.get(i + 1);
                int currentLineVal = currentLine.get(0);
                int nextLineVal = nextLine.get(0);
                currentLine.addFirst(currentLineVal - nextLineVal);
            }
        }

        return lines.get(0).get(0);
    }

    private List<LinkedList<Integer>> buildTree() {
        List<LinkedList<Integer>> lines = new ArrayList<>();
        LinkedList<Integer> currentLine = vals;

        lines.add(vals);

        while(!isAllZeros(currentLine)) {
            currentLine = computeDiffs(currentLine);
            lines.add(currentLine);
        }
        return lines;
    }

    private int lastInList(List<Integer> list) {
        return list.get(list.size() - 1);
    }

    private boolean isAllZeros(List<Integer> nums) {
        return nums.stream().filter(x -> x != 0).count() == 0;
    }

    private LinkedList<Integer> computeDiffs(List<Integer> nums) {
        LinkedList<Integer> result = new LinkedList<>();
        for(int i = 1; i < nums.size(); i++) {
            result.add( nums.get(i) - nums.get(i - 1) );
        }
        return result;
    }
}
