/**
 * 05/23/22 afternoon
 * http://poj.org/problem?id=1007
 */
package poj.p1000_1099.p1007;

import java.util.*;
import java.io.*;

class Main {
    static PrintWriter pw;

    // Accepted --- http://poj.org/showsource?solution_id=23517102 1157ms
    // CE --- http://poj.org/showsource?solution_id=23517100 (java 1.5 doesn't have Arrays class)
    private void run() {
        read_write_file(); // comment this before submission
        FastScanner fs = new FastScanner();
        int n = fs.nextInt(), m = fs.nextInt();
        TreeMap<Long, String> ts = new TreeMap<Long, String>();
        Map<String, Integer> ma = new HashMap<String, Integer>(); // handle duplicates
        for (int t = 0; t < m; t++) {
            String s = fs.next();
            if (ma.containsKey(s)) {
                ma.put(s, ma.get(s) + 1);
            } else {
                ma.put(s, 1);
            }
            char[] a = s.toCharArray();
            long cnt = 0;
            for (int i = 0; i < n; i++) {
                for (int j = i + 1; j < n; j++) {
                    if (a[i] > a[j]) cnt++;
                }
            }
            ts.put(cnt, s);
        }
        for (String s : ts.values()) {
            int occ = ma.get(s);
            while (occ-- > 0) pr(s);
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