package adventofcode2023.day10.p2;

import java.util.ArrayList;
import java.util.List;

public class Sketch {
    private List<List<VisitedTile>> grid;
    private Position startPos;
    boolean debug = false;

    private void debug(String val) {
        if(debug) {
            System.out.println(val);
        }
    }

    public Sketch(List<String> input) {
        grid = new ArrayList<>();
        for(int row = 0; row < input.size(); row++) {
            String line = input.get(row);
            grid.add(new ArrayList<>());
            for(int col = 0, len = line.length(); col < len; col++) {
                Tile t = Tile.toTile(line.charAt(col));
                grid.get(row).add(new VisitedTile(t));
                if(t == Tile.START) {
                    startPos = new Position(row, col);
                    debug("Start pos is: " + startPos);
                }
            }
        }

        debug(this.toString());

        Tile tile = StartTileMapper.mapStartTile(this);
        getTile(startPos).setTile(tile);
    }

    public VisitedTile getTile(Position pos) {
        if(!isValidPosition(pos)) return null;
        return grid.get(pos.row).get(pos.col);
    }

    private boolean isValidPosition(Position pos) {
        return pos.row >= 0 && pos.col >= 0 &&
                pos.row < grid.size() && pos.col < grid.size();
    }

    private boolean canMove(Position pos, Direction direction) {
        VisitedTile newTile = getTile(new Position(pos, direction));
        return newTile != null && getTile(pos).connects(direction) && newTile.canVisit();
    }

    public int traverse() {
        Position currentPos = new Position(startPos);

        int visitedTiles = 0;
        boolean finished = false;
        do {
            VisitedTile currentTile = getTile(currentPos);
            currentTile.visit();
            visitedTiles++;

            debug(String.format("At position %s.  Tile is: %s", currentPos, currentTile));
            if(canMove(currentPos, Direction.NORTH)) {
                currentPos = new Position(currentPos, Direction.NORTH);
            } else if(canMove(currentPos, Direction.SOUTH)) {
                currentPos = new Position(currentPos, Direction.SOUTH);
            } else if(canMove(currentPos, Direction.EAST)) {
                currentPos = new Position(currentPos, Direction.EAST);
            } else if(canMove(currentPos, Direction.WEST)) {
                currentPos = new Position(currentPos, Direction.WEST);
            } else {
                finished = true;
            }
        } while(!finished);

        return visitedTiles;
    }

    public List<List<VisitedTile>> getGrid() {
        return grid;
    }

    public Position  getStartPos() {
        return startPos;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for(List<VisitedTile> row : grid) {
            for(VisitedTile tile : row) {
                sb.append(tile);
            }
            sb.append("\n");
        }
        return sb.toString();
    }

}
