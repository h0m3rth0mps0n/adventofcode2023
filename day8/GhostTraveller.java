package adventofcode2023.day8;

import java.util.ArrayList;
import java.util.List;

public class GhostTraveller extends DesertTraveller {

    public GhostTraveller(List<String> in) {
        super(in);
    }

    public List<Node> getStartNodes() {
        List<Node> result = new ArrayList<>();
        for(Node n : getNodes().values()) {
            if(n.getName().endsWith("A")) {
                result.add(n);
            }
        }
        return result;
    }

    public List<Node> getEndNodes() {
        List<Node> result = new ArrayList<>();
        for(Node n : getNodes().values()) {
            if(n.getName().endsWith("Z")) {
                result.add(n);
            }
        }
        return result;
    }
}
