import java.util.*;
import java.io.*;
import java.util.stream.*;

public class Solution {

    private static final Scanner _in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));

    private static int solve() {
        String S = _in.next();

        List<Integer> kis = new ArrayList<>();
        List<Integer> sis = new ArrayList<>();

        int x, i = 0;
        while(i < S.length()) {
            x = S.indexOf("KICK", i);
            if(x == -1) break;
            kis.add(x);
            i = x + 1;
        }
        
        i = 0;
        while(i < S.length()) {
            x = S.indexOf("START", i);
            if(x == -1) break;
            sis.add(x);
            i = x + 1;
        }
        
        int solution = 0;
        for (final int ki : kis) {
            solution += sis.stream()
                .filter(si -> si > ki)
                .count();
        }

        return solution;
    }

    public static void main(String[] args) {
        int T = _in.nextInt();
        for (int i = 1; i <= T; ++i) {
            System.out.println("Case #" + i + ": " + solve());
        }
    }
}