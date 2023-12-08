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

    public List<Node> getStartNodes() {
        List<Node> result = new ArrayList<>();
        for(Node node : getNodes().values()) {
            if(node.isStartNode()) {
                result.add(node);
            }
        }
        return result;
    }

    public boolean isAtEnd(List<Node> nodeList) {
        for(Node node : nodeList) {
            if(!node.isEndNode()) return false;
        }
        return true;
    }

    public long traverse() {
        List<Node> currentNodeList = getStartNodes();
        long steps = 0;
        while(!isAtEnd(currentNodeList)) {
            int idx = (int) ((steps) % instructions.length());
            steps++;

//            System.out.printf("Location is %s\n", current);
            switch(instructions.charAt(idx)) {
                case 'L':
                    for(int i = 0; i < currentNodeList.size(); i++) {
                        currentNodeList.set(i,
                            nodes.get(currentNodeList.get(i).getLeft()));
                    }
                    break;
                case 'R':
                    for(int i = 0; i < currentNodeList.size(); i++) {
                        currentNodeList.set(i,
                                nodes.get(currentNodeList.get(i).getRight()));
                    }
                    break;
            }
            if(steps % 10000 == 0) System.out.println("At step " + steps);
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
