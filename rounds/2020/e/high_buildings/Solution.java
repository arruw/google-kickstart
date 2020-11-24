import java.util.*;
import java.io.*;
import java.util.stream.*;

public class Solution {

    private static final Scanner _in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));

    private static String solve() {
        final int N = _in.nextInt();
        final int A = _in.nextInt();
        final int B = _in.nextInt();
        final int C = _in.nextInt();

        final List<Integer> x = new LinkedList<Integer>();

        // common
        for (int i = 0; i < C; i++) {
            x.add(N);
        }

        // a - common 
        for (int i = 0; i < A - C; i++) {
            x.add(0, N-i-1);
        }

        // b - common
        for (int i = 0; i < B - C; i++) {
            x.add(x.size(), N-i-1);
        }

        // hidden
        if(x.size() < N) {
            final int hi;
            if(C > 1) {
                hi = A-C+1;
            } else if (A > C) {
                hi = A-C;
            } else if (B > C) {
                hi = x.size()-B+C;
            } else {
                return "IMPOSSIBLE";
            }
            for (int i = x.size(); i < N; i++) {
                x.add(hi, 1);
            }
        }
        
        if (x.size() != N)
            return "IMPOSSIBLE";
        
        return x.stream()
            .map(String::valueOf)
            .collect(Collectors.joining(" "));
    }

    public static void main(String[] args) throws Exception {
        int T = _in.nextInt();
        for (int i = 1; i <= T; ++i) {
            System.out.println("Case #" + i + ": " + solve());
        }
    }
}