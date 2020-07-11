import java.util.*;
import java.io.*;

public class Solution {

    private static final Scanner _in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));

    private static int solve() {
        final int N = _in.nextInt();
        final int P = _in.nextInt();
        int S[] = new int[N];
        for (int i = 0; i < S.length; i++) {
            S[i] = _in.nextInt();
        }
        Arrays.sort(S);

        int result = Integer.MAX_VALUE, temp;
        for (int i = S.length - 1; i >= P-1; i--) {
            temp = 0;
            for (int j = 1; j < P; j++) {
                temp += S[i] - S[i-j];
            }
            result = Math.min(result, temp);
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