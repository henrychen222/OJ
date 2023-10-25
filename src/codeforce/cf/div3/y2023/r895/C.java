/**
 * 09/07/23 evening
 * https://codeforces.com/contest/1872/problem/C
 */
package codeforce.cf.div3.y2023.r895;

import java.util.*;
import java.io.*;

public class C {
    static PrintWriter pw;

    // Accepted
    void solve(int l, int r) {
        // tr(l, r);
        int cnt = r - l + 1;
        if (cnt >= 5) {
            int[] d = l % 2 == 0 ? new int[]{l, l + 2} : new int[]{l + 1, l + 3};
            for (int x : d) {
                int h = x / 2;
                if (h > 0 && h % 2 == 0) {
                    pr(h + " " + h); // must have answers
                    return;
                }
            }
        } else {
            for (int v = l; v <= r; v++) {
                TreeSet<Integer> factors = findAllFactors(v);
                // tr(v, factors);
                for (int x : factors) {
                    int y = v - x;
                    if (x > 0 && y > 0 && gcd(x, y) != 1) {
                        pr(x + " " + y);
                        return;
                    }
                }
            }
            pr(-1);
        }
    }

    TreeSet<Integer> findAllFactors(int n) {
        TreeSet<Integer> res = new TreeSet<>();
        for (int i = 1; i * i <= n; i++) {
            if (n % i == 0) {
                if (i == n / i) {
                    res.add(i);
                } else {
                    res.add(i);
                    res.add(n / i);
                }
            }
        }
        return res;
    }

    int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }

    private void run() {
        read_write_file(); // comment this before submission
        FastScanner fs = new FastScanner();
        int t = fs.nextInt();
        while (t-- > 0) {
            int[] a = fs.readArray(2);
            solve(a[0], a[1]);
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