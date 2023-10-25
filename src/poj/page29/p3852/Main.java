/**
 * 03/31/23 night
 * http://poj.org/problem?id=3852
 */
package poj.page29.p3852;

import java.util.*;
import java.io.*;

class Main {
    static PrintWriter pw;

    // Accepted --- http://poj.org/showsource?solution_id=24070034
    void solve(Set<String> se) {
        int pre = se.size(), res = 0;
        outer:
        while (true) {
            Set<String> next = new HashSet<String>();
            for (String s : se) {
                if (s.length() == 1) break outer;
                next.add(s.substring(1));
            }
            if (next.size() != pre) break;
            res++;
            pre = next.size();
            se = next;
        }
        pr(res);
    }

    private void run() {
        read_write_file(); // comment this before submission
        FastScanner fs = new FastScanner();
        while (true) {
            int n = fs.nextInt();
            if (n == 0) break;
            Set<String> se = new HashSet<String>();
            while (n-- > 0) {
                String s = fs.next();
                se.add(s);
            }
            solve(se);
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
        new Main().run();
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