package adventofcode2023.day3;

public class Gear {
    PartNumber p1;
    PartNumber p2;

    public Gear(PartNumber p1, PartNumber p2) {
        this.p1 = p1;
        this.p2 = p2;
    }

    public int getRatio() {
        return p1.getValue() * p2.getValue();
    }
}
