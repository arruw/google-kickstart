import java.util.*;
import java.io.*;
import java.lang.*;
import java.util.stream.Collectors;

public class Solution {

    private static final Scanner _in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));

    private static List<Integer> long2digits(long n) {
        return Long.toString(n).chars().boxed().map(p -> p - '0').collect(Collectors.toList());
    }

    private static long digits2long(List<Integer> digits) {
        long n = 0;
        int len = digits.size();
        for (int i = 0; i < len; i++) {
            n += digits.get(i) * (long)Math.pow(10, len - i - 1);
        }
        return n;
    }

    private static long ops(long a, long b) {
        return Math.abs(a-b);
    }

    private static long solveInc(long n) {
        List<Integer> digits = long2digits(n);

        boolean bubble = false;
        boolean clean = false;
        int i = 0;
        while (i < digits.size()) {
            if (clean) {
                digits.set(i, 0);
                i++;
            } else if (bubble) {
                bubble = false;
                if (i == -1) {
                    digits.add(0, 2);
                    clean = true;
                    i++;
                } else {
                    int d = digits.get(i);
                    if (d == 8) {
                        digits.set(i, 0);
                        bubble = true;
                        i--;
                    } else {
                        digits.set(i, d+2);
                        clean = true;
                        i++;
                    }
                }
            } else {
                int d = digits.get(i);
                if (d % 2 == 0) {
                    i++;
                } else {
                    if (d == 9) {
                        digits.set(i, 0);
                        bubble = true;
                        i--;
                    } else {
                        digits.set(i, d+1);
                        clean = true;
                        i++;
                    }
                }
            }
        }

        return digits2long(digits);
    }

    private static long solveDec(long n) {
        List<Integer> digits = long2digits(n);

        boolean clean = false;
        int i = 0;
        while (i < digits.size()) {
            if (clean) {
                digits.set(i, 8);
                i++;
            } else {
                int d = digits.get(i);
                if (d % 2 == 0) {
                    i++;
                } else {
                    digits.set(i, d-1);
                    clean = true;
                    i++;
                }
            }
        }

        return digits2long(digits);
    }

    private static long solve() {
        long n = _in.nextLong();
        return Math.min(ops(n, solveInc(n)), ops(n, solveDec(n)));
    }

    public static void main(String[] args) {
        int t = _in.nextInt();
        for (int i = 1; i <= t; ++i) {
            System.out.println("Case #" + i + ": " + solve());
        }
    }
}