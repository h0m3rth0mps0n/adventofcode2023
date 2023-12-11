package adventofcode2023.day10.p2;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Sketch {
    private List<List<VisitedTile>> grid;
    private Position startPos;
    boolean debug = false;
    boolean showAllPipes = true;

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
                pos.row < grid.size() && pos.col < grid.get(pos.row).size();
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
                sb.append(showAllPipes ? tile.getTile() : tile);
            }
            sb.append("\n");
        }
        return sb.toString();
    }

    public void drawPipes() {
        for(List<VisitedTile> row : grid) {
            for(VisitedTile tile : row) {
                System.out.print(tile.canVisit() ? "." : "*");
            }
            System.out.println();
        }
    }

//    private boolean canEscape(Position p, Direction d) {
//        VisitedTile tile = getTile(p);
//        if(tile == null) return false;
//        if(tile.isFilled()) return true;
//        if(tile.isBlocked(d)) return false;
//
//        return canEscape(new Position(p, d), d);
//    }
//
//    private boolean canEscape(Position p) {
//        return canEscape(p, Direction.EAST)
//                || canEscape(p, Direction.WEST)
//                || canEscape(p, Direction.NORTH)
//                || canEscape(p, Direction.SOUTH);
//    }
//
//    public int fill() {
//        fill(new Position(0,0));
//
//        for(Position p : getEnclosedTilePos()) {
//            if(canEscape(p)) {
//                System.out.printf("Position %s can escape\n", p );
//                fill(p);
//            } else {
//                System.out.printf("Position %s cannot escape\n", p );
//            }
//        }
//        return getEnclosedTilePos().size();
//    }
//
//    private void fill(Position start) {
//        Queue<Position> queue = new LinkedList<>();
//        queue.add(start);
//        while(!queue.isEmpty()) {
//            Position current = queue.poll();
//            VisitedTile tile = getTile(current);
//            if(tile != null && tile.canVisit() && !tile.isFilled()) {
//                tile.fill();
//                queue.add(new Position(current, Direction.WEST));
//                queue.add(new Position(current, Direction.EAST));
//                queue.add(new Position(current, Direction.NORTH));
//                queue.add(new Position(current, Direction.SOUTH));
//            }
//        }
//    }
//
//    private List<Position> getEnclosedTilePos() {
//        List<Position> result = new ArrayList<>();
//        for(int r = 0; r < grid.size(); r++) {
//            List<VisitedTile> row = grid.get(r);
//            for(int c = 0; c < row.size(); c++) {
//                VisitedTile tile = row.get(c);
//                if(!tile.isFilled() && tile.canVisit()) {
//                    result.add(new Position(r,c));
//                }
//            }
//        }
//        return result;
//    }
    public int findEnclosed() {
        int result = 0;
        for(List<VisitedTile> row : grid) {
            boolean enclosed = false;
            for(VisitedTile tile : row) {
                boolean isWall = !tile.canVisit() && tile.getTile() != Tile.DOT;
                if(isWall && (tile.getTile() == Tile.VERICAL || tile.getTile() == Tile.J || tile.getTile() == Tile.L)) {
                    enclosed = !enclosed;
                    System.out.print("|");
                } else if( enclosed && !isWall) {
                    result++;
                    System.out.print("X");
                } else {
                    System.out.print(".");
                }
            }
            System.out.println();
        }
        return result;
    }
}
