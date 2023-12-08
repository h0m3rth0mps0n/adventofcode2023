package adventofcode2023.day8.bruteforce;

public class GhostNode extends Node {
    public GhostNode(String in) {
        super(in);
    }

    @Override
    public boolean isStartNode() {
        return getName().charAt(getName().length() - 1) == 'A';
    }

    @Override
    public boolean isEndNode() {
        return getName().charAt(getName().length() - 1) == 'Z';
    }
}
