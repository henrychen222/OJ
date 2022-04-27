/**
 * 04/10/22 morning
 * https://atcoder.jp/contests/abc247/tasks/abc247_b
 */
package atcoder.abc.r247.B;

import java.util.*;
import java.io.*;

class Main {
    static PrintWriter pw;

    // Accepted
    private void run() throws IOException {
        read_write_file(); // comment this before submission
        FastScanner fs = new FastScanner();
        int n = fs.nextInt();
        // Map<String, Integer> m = new HashMap<>();
        String[][] d = new String[n][];
        for (int i = 0; i < n; i++) {
            String[] a = fs.readLine().split(" ");
            d[i] = a;
            // for (String s : a) m.put(s, m.getOrDefault(s, 0) + 1);
        }
//        for (String[] a : d) {
//            if (m.get(a[0]) > 1 && m.get(a[1]) > 1) {
//                pr("No");
//                return;
//            }
//        }
        for (int i = 0; i < d.length; i++) {
            String l = d[i][0], r = d[i][1];
            boolean okL = true, okR = true;
            for (int j = 0; j < d.length; j++) {
                if (i == j) continue;
//                tr("L", l, d[j][0], d[j][1]);
//                tr("R", r, d[j][0], d[j][1]);
                if (d[j][0].equals(l) || d[j][1].equals(l)) okL = false;
                if (d[j][0].equals(r) || d[j][1].equals(r)) okR = false;
            }
            // tr(l, okL, r, okR);
            if (!okL && !okR) {
                pr("No");
                return;
            }
        }
        pr("Yes");
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

    public static void main(String[] args) throws IOException {
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

        long nextLong() {
            return Long.parseLong(next());
        }

        double nextDouble() {
            return Double.parseDouble(next());
        }

        String readLine() throws IOException {
            return br.readLine();
        }

    }

    void tr(Object... o) {
        pw.println(Arrays.deepToString(o));
    }
}