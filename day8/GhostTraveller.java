package adventofcode2023.day8;

import java.util.List;

public class GhostTraveller extends DesertTraveller {
    public GhostTraveller(List<String> in) {
        super(in);
    }

    @Override
    protected void initNodes(List<String> in) {
        for(int i = 2; i < in.size(); i++) {
            Node n = new GhostNode(in.get(i));
            getNodes().put(n.getName(), n);
        }
    }
}
