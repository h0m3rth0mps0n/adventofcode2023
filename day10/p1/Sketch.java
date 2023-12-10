package adventofcode2023.day10.p1;

import java.util.ArrayList;
import java.util.List;

public class Sketch {
    private List<List<VisitedTile>> grid;
    private int startRow;
    private int startCol;

    public Sketch(List<String> input) {
        grid = new ArrayList<>();
        for(int row = 0; row < input.size(); row++) {
            String line = input.get(row);
            grid.add(new ArrayList<>());
            for(int col = 0, len = line.length(); col < len; col++) {
                Tile t = Tile.toTile(line.charAt(col));
                grid.get(row).add(new VisitedTile(t));
                if(t == Tile.START) {
                    startRow = row;
                    startCol = col;
                }
            }
        }

        Tile tile = new StartTileMapper(this).map();
        grid.get(startRow).get(startCol).setTile(tile);

//        for(List<Tile> row : grid) {
//            for(Tile tile : row) {
//                System.out.print(tile);
//            }
//            System.out.println();
//        }
    }

    public boolean canMoveNorth(int row, int col) {
        if(row == 0) return false;
        VisitedTile north = grid.get(row - 1).get(col);
        return grid.get(row).get(col).connectsNorth() && north.canVisit();
    }

    public boolean canMoveSouth(int row, int col) {
        if(row == grid.size() - 1) return false;
        VisitedTile south = grid.get(row + 1).get(col);
        return grid.get(row).get(col).connectsSouth() && south.canVisit();
    }

    public boolean canMoveWest(int row, int col) {
        if(col == 0) return false;
        VisitedTile west = grid.get(row).get(col - 1);
        return grid.get(row).get(col).connectsWest() && west.canVisit();
    }

    public boolean canMoveEast(int row, int col) {
        if(col == grid.get(row).size() - 1) return false;
        VisitedTile east = grid.get(row).get(col + 1);
        return grid.get(row).get(col).connectsEast() && east.canVisit();
    }

    public int traverse() {
        VisitedTile currentTile = grid.get(startRow).get(startCol);
        int row = startRow;
        int col = startCol;

        int visitedTiles = 0;
        do {
            currentTile.visit();
            visitedTiles++;

//            System.out.printf("At position %d %d.  Tile is: %s\n", row, col, grid.get(row).get(col).getTile());
            if(canMoveNorth(row, col)) {
                row--;
            } else if(canMoveSouth(row, col)) {
                row++;
            } else if(canMoveEast(row, col)) {
                col++;
            } else if(canMoveWest(row, col)) {
                col--;
            } else {
                break;
            }

            currentTile = grid.get(row).get(col);
        } while(!currentTile.isStart());


        return visitedTiles;
    }

    public void printLoop() {
        for(List<VisitedTile> r : grid) {
            for(VisitedTile t : r) {
                System.out.print(t);
            }
            System.out.println();
        }
    }

    public List<List<VisitedTile>> getGrid() {
        return grid;
    }

    public int getStartRow() {
        return startRow;
    }

    public int getStartCol() {
        return startCol;
    }
}
