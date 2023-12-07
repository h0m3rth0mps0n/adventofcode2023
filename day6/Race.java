package adventofcode2023.day6;

public class Race {
    private long time;
    private long record;
    private long winningStart;

    public Race(long time, long record) {
        this.time = time;
        this.record = record;
        this.winningStart = computeWinningStart();
    }

    public long getTime() {
        return time;
    }

    public long getRecord() {
        return record;
    }

    private long computeWinningStart() {
        return (long) Math.ceil( ( -1.0 * getTime() + Math.sqrt( getTime() *getTime() - 4 * getRecord() )) / -2.0 );
    }

    public long getWinningStart() {
        return winningStart;
    }

    public long getWinningEnd() {
        return getTime() - getWinningStart();
    }

    public long getWinningCombos() {
        return getWinningEnd() - getWinningStart() + 1;
    }

    @Override
    public String toString() {
        return "Race{" +
                "time=" + time +
                ", record=" + record +
                '}';
    }
}
