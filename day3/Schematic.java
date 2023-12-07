package adventofcode2023.day3;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class Schematic {
    List<SchematicLine> lines;

    public Schematic(List<String> input) {
        lines = new ArrayList<>();
        for(String line : input) {
            SchematicLine current = new SchematicLine(line);
            lines.add(current);
        }

        for(int i = 0; i < lines.size(); i++) {
            SchematicLine line = lines.get(i);
            if(i != 0) {
                line.setPrevious(lines.get(i - 1));
            }
            if(i != lines.size() - 1) {
                line.setNext(lines.get(i + 1));
            }

            line.updatePartNumbers();
            line.updateGears();
        }
    }

    public List<PartNumber> getPartNumbers() {
        return lines.stream()
                .map(SchematicLine::getPartNumbers)
                .flatMap(Collection::stream)
                .collect(Collectors.toList());
    }

    public List<Gear> getGears() {
        return lines.stream()
                .map(SchematicLine::getGears)
                .flatMap(Collection::stream)
                .collect(Collectors.toList());
    }

    @Override
    public String toString() {
//        return "Schematic{" +
//                "lines=" + lines +
//                '}';
        return lines.stream().map(SchematicLine::toString).collect(Collectors.joining("\n"));
    }
}
