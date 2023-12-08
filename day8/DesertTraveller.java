package adventofcode2023.day8;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DesertTraveller {
    private String instructions;
    private Map<String, Node> nodes;

    public DesertTraveller(List<String> in) {
        instructions = in.get(0);
        nodes = new HashMap<>();
        initNodes(in);
    }

    protected void initNodes(List<String> in) {
        for(int i = 2; i < in.size(); i++) {
            Node n = new Node(in.get(i));
            nodes.put(n.getName(), n);
        }
    }
    public long traverse(String start, String end) {
        return traverse(
                nodes.get(start),
                List.of(nodes.get(end))
        );
    }

    public long traverse(Node start, List<Node> end) {
        long steps = 0;
        Node currentNode = start;

        while(!end.contains(currentNode)) {
            int idx = (int) ((steps) % instructions.length());
            steps++;

//            System.out.printf("Location is %s\n", current);
            switch(instructions.charAt(idx)) {
                case 'L':
                    currentNode = nodes.get(currentNode.getLeft());
                    break;
                case 'R':
                    currentNode = nodes.get(currentNode.getRight());
                    break;
            }
//            System.out.printf("After traversing %c, location is %s\n", instructions.charAt(idx), current.getName());
        }

        return steps;
    }

    public String getInstructions() {
        return instructions;
    }

    public Map<String, Node> getNodes() {
        return nodes;
    }
}
