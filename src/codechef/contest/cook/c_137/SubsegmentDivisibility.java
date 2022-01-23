/**
 * 01/23/21 morning
 * https://www.codechef.com/COOK137C/problems/SEGDIV
 */
package codechef.contest.cook.c_137;

import java.util.*;
import java.io.*;

class SubsegmentDivisibility {
    static PrintWriter pw;
    TreeSet<Integer> ts;

    /*
      reference: https://www.codechef.com/viewsolution/56962353
      // Accepted --- https://www.codechef.com/viewsolution/56982967
     */
    void solve(int n) {
        int[] a = new int[n];
        int x = 2;
        for (int i = 0; i < n; i++) {
            if (i % 2 == 0) {
                x++;
            } else {
                x += 3;
            }
            a[i] = x;
        }
        // tr(a, test(a));
        outputA(a);
    }

    // WA
    void solve1(int n) {
        int[] a = new int[n];
        int even = 2;
        a[0] = 1;
        long sum = a[0];
        for (int i = 0; i < n; i++) {
            int len = i + 1;
            if (len < 2) continue;
            if (len % 2 == 0) {
                a[i] = even;
                even += 2;
            } else {
                a[i] = ts.pollLast();
            }
            sum += a[i];
            if (sum % len == 0) a[i]--;
        }
        // tr(a, test(a));
        outputA(a);
    }

    void outputA(int[] a) {
        for (int e : a) pw.print(e + " ");
        pr("");
    }

    boolean test(int[] a) {
        int n = a.length;
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                int len = j - i + 1;
                if (len < 2) continue;
                int[] sub = Arrays.copyOfRange(a, i, j + 1);
                long sum = 0;
                for (int x : sub) sum += x;
                tr(sub, len, sum);
                if (sum % len == 0) return false;
            }
        }
        return true;
    }

    TreeSet<Integer> sieveEratosthenes(int n) {
        boolean[] prime = new boolean[n + 1];
        TreeSet<Integer> se = new TreeSet<>();
        Arrays.fill(prime, true);
        for (int p = 2; p * p <= n; p++) {
            if (!prime[p]) continue;
            for (int i = p * p; i <= n; i += p) prime[i] = false;
        }
        for (int i = 2; i <= n; i++) {
            if (prime[i]) se.add(i);
        }
        return se;
    }

    private void run() {
        read_write_file(); // comment this before submission
        FastScanner fs = new FastScanner();
        ts = sieveEratosthenes(100000);
        // tr(ts.size(), ts);
        int t = fs.nextInt();
        while (t-- > 0) {
            int n = fs.nextInt();
            solve(n);
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
        new SubsegmentDivisibility().run();
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

