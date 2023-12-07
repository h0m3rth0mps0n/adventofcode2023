package adventofcode2023.day5;

import java.util.ArrayList;
import java.util.List;

public class MapperChain {
    private List<Mapper> mappers;
    public MapperChain(List<String> input) {
        mappers = new ArrayList<>();
        for(int idx = 0, len = input.size(); idx < len; idx++) {
            if(input.get(idx).contains("map")) {
                mappers.add(new Mapper(input, idx + 1));
            }
        }
    }

    public long map(long val) {
        long result = val;
        for(Mapper mapper : mappers) {
            result = mapper.map(result);
        }
        return result;
    }
}
