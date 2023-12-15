package adventofcode2023.day15;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class Boxes {
    Map<Integer, Box> boxMap;
    public Boxes() {
        boxMap = new LinkedHashMap<>();
        for(int i = 0; i < 256; i++) {
            boxMap.put(i, new Box(i));
        }
    }

    public void processLens(Lens lens) {
        Box box = boxMap.get(lens.getHash());
        box.processLens(lens);
    }

    public int getFocusingPower() {
        int result = 0;
        for(Box box : boxMap.values()) {
            result += box.getFocusingPower();
        }
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for(Box b : boxMap.values()) {
            if(!b.isEmpty()) {
                sb.append(b + "\n");
            }
        }
        return sb.toString();
    }
}
