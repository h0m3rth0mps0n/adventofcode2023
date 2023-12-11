package adventofcode2023.day11;

public class Point {
    int row;
    int col;

    public Point(int row, int col) {
        this.row = row;
        this.col = col;
    }

    public long distanceFrom(Point p) {
        return Math.abs(p.row - row) + Math.abs(p.col - col);
    }

    public int getRow() {
        return row;
    }

    public int getCol() {
        return col;
    }

    @Override
    public String toString() {
        return String.format("(%d, %d)", row, col);
    }

    @Override
    public int hashCode() {
        return row + col;
    }

    @Override
    public boolean equals(Object obj) {
        if(! (obj instanceof Point)) return false;
        Point p = (Point) obj;
        return p.row == row && p.col == col;
    }
}
