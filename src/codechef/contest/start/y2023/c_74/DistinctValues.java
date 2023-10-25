/**
 * 01/18/23 morning 01/22/23 evening fix
 * https://www.codechef.com/START74C/problems/DIST_VALS
 */
package codechef.contest.start.y2023.c_74;

import java.util.*;
import java.io.*;

class DistinctValues {
    static PrintWriter pw;

    /*
     8 1       8-1=7
     8 1 7     8-7=1
     8 1 7 2   8-7=1
     distance between largest and second largest

     1 7       7-1=6
     1 7 2     7-1=6
     7 2       7-2=5

     6 9 4 2 1   6 has higher 9
     9 4 2 1
     4 2 1
     2 1

     5 2      5-2=3
     5 2 3    5-3=2
     5 2 3 8  8-5=3
     2 3      3-2=1
     2 3 8    8-3=5
     3 8      8-3=5
     ans: [1, 2, 3, 5] = 4
     */
    /*
      reference:
      https://discuss.codechef.com/t/dist-vals-editorial/104930
      https://www.geeksforgeeks.org/count-of-distinct-differences-between-two-maximum-elements-of-every-subarray/
     */
    // Accepted --- https://www.codechef.com/viewsolution/86520031 (0.63s)
    void countDistinctDiffsTwoMaxElementsALLSubArrays1(int n, int[] a) {
        TreeSet<Integer> res = new TreeSet<>();
        Stack<Integer> inc = new Stack<>(); // monotonic stack
        for (int x : a) {
            while (!inc.isEmpty() && inc.peek() <= x) res.add(x - inc.pop());
            if (!inc.isEmpty()) res.add(Math.abs(x - inc.peek()));
            inc.push(x);
        }
        // tr(res);
        pr(res.size());
    }

    // Accepted --- https://www.codechef.com/viewsolution/86520068 (0.57s)
    void countDistinctDiffsTwoMaxElementsALLSubArrays(int n, int[] a) {
        TreeSet<Integer> res = new TreeSet<>();
        Deque<Integer> inc = new ArrayDeque<>(); // monotonic stack
        for (int x : a) {
            while (!inc.isEmpty() && inc.getLast() <= x) res.add(x - inc.pollLast());
            if (!inc.isEmpty()) res.add(Math.abs(x - inc.getLast()));
            inc.add(x);
        }
        pr(res.size());
    }

    // WA
    void solve1(int n, int[] a) {
        TreeMap<Integer, Integer> m = counter(a);
        long res = 0;
        for (int i = 0; i < n; i++) {
            int cur = a[i];
            removeOneOrManyMap(m, cur);
            Integer larger = m.ceilingKey(cur);
            Integer first, second;
            if (larger != null) {
                first = larger;
                second = cur;
                res++;
                // tr("first", first, "second", second, Arrays.copyOfRange(a, i, n), "dis", 1);
            } else {
                first = cur;
                second = m.floorKey(cur); // <= cur;
                if (second != null) {
                    int idx = Arrays.binarySearch(a, i + 1, n, second); // (i+1, n-1) find closest/smallest index >= i
                    int dis = Math.max(1, idx - i);
                    res += dis;
                    // tr("first", first, "second", second, Arrays.copyOfRange(a, i, n), "idx", idx, "dis", dis);
                }
            }
        }
        pr(res);
    }

    <T> void removeOneOrManyMap(Map<T, Integer> m, T x, int... args) {
        int cnt = args.length == 0 ? 1 : args[0], occ = m.get(x);
        if (occ > cnt) {
            m.put(x, occ - cnt);
        } else {
            m.remove(x);
        }
    }

    TreeMap<Integer, Integer> counter(int[] a) {
        TreeMap<Integer, Integer> m = new TreeMap<>();
        for (int x : a) m.put(x, m.getOrDefault(x, 0) + 1);
        return m;
    }

    private void run() {
        read_write_file(); // comment this before submission
        FastScanner fs = new FastScanner();
        int t = fs.nextInt();
        while (t-- > 0) {
            int n = fs.nextInt();
            int[] a = fs.readArray(n);
            // solve(n, a);
            countDistinctDiffsTwoMaxElementsALLSubArrays(n, a);
        }
    }

    private final String INPUT = "input.txt";
    private final String OUTPUT = "output.txt";

    void read_write_file() {
        FileInputStream instream = null;
        PrintStream outstream = null;
        try {
            instream = new FileInputStream(INPUT);
            outstream = new PrintStream(new FileOutputStream(OUTPUT));
            System.setIn(instream);
            System.setOut(outstream);
        } catch (Exception e) {
        }
    }

    public static void main(String[] args) {
        pw = new PrintWriter(System.out);
        new DistinctValues().run();
        pw.close();
    }

    <T> void pr(T t) {
        pw.println(t);
    }

    class FastScanner {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer("");

        String next() {
            while (!st.hasMoreTokens())
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }

        int[] readArray(int n) {
            int[] a = new int[n];
            for (int i = 0; i < n; i++) a[i] = nextInt();
            return a;
        }
    }

    void tr(Object... o) {
        pw.println(Arrays.deepToString(o));
    }
}
