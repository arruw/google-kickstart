import java.util.*;
import java.util.function.Function;
import java.util.stream.*;
import java.io.*;

public class Solution {

    private static final Scanner _in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));

    private static long solve() {
        final int W = _in.nextInt();
        final int N = _in.nextInt();

        final int[] X = IntStream.range(0, W)
            .map(i -> _in.nextInt())
            .toArray();

        final Map<Integer, Long> C = Arrays.stream(X)
            .boxed()
            .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

        final int[] Y = Arrays.stream(X).distinct().toArray();

        long min = Long.MAX_VALUE;
        for (int n = 1; n <= N; n++) {   
            long moves = 0;
            for (int i = 0; i < Y.length; i++) {
                moves += Math.min(
                    Math.min(
                        Math.abs(Y[i] - n),
                        Y[i] + Math.abs(N - n)
                    ),
                    N - Y[i] + 1 + Math.abs(1 - n)
                ) * C.get(Y[i]);
            }
            min = Math.min(min, moves);
        }

        return min;
    }

    public static void main(String[] args) {
        int T = _in.nextInt();
        for (int i = 1; i <= T; ++i) {
            System.out.println("Case #" + i + ": " + solve());
        }
    }
}