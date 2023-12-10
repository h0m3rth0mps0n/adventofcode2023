package adventofcode2023.day10.p2;

public class VisitedTile {
    private Tile tile;
    private boolean visited;
    private boolean isStart;

    public VisitedTile(Tile tile) {
        this.tile = tile;
        isStart = tile == Tile.START;
        visited = false;
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
        return tile.toString();
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
}
