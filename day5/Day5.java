package adventofcode2023.day5;

import adventofcode2022.Util;
import org.apache.commons.lang3.IntegerRange;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.LongStream;

public class Day5 {
    public static void main(String[] args) {
        List<String> input = Util.getResourceLines("2023/day5sample.txt");
//        List<String> input = Util.getResourceLines("2023/day5.txt");

        List<Long> seeds = Arrays.stream(input.get(0)
                .split(":")[1]
                .trim()
                .split(" "))
                .map(Long::parseLong)
                .collect(Collectors.toList());
        MapperChain mapperChain = new MapperChain(input);

        part1(seeds, mapperChain);
        part2(seeds, mapperChain);
    }

    public static void part1(List<Long> seeds, MapperChain mapperChain) {
        System.out.println("Part 1:");
        long result = seeds.stream().mapToLong(x -> mapperChain.map(x))
                .min().getAsLong();
        System.out.println(result);
    }

    public static void part2(List<Long> seedRanges, MapperChain mapperChain) {
        System.out.println("Part 2:");
        List<Long> allSeeds = new ArrayList<>();
        long result = Long.MAX_VALUE;
        for(int idx = 0, len = seedRanges.size(); idx < len; idx+=2) {
            for(long val = seedRanges.get(idx), end = val + seedRanges.get(idx + 1); val < end; val++ ) {
                result = Math.min(result, mapperChain.map(val));
            }
        }
        System.out.println(result);
    }
}
