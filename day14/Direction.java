package adventofcode2023.day14;

public enum Direction {
    NORTH(-1, 0),
    SOUTH(1,0),
    EAST(0,1),
    WEST(0,-1);

    private int rowDelta;
    private int colDelta;

    Direction(int rowDelta, int colDelta) {
        this.rowDelta = rowDelta;
        this.colDelta = colDelta;
    }

    public int getRowDelta() {
        return rowDelta;
    }

    public int getColDelta() {
        return colDelta;
    }
}
