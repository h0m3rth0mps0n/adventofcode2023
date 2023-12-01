package adventofcode2023.day1;

import adventofcode2022.Util;
import org.apache.commons.lang3.StringUtils;

import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Day1 {
    static String[] wordList =  {
            "zero",
            "one",
            "two",
            "three",
            "four",
            "five",
            "six",
            "seven",
            "eight",
            "nine",
            "ten",
            "eleven",
            "twelve",
            "thirteen",
            "fourteen",
            "fifteen",
            "sixteen",
            "seventeen",
            "eighteen",
            "nineteen"
    };

    public static String replaceText(String s) {
        Map<Integer, Integer> pos = new HashMap<>();
        for(int num = 0; num < wordList.length; num++) {
            String word = wordList[num];
            int idx = s.indexOf(word);
            while(idx != -1) {
                pos.put(idx, num);
                idx = s.indexOf(word, idx + 1);
            }
        }

        for(int i = 0, len = s.length(); i < len; i++) {
            if(StringUtils.isNumeric("" + s.charAt(i))) {
                pos.put(i, Integer.parseInt("" + s.charAt(i)));
            }
        }

        return pos.entrySet().stream()
                .sorted(Comparator.comparing(Map.Entry::getKey))
                .map(x -> "" + x.getValue())
                .collect(Collectors.joining());
    }

    public static int getCalibrationValue(String s) {
        int result = 0;

        for(int i = 0, len = s.length(); i < len; i++) {
            String charStr = "" + s.charAt(i);
            if(StringUtils.isNumeric(charStr)) {
                result = 10 * Integer.parseInt(charStr);
                break;
            }
        }
        for(int len = s.length(), i = len - 1; i >= 0; i--) {
            String charStr = "" + s.charAt(i);
            if(StringUtils.isNumeric(charStr)) {
                result += Integer.parseInt(charStr);
                break;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        List<String> input = Util.getResourceLines("2023/day1.txt");

        part1(input);
        part2(input);
    }


    public static void part1(List<String> input) {
        System.out.println("Part 1:");
        int result = 0;
        for(String s : input) {
            result += getCalibrationValue(s);
        }
        System.out.println(result);

    }

    public static void part2(List<String> input) {
        System.out.println("Part 2:");
        int result = 0;
        for(String s : input) {
            s = replaceText(s);
            result += getCalibrationValue(s);
        }
        System.out.println(result);
    }
}
