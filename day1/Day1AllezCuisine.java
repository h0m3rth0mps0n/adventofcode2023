package adventofcode2023.day1;

import org.apache.commons.io.IOUtils;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Day1AllezCuisine {
    static Map<String, Object> values = new HashMap<>();

    public static void filterString() {
        values.put("stringIndex", 0);
        values.put("stringLength", ((String) values.get("currentInput")).length());
        values.put("filterString", "");

        while((Integer) values.get("stringIndex") < (Integer) values.get("stringLength")) {
            values.put("currentChar", ((String) values.get("currentInput")).charAt((Integer)values.get("stringIndex")));
            if( ((Character) values.get("currentChar")).charValue() >= '1' &&
                    ((Character) values.get("currentChar")).charValue() <= '9') {
                values.put("filterString", ((String) values.get("filterString") + values.get("currentChar")));
            }
            values.put("stringIndex", ((Integer) values.get("stringIndex")) + 1);
        }
        values.put("filterStringLength", ((String) values.get("filterString")).length());
    }

    public static void getCalibrationValue() {
        values.put("calibrationValue",
                Integer.parseInt("" + ((String) values.get("filterString")).charAt(0)) * 10);

        values.put("calibrationValue",
                ((Integer) values.get("calibrationValue")) +
                Integer.parseInt("" + ((String) values.get("filterString"))
                        .charAt( (Integer) values.get("filterStringLength") - 1)));
    }

    public static void main(String args[]) throws Exception {
        values.put("filename", "2023/day1.txt");
        values.put("inputTemp", IOUtils.toString(Day1AllezCuisine.class.getClassLoader().getResourceAsStream((String) values.get("filename"))));
        values.put("input", Arrays.asList(((String) values.get("inputTemp") ).split("\n")));
        values.put("inputLength", ((List<String>) values.get("input")).size());

        values.put("inputIndex", 0);
        values.put("result", 0);

        while((Integer) values.get("inputIndex") < (Integer) values.get("inputLength")) {
            values.put("currentInput", ((List<String>) values.get("input")).get((Integer) values.get("inputIndex")));
            values.put("inputIndex", (Integer) values.get("inputIndex") + 1);
            filterString();
            getCalibrationValue();
            values.put("result",
                    ((Integer) values.get("result")) +
                    ((Integer) values.get("calibrationValue"))
            );
        }

        System.out.println(values.get("result"));
    }
}
