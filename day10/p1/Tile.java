package adventofcode2023.day10.p1;

public enum Tile {
    VERICAL("|", true, true, false, false),
    HORIZONTAL("-", false, false, true, true),
    L("L", true, false, true, false),
    J("J", true, false, false, true),
    SEVEN("7", false, true, false, true),
    F("F", false, true, true, false),
    DOT(".", false, false, false, false),
    START("S", false, false, false, false);

    private String symbol;
    private boolean north;
    private boolean south;
    private boolean east;
    private boolean west;

    Tile(String symbol, boolean north, boolean south, boolean east, boolean west) {
        this.symbol = symbol;
        this.north = north;
        this.east = east;
        this.south = south;
        this.west = west;
    }

    public static Tile toTile(char c) {
        String val = "" + c;
        for(Tile t : Tile.values()) {
            if(val.equals(t.symbol)) return t;
        }
        return null;
    }

    public static Tile matchTile(boolean north, boolean south, boolean east, boolean west) {
        for(Tile t : Tile.values()) {
            if(t.north == north && t.south == south && t.east == east && t.west == west) return t;
        }
        return null;
    }

    @Override
    public String toString() {
        return symbol;
    }

    public boolean connectsNorth() {
        return north;
    }

    public boolean connectsSouth() {
        return south;
    }

    public boolean connectsEast() {
        return east;
    }

    public boolean connectsWest() {
        return west;
    }
}
