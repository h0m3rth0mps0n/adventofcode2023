package adventofcode2023.day3;

import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class SchematicLine {
    private String value;
    private SchematicLine previous;
    private SchematicLine next;
    List<PartNumber> partNumbers;
    List<Integer> symbolPositions;
    List<Gear> gears;

    public SchematicLine(String value) {
        this.value = value;
        parse(value);
    }

    private boolean isNumeric(char c) {
        return StringUtils.isNumeric("" + c);
    }

    private void parse(String value) {
        partNumbers = new ArrayList<>();
        symbolPositions = new ArrayList<>();
        for(int i = 0, len = value.length(); i < len; i++) {
            if(isNumeric(value.charAt(i))) {
                int pos = i;
                String num = "" + value.charAt(i);
                while(i + 1 < len && isNumeric(value.charAt(i + 1)) ) {
                    i++;
                    num += value.charAt(i);
                }
                partNumbers.add(new PartNumber(num, pos));
            } else if(value.charAt(i) != '.') {
                symbolPositions.add(i);
            }
        }
    }

    public boolean containsSymbol(int start, int end) {
        return symbolPositions.stream()
                .filter(x -> x >= start && x <= end)
                .count() != 0;
    }

    public List<PartNumber> adjacentPartNumber(int location) {
//        partNumbers.stream()
//                .forEach(x -> System.out.println(x.value + ": " +  (x.position - 1) + " <= " + location + " <= " + (x.position + x.value.length()) ));
        return partNumbers.stream()
                .filter(x -> x.position - 1 <= location && x.position + x.value.length() >= location)
                .collect(Collectors.toList());
    }

    public void updatePartNumbers() {
        List<PartNumber> newList = new ArrayList<>();
        for(PartNumber partNumber : partNumbers) {
            int startPos = partNumber.position - 1;
            int endPos = partNumber.position + partNumber.value.length();
            boolean isValid = containsSymbol(startPos, endPos)
                || ( previous != null && previous.containsSymbol(startPos, endPos))
                || ( next != null && next.containsSymbol(startPos, endPos));

            if(isValid) {
                newList.add(partNumber);
            }
        }
        this.partNumbers = newList;
    }

    public void updateGears() {
        gears = new ArrayList<>();
        for(Integer i : symbolPositions) {
            if(value.charAt(i) == '*') {
                List<PartNumber> adjacent = new ArrayList<>();
                adjacent.addAll(adjacentPartNumber(i));
                if( ( previous != null) ) adjacent.addAll(previous.adjacentPartNumber(i));
                if( ( next != null) ) adjacent.addAll(next.adjacentPartNumber(i));

                if(adjacent.size() == 2) {
                    gears.add(new Gear(adjacent.get(0), adjacent.get(1)));
//                    System.out.println("Line " + value + " contains gear at " + i);
//                    System.out.println("Adjacent part numbers: " + adjacent);
                }
//                else  {
//                    System.out.println("Line " + value + " DOES NOT contain gear at " + i);
//                    System.out.println("Adjacent part numbers: " + adjacent);
//                }
            }
        }
    }

    public SchematicLine getPrevious() {
        return previous;
    }

    public void setPrevious(SchematicLine previous) {
        this.previous = previous;
    }

    public SchematicLine getNext() {
        return next;
    }

    public void setNext(SchematicLine next) {
        this.next = next;
    }

    public List<PartNumber> getPartNumbers() {
        return partNumbers;
    }

    public List<Gear> getGears() {
        return gears;
    }

    @Override
    public String toString() {
        return "SchematicLine{" +
                "value='" + value + '\'' +
                ", partNumbers=" + partNumbers +
                ", symbolPositions=" + symbolPositions +
                '}';
    }
}
