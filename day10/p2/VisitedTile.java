package adventofcode2023.day10.p2;

public class VisitedTile {
    private Tile tile;
    private boolean visited;
    private boolean isStart;
    private boolean filled;

    public VisitedTile(Tile tile) {
        this.tile = tile;
        isStart = tile == Tile.START;
        visited = false;
        filled = false;
    }

    public boolean isStart() {
        return isStart;
    }

    public boolean canVisit() {
        return visited == false ;
    }

    public Tile getTile() {
        return tile;
    }

    public void setTile(Tile tile) {
        this.tile = tile;
    }

    public void visit() {
        visited = true;
    }

    @Override
    public String toString() {
        return visited ? getTile().toString() :
                filled ? "O" : "I";
    }

    public boolean connectsNorth() {
        return tile.connectsNorth();
    }

    public boolean connectsSouth() {
        return tile.connectsSouth();
    }

    public boolean connectsEast() {
        return tile.connectsEast();
    }

    public boolean connectsWest() {
        return tile.connectsWest();
    }

    public boolean connects(Direction direction) {
        switch (direction) {
            case NORTH: return connectsNorth();
            case SOUTH: return connectsSouth();
            case EAST: return connectsEast();
            case WEST: return connectsWest();
        }
        throw new UnsupportedOperationException("huh?");
    }

    public boolean isBlocked(Direction fromDirection) {
        if(canVisit()) return false;

        boolean connectsNorthSouth = tile.connectsSouth() || tile.connectsNorth();
        boolean connectsEastWest = tile.connectsWest() || tile.connectsEast();
        return
                (connectsNorthSouth && fromDirection == Direction.EAST || fromDirection == Direction.WEST)
                || (connectsEastWest && fromDirection == Direction.NORTH || fromDirection == Direction.SOUTH);
    }

    public void fill() {
        filled = true;
    }

    public boolean isFilled() {
        return filled;
    }
}
