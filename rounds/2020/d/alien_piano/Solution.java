import java.util.*;
import java.io.*;
import java.util.stream.*;

public class Solution {

    private static final Scanner _in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));

    private static int addError(int from, int to, int a0, int a1, int errors) {
        boolean isError = !(
            (a0 <  a1 && to > from ) ||
            (a0 >  a1 && to < from ) ||
            (a0 == a1 && to == from)
        );

        return isError ? errors+1 : errors;
    }

    private static int solve() {
        final int K = _in.nextInt();
        final int[] A = new int[K];
        for (int i = 0; i < K; i++) {
            A[i] = _in.nextInt();
        }

        int[][] dt = new int[K][4];

        for (int i = 1; i < K; i++) {
            for (int j = 0; j < 4; j++) {

                dt[i][j] = Integer.MAX_VALUE;
                for (int k = 0; k < 4; k++) {
                    dt[i][j] = Math.min(dt[i][j], addError(k, j, A[i-1], A[i], dt[i-1][k]));
                }

            }
        }

        return Arrays.stream(dt[K-1]).min().getAsInt();
    }

    public static void main(String[] args) {
        int T = _in.nextInt();
        for (int i = 1; i <= T; ++i) {
            System.out.println("Case #" + i + ": " + solve());
        }
    }
}