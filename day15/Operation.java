package adventofcode2023.day15;

public enum Operation {
    ADD("="), REMOVE("-");
    private String symbol;
    Operation(String symbol) {
        this.symbol = symbol;
    }

    public String getSymbol() {
        return symbol;
    }

    public static Operation parseOperation(String val) {
        for(Operation o : values()) {
            if(val.indexOf(o.symbol) != -1) return o;
        }
        throw new IllegalArgumentException();
    }
}
