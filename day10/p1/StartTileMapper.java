package adventofcode2023.day10.p1;

public class StartTileMapper {
    private Sketch sketch;
    public StartTileMapper(Sketch sketch) {
        this.sketch = sketch;
    }

    public boolean canMoveNorth(int row, int col) {
        if(row == 0) return false;
        VisitedTile north = sketch.getGrid().get(row - 1).get(col);
        return north.connectsSouth();
    }

    public boolean canMoveSouth(int row, int col) {
        if(row == sketch.getGrid().size() - 1) return false;
        VisitedTile south = sketch.getGrid().get(row + 1).get(col);
        return  south.connectsNorth();
    }

    public boolean canMoveWest(int row, int col) {
        if(col == 0) return false;
        VisitedTile west = sketch.getGrid().get(row).get(col - 1);
        return west.connectsEast();
    }

    public boolean canMoveEast(int row, int col) {
        if(col == sketch.getGrid().get(row).size() - 1) return false;
        VisitedTile east = sketch.getGrid().get(row).get(col + 1);
        return east.connectsWest();
    }

    public Tile map() {
        return Tile.matchTile(
                canMoveNorth(sketch.getStartRow(), sketch.getStartCol()),
                canMoveSouth(sketch.getStartRow(), sketch.getStartCol()),
                canMoveEast(sketch.getStartRow(), sketch.getStartCol()),
                canMoveWest(sketch.getStartRow(), sketch.getStartCol())
        );
    }
}
