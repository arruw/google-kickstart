import java.util.*;
import java.io.*;

public class Solution {

    private static final Scanner _in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));

    private static int solve() {
        final int K = _in.nextInt();
        int[] A = new int[K];
        for (int i = 0; i < K; i++) {
            A[i] = _in.nextInt();
        }

        int result = 0;
        int key = 0;
        int prev = A[0], curr;
        for (int i = 1; i < K; i++) {
            curr = A[i];
            if (prev > curr)
                key = 0;
            else if(curr > prev && key < 3)
                key++;
            else if(curr > prev && key == 3) {
                key = 0;
                result++;
            }
            prev = curr;
        }

        return result;
    }

    public static void main(String[] args) {
        int T = _in.nextInt();
        for (int i = 1; i <= T; ++i) {
            System.out.println("Case #" + i + ": " + solve());
        }
    }
}