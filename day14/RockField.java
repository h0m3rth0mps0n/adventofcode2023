package adventofcode2023.day14;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class RockField {
    private List<List<Rock>> rocks;
    private int numRows;
    private int numCols;

    public RockField(List<String> input) {
        setState(input);
    }

    private void setState(List<String> input) {
        rocks = new ArrayList<>();
        for(String s : input) {
            List<Rock> row = new ArrayList<>();
            for(int i = 0; i < s.length(); i++) {
                row.add(Rock.lookup(s.charAt(i)));
            }
            rocks.add(row);
        }
        numRows = rocks.size();
        numCols = rocks.get(0).size();
    }

    private void setState(String input) {
        setState(List.of(input.split("\n")));
    }

    public int getLoad() {
        int result = 0;
        for(int row = 0, loadFactor = numRows;  row < numRows; row++, loadFactor--) {
            for(int col = 0; col < numCols; col++) {
                result += rocks.get(row).get(col) == Rock.ROUND ? loadFactor : 0;
            }
        }
        return result;
    }

    public void moveCycle() {
        moveNorth();
        moveWest();
        moveSouth();
        moveEast();
    }

    public void moveCycle(int cycleCount) {
        Map<String, List<Integer>> stateToCycle = new HashMap<>();
        String loopVal = "";
        boolean inLoop = false;

        for(int i = 1; i <= cycleCount; i++) {
            moveCycle();
            String key = toString();

            if (loopVal.equals(key)) break;

            if(!inLoop) {
                if (!stateToCycle.containsKey(key)) {
                    stateToCycle.put(key, new ArrayList<>());
                } else {
                    inLoop = true;
                    loopVal = key;
                }
            }

            stateToCycle.get(key).add(i);
        }

        if(inLoop) {
            Map<Integer, String> cycleToState =
                    stateToCycle.entrySet()
                            .stream()
                            .filter(x -> x.getValue().size() == 2)
                            .collect(Collectors.toMap(x -> x.getValue().get(0), Map.Entry::getKey));

            int loopStart = cycleToState.keySet().stream().mapToInt(Integer::intValue).min().getAsInt();
            int loopLength = cycleToState.keySet().size();
            int key = loopStart + ((cycleCount - loopStart) % loopLength);

            setState(cycleToState.get(key));
        }
    }

    public void moveNorth() {
        for(int col = 0; col < numCols; col++) {
            for(int row = 1; row < numRows; row++) {
                moveRock(row, col, Direction.NORTH);
            }
        }
    }

    public void moveSouth() {
        for(int col = 0; col < numCols; col++) {
            for(int row = numRows - 1; row >= 0; row--) {
                moveRock(row, col, Direction.SOUTH);
            }
        }
    }

    public void moveEast() {
        for(int row = 0; row < numRows; row++) {
            for(int col = numCols - 1; col >= 0; col--) {
                moveRock(row, col, Direction.EAST);
            }
        }
    }

    public void moveWest() {
        for(int row = 0; row < numRows; row++) {
            for(int col = 0; col < numCols; col++) {
                moveRock(row, col, Direction.WEST);
            }
        }
    }

    private void moveRock(int row, int col, Direction direction) {
        Rock rock = rocks.get(row).get(col);
        if(!rock.isMovable()) return;
        int newRow = row;
        int newCol = col;
        for(int currentRow = row + direction.getRowDelta(), currentCol = col + direction.getColDelta();
            canMoveTo(currentRow, currentCol);
            currentRow += direction.getRowDelta(), currentCol += direction.getColDelta()) {
                newRow += direction.getRowDelta();
                newCol += direction.getColDelta();
        }

        Rock temp = rocks.get(newRow).get(newCol);
        rocks.get(newRow).set(newCol, rock);
        rocks.get(row).set(col, temp);
    }

    private boolean canMoveTo(int row, int col) {
        return row >= 0 && row < numRows
                && col >= 0 && col < numCols
                && !rocks.get(row).get(col).isBlocking();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for(List<Rock> row : rocks) {
            for(Rock rock : row) {
                sb.append(rock);
            }
            sb.append("\n");
        }
        return sb.toString();
    }
}
