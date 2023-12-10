package adventofcode2023.day10.p2;

public enum Direction {
    NORTH(-1,0), SOUTH(1, 0), EAST(0,1), WEST(0,-1);
    private int yDelta;
    private int xDelta;

    Direction(int yDelta, int xDelta) {
        this.yDelta = yDelta;
        this.xDelta = xDelta;
    }

    public int getY() {
        return yDelta;
    }

    public int getX() {
        return xDelta;
    }
}
