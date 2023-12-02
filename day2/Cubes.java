package adventofcode2023.day2;

public class Cubes {
    int red;
    int green;
    int blue;

    public boolean isPossible(int red, int green, int blue) {
        return this.red <= red && this.green <= green && this.blue <= blue;
    }

    public int getPower() {
        return red * green * blue;
    }

    @Override
    public String toString() {
        return "Cubes{" +
                "red=" + red +
                ", green=" + green +
                ", blue=" + blue +
                '}';
    }

    public static Cubes parse(String str) {
        Cubes result = new Cubes();
        String[] parts = str.split(",");
        for(String val : parts) {
            int num = Integer.parseInt(val.trim().split(" ")[0]);
            if(val.contains("blue")) result.blue = num;
            if(val.contains("green")) result.green = num;
            if(val.contains("red")) result.red = num;
        }
        return result;
    }
}
