package adventofcode2023;

public class Algorithms {
    public static long gcd(long a, long b) {
        long large = a > b ? a : b;
        long small = large == a ? b : a;

        if(small == 0) return large;
        return gcd(small, large % small);
    }

    public static long lcm(long a, long b) {
        return Math.abs(a) * ( Math.abs(b) / gcd(a,b) );
    }
}
