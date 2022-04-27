/**
 * 02/23/22 morning
 * https://www.codechef.com/START27C/problems/BINSTRING
 */
package codechef.contest.start.c_27;

import java.util.*;
import java.io.*;

class DistinctBinaryStrings {
    static PrintWriter pw;

    // Accepted
    void solve(int n, String s) {
        int consecutive = 0, remove = 0;
        char pre = s.charAt(0);
        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            if (c == pre) {
                consecutive++;
            } else {
                // tr("add", remove, consecutive);
                remove += consecutive;
                consecutive = 0;
                pre ^= 1;
            }
        }
        // tr(remove, consecutive);
        remove += consecutive;
        // tr("remove", remove);
        pr(s.length() - (remove - 1));
    }

    // TLE
    void solve1(int n, String s) {
        Set<String> se = new HashSet<>();
        for (int i = 0; i < n; i++) {
            String sub = s.substring(0, i) + s.substring(i + 1);
            se.add(sub);
        }
        pr(se.size());
    }

    private void run() {
        read_write_file(); // comment this before submission
        FastScanner fs = new FastScanner();
        int t = fs.nextInt();
        while (t-- > 0) {
            int n = fs.nextInt();
            String s = fs.next();
            solve(n, s);
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
        new DistinctBinaryStrings().run();
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

        long nextLong() {
            return Long.parseLong(next());
        }

        double nextDouble() {
            return Double.parseDouble(next());
        }
    }

    void tr(Object... o) {
        pw.println(Arrays.deepToString(o));
    }
}
