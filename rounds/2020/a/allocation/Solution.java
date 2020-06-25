import java.util.*;
import java.io.*;

public class Solution {

    private static final Scanner _in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));

    private static int solve() {
        int N = _in.nextInt();
        int B = _in.nextInt();

        int[] A = new int[N];
        for (int i = 0; i < N; i++)
            A[i] = _in.nextInt();
    
        Arrays.sort(A);

        int sum = 0;
        int result = 0;
        for (int i = 0; i < N; i++)
        {
            if (sum + A[i] > B) continue;
    
            sum += A[i];
            ++result;
        }
        
        return result;
    }

    public static void main(String[] args) {
        int t = _in.nextInt();
        for (int i = 1; i <= t; ++i) {
            System.out.println("Case #" + i + ": " + solve());
        }
    }
}