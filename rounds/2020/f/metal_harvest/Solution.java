import java.util.*;
import java.util.stream.*;
import java.io.*;

class Interval {
    public final int S;
    public final int E;

    public Interval(final int S, final int E) {
        this.S = S;
        this.E = E;
    }
}

public class Solution {

    private static final Scanner _in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));

    private static int solve() {
        final int N = _in.nextInt();
        final int K = _in.nextInt();
        
        final Interval[] I = IntStream.range(0, N)
            .boxed()
            .map(i -> new Interval(_in.nextInt(), _in.nextInt()))
            .sorted((i, j) -> i.S - j.S)
            .toArray(Interval[]::new);

        int deployments = 0;
        int t = 1;
        for (int i = 0; i < N; i++) {
            t = Math.max(t, I[i].S);
            if(t > I[i].E) continue;

            final int newDeployments = (int)Math.ceil((I[i].E - t)/(double)K);

            deployments += newDeployments;
            t += newDeployments * K;
        }

        return deployments;
    }

    public static void main(String[] args) {
        final int T = _in.nextInt();
        for (int i = 1; i <= T; ++i) {
            System.out.println("Case #" + i + ": " + solve());
        }
    }
}