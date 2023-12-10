package adventofcode2023.day10.p2;

public class Position {
    int row;
    int col;

    public Position(int row, int col) {
        this.row = row;
        this.col = col;
    }

    public Position(Position pos) {
        this.row = pos.row;
        this.col = pos.col;
    }

    public Position(Position pos, Direction d) {
        this.row = pos.row + d.getY();
        this.col = pos.col + d.getX();
    }

    @Override public String toString() {
        return String.format("(%d, %d)", row, col);
    }
}
