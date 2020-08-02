import java.util.*;
import java.util.stream.*;
import java.io.*;

class Tuple<T1,T2> {
    public final T1 v1; 
    public final T2 v2; 

    public Tuple(T1 v1, T2 v2) {
        this.v1 = v1;
        this.v2 = v2;
    }

    @Override
    public int hashCode() {
        return Arrays.hashCode(new long[] { v1.hashCode(), v2.hashCode() });
    }
}

public class Solution {

    private static final Scanner _in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));

    private static int beauty(final Map<Integer, Integer> tree, final int id, final int step, final Set<Integer> colored) {
        List<Tuple<Integer,Integer>> queue = new ArrayList<Tuple<Integer, Integer>>() {{
            add(new Tuple<>(id, 0));
        }};

        while(!queue.isEmpty()) {
            Tuple<Integer,Integer> current = queue.remove(0);
            if (current.v2 % step == 0)
                colored.add(current.v1);
            Integer parent = tree.getOrDefault(current.v1, null);
            if (parent != null) {
                queue.add(new Tuple<>(parent, current.v2+1));
            }
        }

        return colored.size();
    }

    private static double solve() {
        final int X = 10000000;
        final int N = _in.nextInt();
        final int A = _in.nextInt();
        final int B = _in.nextInt();
        final Map<Integer, Integer> tree = new HashMap<>();
        int parent, current;
        for (int i = 0; i < N-1; i++) {
            parent = _in.nextInt();
            current = i+2;
            tree.put(current, parent);
        }

        Random r = new Random();
        List<Integer> beauties = new ArrayList<>(N*X);
        Set<Integer> colored = new HashSet<>();
        for (int i = 0; i < N*X; i++) {
            beauty(tree, r.nextInt(N)+1, A, colored);
            beauty(tree, r.nextInt(N)+1, B, colored);

            beauties.add(colored.size());
            colored.clear();
        }

        return beauties.stream().mapToInt(Integer::valueOf).average().getAsDouble();
    }

    public static void main(String[] args) {
        int T = _in.nextInt();
        for (int i = 1; i <= T; ++i) {
            System.out.println("Case #" + i + ": " + solve());
        }
    }
}