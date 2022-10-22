/**
 * 05/06/22 morning
 * https://codeforces.com/contest/1670/problem/A
 */
package codeforce.cf.div2.r788;

import java.util.*;
import java.io.*;

public class A {
    static PrintWriter pw;

    /*
     71 -35 7 -4 -11 -25

     -71   -7    11  25
     */
    // Accepted --- https://codeforces.com/contest/1670/submission/156126337
    // reference: Heltion
    void solve(int n, Integer[] a) {
//        Integer[] b = Arrays.copyOf(a, n);
//        shuffleSort(b);
//        tr("b", b);
//        Arrays.sort(a, (x, y) -> {
//            if ((x > 0 && y < 0) || (x < 0 && y > 0)) {
//                return x - y;
//            }
//            return 0;
//        });
//        tr("a", a);
//        pr(Arrays.equals(a, b));

        int neg = 0;
        for (int i = 0; i < n; i++) {
            if (a[i] < 0) {
                neg++;
                a[i] *= -1;
            }
        }
        // tr("a", a);
        for (int i = 0; i < neg; i++) a[i] *= -1;
        // tr("a", a);
        pr(isAscending(a) ? "YES" : "NO");
    }

    boolean isAscending(Integer[] a) {
        for (int i = 1; i < a.length; i++) {
            if (a[i - 1] > a[i]) return false;
        }
        return true;
    }

    void shuffleSort(Integer[] a) {
        shuffleArray(a);
        Arrays.sort(a);
    }

    void shuffleArray(Integer[] a) {
        int n = a.length;
        Random rnd = new Random();
        for (int i = 0; i < n; i++) {
            int tmp = a[i];
            int randomPos = i + rnd.nextInt(n - i);
            a[i] = a[randomPos];
            a[randomPos] = tmp;
        }
    }

    private void run() {
        read_write_file(); // comment this before submission
        FastScanner fs = new FastScanner();
        int t = fs.nextInt();
        while (t-- > 0) {
            int n = fs.nextInt();
            Integer[] a = fs.readArray(n);
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
        new A().run();
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

        Integer[] readArray(int n) {
            Integer[] a = new Integer[n];
            for (int i = 0; i < n; i++) a[i] = nextInt();
            return a;
        }
    }

    void tr(Object... o) {
        pw.println(Arrays.deepToString(o));
    }
}