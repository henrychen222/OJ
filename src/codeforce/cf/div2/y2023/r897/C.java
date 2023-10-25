/**
 * 09/11/23 evening
 * https://codeforces.com/contest/1867/problem/C
 */
package codeforce.cf.div2.y2023.r897;

import java.util.*;
import java.io.*;

public class C {
    static PrintWriter pw;

    // TLE https://codeforces.com/contest/1867/submission/223258137
    // reference: kmjp
    private void run() {
        read_write_file(); // comment this before submission
        FastScanner fs = new FastScanner();
        int t = fs.nextInt();
        while (t-- > 0) {
            int n = fs.nextInt();
            int[] a = fs.readArray(n);
            TreeSet<Integer> A = new TreeSet<>();
            for (int x : a) A.add(x);
            int i;
            for (i = 0; i <= n; i++) {
                if (!A.contains(i)) {
                    break;
                }
            }
            int cur = i;
            while (true) {
                while (cur >= 0 && A.contains(cur)) cur--;
                pr(cur);
                A.add(cur);
                int y = fs.nextInt();
                if (y < 0) break;
                A.remove(y);
            }
        }
    }

    // TLE --- https://codeforces.com/contest/1867/submission/223256346
    // reference: secondThread
    private void run2() {
        read_write_file(); // comment this before submission
        FastScanner fs = new FastScanner();
        int t = fs.nextInt();
        while (t-- > 0) {
            int n = fs.nextInt();
            int[] a = fs.readArray(n);
            shuffleSort(a);
            int mex = 0;
            for (int x : a) {
                if (x == mex) mex++;
            }
            while (true) {
                pr(mex);
                int y = fs.nextInt();
                if (y == -1) {
                    break;
                } else if (y == -2) {
                    return;
                } else {
                    mex = y;
                }
            }
        }
    }

    void shuffleSort(int[] a) {
        shuffleArray(a);
        Arrays.sort(a);
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

    private void run1() {
        read_write_file(); // comment this before submission
        FastScanner fs = new FastScanner();
        int t = fs.nextInt();
        while (t-- > 0) {
            int n = fs.nextInt();
            int[] a = fs.readArray(n);
            TreeSet<Integer> ts = new TreeSet<>();
            for (int x : a) ts.add(x);
            // tr(n, a, ts);
            while (true) {
                int y = fs.nextInt();
                // tr(ts);
                if (y == -1) {
                    pr(0);
                    break;
                } else {
                    int v = ts.last() + 1;
                    pr(v);
                    ts.add(v);
                    ts.remove(y);
                }
            }
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

    <T> void pr(T t) {
        pw.println(t);
        pw.flush();
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