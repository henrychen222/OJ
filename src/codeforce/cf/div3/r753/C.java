/**
 * 11/02/21 morning
 * https://codeforces.com/contest/1607/problem/C
 */

package codeforce.cf.div3.r753;

import java.util.*;
import java.io.*;

public class C {

    static PrintWriter pw;

    /*
       [1, 2, 7, 10]
           [1, 6, 9]
              [5, 8]
                 [3]
     */
    // Accepted --- https://codeforces.com/contest/1607/submission/134140757
    // reference: morozov312
    void solve(int n, int[] a) {
        shuffleArray(a);
        Arrays.sort(a);
        // tr(a);
        int max = a[0];
        for (int i = 1; i < n; i++) {
            max = Math.max(max, a[i] - a[i - 1]);
        }
        pr(max);
    }

    void shuffleArray(int[] a) {
        int n = a.length;
        Random rnd = new Random();
        for (int i = 0; i < n; i++) {
            int tmp = a[i];
            int randomPos = i + rnd.nextInt(n - i);
            a[i] = a[randomPos];
            a[randomPos] = tmp;
        }
    }

    // TLE
    void solve1(int n, int[] a) {
        TreeMap<Integer, Integer> m = new TreeMap<>();
        for (int x : a) m.put(x, m.getOrDefault(x, 0) + 1);
        int res = Integer.MIN_VALUE;
        while (m.size() > 0) {
            int curMin = m.firstKey();
            // tr(m, curMin);
            res = Math.max(res, curMin);
            int curMinOcc = m.get(curMin);
            if (curMinOcc == 1) {
                m.remove(curMin);
            } else {
                m.put(curMin, curMinOcc - 1);
            }
            TreeMap<Integer, Integer> tmp = new TreeMap<>();
            for (int x : m.keySet()) {
                int occ = m.get(x);
                int newVal = x - curMin;
                tmp.put(newVal, tmp.getOrDefault(newVal, 0) + occ);
            }
            m = tmp;
        }
        pr(res);
    }

    private void run() {
        read_write_file(); // comment this before submission
        FastScanner fs = new FastScanner();
        int t = fs.nextInt();
        while (t-- > 0) {
            int n = fs.nextInt();
            int[] a = fs.readArray(n);
            solve(n, a);
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
        new C().run();
        pw.close();
    }

    void pr(int num) {
        pw.println(num);
    }

    void pr(long num) {
        pw.println(num);
    }

    void pr(double num) {
        pw.println(num);
    }

    void pr(String s) {
        pw.println(s);
    }

    void pr(char c) {
        pw.println(c);
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

        List<Integer> readList(int n) {
            List<Integer> l = new ArrayList<>();
            for (int i = 0; i < n; i++) l.add(nextInt());
            return l;
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