/**
 * 11/12/21 afternoon
 * https://www.luogu.com.cn/problem/P1102
 */
package luogu.level2_orange.P1102;

import java.util.*;
import java.io.*;

class Main {
    static PrintWriter pw;

    // Accepted --- https://www.luogu.com.cn/record/62391724
    private void run() {
        read_write_file(); // comment this before submission
        FastScanner fs = new FastScanner();
        int n = fs.nextInt(), C = fs.nextInt();
        int[] a = fs.readArray(n);
        Map<Integer, Integer> m = new HashMap<>();
        for (int x : a) m.put(x, m.getOrDefault(x, 0) + 1);
        long res = 0;
        for (int A : m.keySet()) {
            int freqA = m.get(A);
            int B = A - C;
            if (m.containsKey(B)) {
                if (A == B) {
                    if (freqA >= 2) {
                        res += combination(freqA, 2);
                    }
                } else {
                    int freqB = m.get(B);
                    res += (long) freqA * freqB;
                }
            }
        }
        pr(res);
    }

    long combination(long m, long n) {
        return factorial(m, n) / factorial(n, n);
    }

    long factorial(long m, long n) {
        long res = 1, cnt = 0;
        for (long x = m; x > 0; x--) {
            if (cnt == n) break;
            res *= x;
            cnt++;
        }
        return res;
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