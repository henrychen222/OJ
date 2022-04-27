/**
 * 02/23/22 morning
 * https://www.codechef.com/START27C/problems/NCOPRIMEN
 */
package codechef.contest.start.c_27;

import java.util.*;
import java.io.*;

class NonComPrimeNeighbours {
    static PrintWriter pw;

    // Accepted --- https://www.codechef.com/viewsolution/59029407
    // reference: https://discuss.codechef.com/t/ncoprimen-editorial/99424
    void solve(int n, int[] a) {
        int[] origin = Arrays.copyOf(a, n);
        for (int i = 0; i < n; i++) { // idea: every 3 elements, change 2 of them
            if (i % 3 == 1) { // 1 4 7
                a[i] = a[i - 1] * 2;
            } else if (i % 3 == 2) { // 2 5 8
                if (i + 1 < n) {
                    a[i] = a[i + 1] * 2;
                } else {
                    a[i] = a[i - 1];
                }
            }
        }
        // tr(test(a, origin));
        outputA(a);
    }

    // WA all prime not correct
    void solve1(int n, int[] a) {
        int[] origin = Arrays.copyOf(a, n);
        int odd = 0, even = 0;
        for (int x : a) {
            if (x % 2 == 0) {
                even++;
            } else {
                odd++;
            }
        }
        // tr("even", even, "odd", odd);
        if (even >= odd) {
            for (int i = 0; i < n; i++) {
                if (a[i] % 2 != 0) a[i] = 2;
            }
        } else {
            int i;
            for (i = 1; i + 1 < n; ) {
                int gl = gcd(a[i - 1], a[i]), gr = gcd(a[i], a[i + 1]);
                if (gl == 1) {
                    if (gr == 1) {
                        int min = Math.min(Math.min(a[i], a[i - 1]), a[i + 1]);
                        a[i - 1] = min;
                        a[i] = min;
                        a[i + 1] = min;
                        i += 2;
                    } else {
                        a[i + 1] = a[i];
                        i += 2;
                    }
                } else {
                    if (gr == 1) {
                        a[i - 1] = a[i];
                        i += 3;
                    } else {
                        i++;
                    }
                }
                // tr("i", i);
            }
            if (gcd(a[n - 1], a[n - 2]) == 1) a[n - 1] = a[n - 2];
        }
        tr(test(a, origin));
        outputA(a);
    }

    void outputA(int[] a) {
        for (int e : a) pw.print(e + " ");
        pr("");
    }

    boolean test(int[] a, int[] origin) {
        int n = a.length, cnt = 0, most = n * 2 % 3 == 0 ? n * 2 / 3 : n * 2 / 3 + 1;
        for (int i = 0; i < n; i++) {
            if (a[i] != origin[i]) cnt++;
        }
        tr("most", cnt, most);
        if (cnt > most) return false;
        for (int i = 1; i < n; i++) {
            if (gcd(a[i - 1], a[i]) == 1) return false;
        }
        return true;
    }

    int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
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
        new NonComPrimeNeighbours().run();
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
