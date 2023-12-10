package adventofcode2023.day10.p2;

import adventofcode2022.Util;

import java.util.List;

public class Day10 {
    public static void main(String[] args) {
//        List<String> input = Util.getResourceLines("2023/day10sample.txt");
        List<String> input = Util.getResourceLines("2023/day10.txt");
        Sketch sketch = new Sketch(input);
        long result = sketch.traverse() / 2;
        System.out.println(result);

    }

}
