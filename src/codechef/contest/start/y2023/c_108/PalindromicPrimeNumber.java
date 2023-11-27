/**
 * 11/15/23 night
 * https://www.codechef.com/START108C/problems/MD_RIEV
 */
package codechef.contest.start.y2023.c_108;

import java.util.*;
import java.io.*;

class PalindromicPrimeNumber {
    static PrintWriter pw;
    TreeSet<Integer> ts, ok;
    long[] even, odd;

    void solve(int n) {
        tr(even.length, odd.length);
        pr(even[n - 1] + " " + odd[n - 1]);
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

    boolean isPalindrome(String s) {
        int n = s.length(), i = 0, j = n - 1;
        while (i < j) {
            if (s.charAt(i++) != s.charAt(j--)) return false;
        }
        return true;
    }

    private void run() {
        read_write_file(); // comment this before submission
        FastScanner fs = new FastScanner();
        int N = (int)1e8;
        ts = sieveEratosthenes(N);
        ok = new TreeSet<>();
        for (int i = 1; i <= N; i++) {
            String s = i + "";
            if (isPalindrome(s) && ts.contains(i)) ok.add(i);
        }
        tr(ok.size(), ok);
        even = new long[ok.size()];
        odd = new long[ok.size()];
        if ((ts.first() + "").length() % 2 == 0) {
            even[0] = 1;
        } else {
            odd[0] = 1;
        }
        int idx = 0;
        for (int x : ok) {
            if (idx >= 1) {
                String s = x + "";
                if (s.length() % 2 == 0) {
                    even[idx] = even[idx - 1] + 1;
                    odd[idx] = odd[idx - 1];
                } else {
                    even[idx] = even[idx - 1];
                    odd[idx] = odd[idx - 1] + 1;
                }
            }
            idx++;
        }
        int t = fs.nextInt();
//        tr(even);
//        tr(odd);
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
        new PalindromicPrimeNumber().run();
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
