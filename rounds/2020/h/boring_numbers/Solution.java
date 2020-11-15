import java.util.*;
import java.io.*;

public class Solution {

    private static final Scanner _in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));

    private static long solve() {
        final long L = _in.nextLong();
        final long R = _in.nextLong();
        long count = 0;
        for (long i = L; i <= R; i++) {
            if (isBoringNumber(i))
                count++;
        }
        return count;
    }

    private static boolean isBoringNumber(long x) {
        final char[] s = Long.toString(x).toCharArray();
        for (int i = 0; i < s.length; i++) {
            if((i+1) % 2 != Integer.valueOf(s[i]) % 2)
                return false;
        }
        return true;
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

// public class Solution {

//     private static final Scanner _in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));

//     private static long solve() {
//         long L = _in.nextLong();
//         long R = _in.nextLong();

//         if (L == R) return isBoringNumber(L) ? 1 : 0;

//         for (long i = L; i <= R; i++) {
//             if (isBoringNumber(i)) {
//                 L = i;
//                 break;
//             }
//         }

//         long count = 0;
//         long i = L;
//         while(i <= R) {
//             System.out.print(i + " ");
//             count++;

//             int lastDigit = digitAt(i, -1);
//             if (lastDigit >= 8) {
//                 i += 10 - lastDigit;

//                 boolean haveNext = false;
//                 for (long j = i; j <= R; j++) {
//                     if(isBoringNumber(j)) {
//                         i = j;
//                         haveNext = true;
//                         break;
//                     }
//                 }
//                 if (!haveNext) return count;
//             }
//             else i += 2; 
//         }

//         return count;
//     }

//     private static boolean isBoringNumber(Long x) {
//         final char[] s = x.toString().toCharArray();
//         for (int i = 0; i < s.length; i++) {
//             if((i+1) % 2 != Integer.valueOf(s[i]) % 2)
//                 return false;
//         }
//         return true;
//     }

//     private static int digitAt(Long x, int index) {
//         final String sx = x.toString();
//         return (index >= 0 ?
//             sx.charAt(index) :
//             sx.charAt(sx.length() + index)) - '0';
//     }

//     public static void main(String[] args) {
//         int T = _in.nextInt();
//         for (int i = 1; i <= T; ++i) {
//             System.out.println("Case #" + i + ": " + solve());
//         }
//     }
// }