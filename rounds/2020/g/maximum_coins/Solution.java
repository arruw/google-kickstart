import java.util.*;
import java.io.*;

public class Solution {

    private static final Scanner _in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));

    private static long solve() {
        final int N = _in.nextInt();

        final long[][] C = new long[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                C[i][j] = _in.nextInt();
            }
        }

        long max = 0;
        for (int i = 1; i < N; i++) {
            for (int j = 1; j < N; j++) {
                C[i][j] += C[i-1][j-1];
                if(i == N-1 || j == N-1)
                    max = Math.max(max, C[i][j]);
            }
        }

        max = Math.max(max, C[0][N-1]);
        max = Math.max(max, C[N-1][0]);

        return max;
    }

    public static void main(String[] args) {
        int T = _in.nextInt();
        for (int i = 1; i <= T; ++i) {
            System.out.println("Case #" + i + ": " + solve());
        }
    }
}

// import java.util.*;
// import java.io.*;
// import java.math.BigInteger;

// public class Solution {

//     private static final Scanner _in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));

//     private static BigInteger solve() {
//         final int N = _in.nextInt();

//         final BigInteger[] C = new BigInteger[N+N-1];
//         for (int i = 0; i < N; i++) {
//             for (int j = 0; j < N; j++) {
//                 final BigInteger bi = BigInteger.valueOf(_in.nextInt());
//                 if (i == 0) {
//                     C[j] = bi;
//                     continue;
//                 } else if (j == 0) {
//                     C[N+i-1] = bi;
//                     continue;
//                 }

//                 final int p = i <= j ? j - i : N+j-1;
//                 C[p] = C[p].add(bi);
//             }
//         }

//         return Arrays.stream(C).max(BigInteger::compareTo).orElse(BigInteger.ZERO);
//     }

//     public static void main(String[] args) {
//         int T = _in.nextInt();
//         for (int i = 1; i <= T; ++i) {
//             System.out.println("Case #" + i + ": " + solve());
//         }
//     }
// }