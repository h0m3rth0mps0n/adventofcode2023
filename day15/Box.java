package adventofcode2023.day15;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Box {
    private List<Lens> lenses;
    private int label;
    public Box(int label) {
        this.label = label;
        lenses = new ArrayList<>();
    }

    public int getFocusingPower() {
        int result = 0;

        for(int i = 0; i < lenses.size(); i++ ) {
            result += (label + 1) * (i + 1) * lenses.get(i).getFocalLength();
        }

        return result;
    }

    public void processLens(Lens lens) {
        switch(lens.getOperation()) {
            case ADD:
                add(lens);
                break;
            case REMOVE:
                remove(lens);
                break;
        }
    }

    private void add(Lens lens) {
        int idx = lenses.indexOf(lens);
        if(idx != -1) {
            lenses.set(idx, lens);
        } else {
            lenses.add(lens);
        }
    }

    private void remove(Lens lens) {
        lenses.remove(lens);
    }

    public boolean isEmpty() {
        return lenses.isEmpty();
    }

    @Override
    public String toString() {
        if(lenses.isEmpty()) return "";
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("Box %d: ", label));
        sb.append(lenses.stream().map(Lens::toString).collect(Collectors.joining(" ")));
        return sb.toString();
    }
}
