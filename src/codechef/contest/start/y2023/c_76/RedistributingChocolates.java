/**
 * 02/01/23 morning
 * https://www.codechef.com/START76C/problems/REDSTRBTN
 */
package codechef.contest.start.y2023.c_76;

import java.util.*;
import java.io.*;

class RedistributingChocolates {
    static PrintWriter pw;

    // Accepted
    void solve(int[] a) {
        if (allDiff(a)) {
            pr("YES");
            return;
        }
        int one = Arrays.stream(a).filter(x -> x == 1).sum();
        Arrays.sort(a);
        if (one == 0) {
            pr("YES");
        } else if (one == 1) {
            pr(a[1] == 2 && a[2] == 2 ? "NO" : "YES");
        } else if (one == 2) {
            pr(a[2] <= 3 ? "NO" : "YES");
        } else if (one == 3) {
            pr("NO");
        }
    }

    boolean allDiff(int[] a) {
        Set<Integer> se = new HashSet<>();
        for (int x : a) se.add(x);
        return se.size() == a.length;
    }

    private void run() {
        read_write_file(); // comment this before submission
        FastScanner fs = new FastScanner();
        int t = fs.nextInt();
        while (t-- > 0) {
            int[] a = fs.readArray(3);
            solve(a);
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
        new RedistributingChocolates().run();
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
