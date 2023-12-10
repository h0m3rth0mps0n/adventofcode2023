package adventofcode2023.day10.p2;

public class StartTileMapper {
    private Sketch sketch;
    private Position startPos;
    private StartTileMapper(Sketch sketch) {
        this.sketch = sketch;
        this.startPos = sketch.getStartPos();
    }

    private boolean canMoveNorth() {
        VisitedTile north = sketch.getTile(new Position(startPos, Direction.NORTH));
        return north != null && north.connectsSouth();
    }

    private boolean canMoveSouth() {
        VisitedTile south = sketch.getTile(new Position(startPos, Direction.SOUTH));
        return south != null && south.connectsNorth();
    }

    private boolean canMoveWest() {
        VisitedTile west = sketch.getTile(new Position(startPos, Direction.WEST));
        return west != null && west.connectsEast();
    }

    private boolean canMoveEast() {
        VisitedTile east = sketch.getTile(new Position(startPos, Direction.EAST));
        return east != null && east.connectsWest();
    }

    private Tile map() {
        return Tile.matchTile(
                canMoveNorth(),
                canMoveSouth(),
                canMoveEast(),
                canMoveWest());
    }

    public static Tile mapStartTile(Sketch sketch) {
        return (new StartTileMapper(sketch)).map();
    }
}
