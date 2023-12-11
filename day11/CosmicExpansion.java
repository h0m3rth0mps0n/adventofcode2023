package adventofcode2023.day11;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class CosmicExpansion {
    private List<Point> galaxyPositions;
    private int numRows;
    private int numCols;
    public CosmicExpansion(List<String> input) {
        numRows = input.size();
        numCols = input.get(0).length();
        galaxyPositions = new ArrayList<>();

        for(int row = 0; row < numRows; row++) {
            String line = input.get(row);
            for(int col = 0; col < numCols; col++) {
                if(line.charAt(col) == '#') {
                    galaxyPositions.add(new Point(row, col));
                }
            }
        }
    }

    public void expand(int expansionFactor) {
        Set<Integer> emptyRows = emptyRows();
        Set<Integer> emptyCols = emptyCols();

        for(Point galaxy : galaxyPositions) {
            galaxy.row += (expansionFactor - 1) * numLessThan(emptyRows, galaxy.row);
            galaxy.col += (expansionFactor - 1) * numLessThan(emptyCols, galaxy.col);
        }

        numRows += emptyRows.size();
        numCols += emptyCols.size();
    }

    public long computeDistances() {
        long result = 0;
        for(int i = 0, size=getGalaxyPositions().size(); i < size; i++) {
            for(int j = i + 1; j < size; j++) {
                result += galaxyPositions.get(i)
                            .distanceFrom(galaxyPositions.get(j));
            }
        }
        return result;
    }

    private int numLessThan(Set<Integer> list, int val) {
        return (int) list.stream().filter(x -> x < val).count();
    }

    private Set<Integer> emptyRows() {
        Set<Integer> rowsWithGalaxies = galaxyPositions.stream()
                .map(Point::getRow)
                .collect(Collectors.toSet());
        Set<Integer> result = complementValues(rowsWithGalaxies, 0, numRows);
        return result;
    }

    private Set<Integer> emptyCols() {
        Set<Integer> colsWithGalaxies = galaxyPositions.stream()
                .map(Point::getCol)
                .collect(Collectors.toSet());
        Set<Integer> result = complementValues(colsWithGalaxies, 0, numCols);
        return result;
    }

    private Set<Integer> complementValues(Set<Integer> list, int min, int max) {
        Set<Integer> result = IntStream.range(min, max).boxed().collect(Collectors.toSet());
        result.removeAll(list);
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for(int row = 0; row < numRows; row++) {
            for(int col = 0; col < numCols; col++) {
                boolean isGalaxy = galaxyPositions.contains(new Point(row, col));
                sb.append(isGalaxy ? "#" : ".");
            }
            sb.append("\n");
        }
        return sb.toString();
    }

    public List<Point> getGalaxyPositions() {
        return galaxyPositions;
    }
}
