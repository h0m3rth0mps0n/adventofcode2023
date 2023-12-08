package adventofcode2023.day8;

public class Node {
    private String name;
    private String left;
    private String right;

    public Node(String in) {
        String parts[] = in.split("\\(")[1].split("\\)")[0].split(",");

        name = in.split("=")[0].trim();
        left = parts[0].trim();
        right = parts[1].trim();
    }

    public boolean isStartNode() {
        return "AAA".equals(getName());
    }

    public boolean isEndNode() {
        return "ZZZ".equals(getName());
    }

    public String getName() {
        return name;
    }

    public String getLeft() {
        return left;
    }

    public String getRight() {
        return right;
    }

    @Override
    public String toString() {
        return name + " = (" +
                left + ", " +
                right + ')';

    }
}
