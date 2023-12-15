package adventofcode2023.day15;

public class Lens {
    private String label;
    private int focalLength;
    private Operation operation;

    public Lens(String in) {
        operation = Operation.parseOperation(in);
        String[] parts = in.split(operation.getSymbol());
        label = parts[0];
        if(operation == Operation.ADD) {
            focalLength = Integer.parseInt(parts[1]);
        }
    }

    public int getHash() {
        return Hash.hash(label);
    }

    public Operation getOperation() {
        return operation;
    }

    public int getFocalLength() {
        return focalLength;
    }

    public String getLabel() {
        return label;
    }

    @Override
    public String toString() {
        return String.format("[%s %d]", label, focalLength);
    }

    @Override
    public int hashCode() {
        return getHash();
    }

    @Override
    public boolean equals(Object o) {
        if(!(o instanceof Lens)) return false;
        return label.equals( ((Lens) o).getLabel());
    }
}
