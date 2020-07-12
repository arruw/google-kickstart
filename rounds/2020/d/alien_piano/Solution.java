import java.util.*;
import java.io.*;
import java.util.stream.*;

public class Solution {

    private static final Scanner _in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));

    private int K;
    private int[] A;

    private int countErrors(char from, char to, int i, int errors) {
        if (from == '/') return 0;

        boolean isError = !(
            (A[i] >  A[i-1] && to > from ) ||
            (A[i] <  A[i-1] && to < from ) ||
            (A[i] == A[i-1] && to == from)
        );

        return isError ? errors+1 : errors;
    }

    private int helper(int i, char parent, int errors) {
        if(i == K) return errors;

        final HashMap<Character, Integer> newErrors = new HashMap<Character, Integer>() {{
            put('A', countErrors(parent, 'A', i, errors));
            put('B', countErrors(parent, 'B', i, errors));
            put('C', countErrors(parent, 'C', i, errors));
            put('D', countErrors(parent, 'D', i, errors));
        }};

        
        int minError = Collections.min(newErrors.values());

        return Stream.of(
            minError == newErrors.get('A') ? helper(i+1, 'A', newErrors.get('A')) : Integer.MAX_VALUE,
            minError == newErrors.get('B') ? helper(i+1, 'B', newErrors.get('B')) : Integer.MAX_VALUE,
            minError == newErrors.get('C') ? helper(i+1, 'C', newErrors.get('C')) : Integer.MAX_VALUE,
            minError == newErrors.get('D') ? helper(i+1, 'D', newErrors.get('D')) : Integer.MAX_VALUE
        ).min(Integer::compareTo).get();
    }

    private int solve() {
        K = _in.nextInt();
        A = new int[K];
        for (int i = 0; i < K; i++) {
            A[i] = _in.nextInt();
        }

        return helper(0, '/', 0);
    }

    public static void main(String[] args) {
        int T = _in.nextInt();
        for (int i = 1; i <= T; ++i) {
            Solution s = new Solution();
            System.out.println("Case #" + i + ": " + s.solve());
        }
    }
}