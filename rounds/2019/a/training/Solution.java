import java.util.*;
import java.io.*;

public class Solution {

    private static final Scanner _in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));

    private static int solve() {
        final int N = _in.nextInt();
        final int P = _in.nextInt();
        Integer S[] = new Integer[N];
        for (int i = 0; i < S.length; i++) {
            S[i] = _in.nextInt();
        }
        
        Arrays.sort(S,Collections.reverseOrder());

        int result = Integer.MAX_VALUE;
        int prefix = 0;
        for (int i = 0; i < S.length; i++) {
            if (i < P) {
                prefix += S[i];
            } else {
                prefix += S[i] - S[i-P];
            }

            if (i < P-1) continue;

            result = Math.min(result, P * S[i-P+1] - prefix);
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