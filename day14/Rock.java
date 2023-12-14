package adventofcode2023.day14;

public enum Rock {
    ROUND(true, true, 'O'),
    CUBE(false, true, '#'),
    EMPTY(false, false, '.');

    private boolean movable;
    private boolean blocking;
    private char symbol;

    Rock(boolean movable, boolean blocking, char symbol) {
        this.movable = movable;
        this.blocking = blocking;
        this.symbol = symbol;
    }

    boolean isMovable() {
        return movable;
    }

    boolean isBlocking() {
        return blocking;
    }

    static Rock lookup(char symbol) {
        for(Rock r : values()) {
            if(r.symbol == symbol) return r;
        }
        throw new IllegalArgumentException();
    }

    @Override
    public String toString() {
        return "" + symbol;
    }
}
