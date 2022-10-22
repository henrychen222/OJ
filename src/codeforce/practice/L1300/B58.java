/**
 * 09/07/22 night
 * https://codeforces.com/problemset/problem/58/B
 *
 * similar problem:
 * https://leetcode.com/problems/largest-divisible-subset/
 */
package codeforce.practice.L1300;

import java.util.*;
import java.io.*;

public class B58 {
    static PrintWriter pw;

    // Accepted --- https://codeforces.com/problemset/submission/58/171292090
    void solve(int N) {
        TreeSet<Integer> ts = findAllFactors(N);
        int n = ts.size();
        int[] a = new int[n];
        int p = 0;
        for (int x : ts) a[p++] = x;
        // tr(n, a);
        outputL(largestDivisibleSubset(a));
    }

    // reference: https://leetcode.com/problems/largest-divisible-subset/
    List<Integer> largestDivisibleSubset(int[] a) {
        int n = a.length;
        if (n == 0) return new ArrayList<>();
        Arrays.sort(a);
        int[] dp = new int[n];
        int[] prev = new int[n];
        Arrays.fill(dp, 1);
        Arrays.fill(prev, -1);
        int maxIdx = 0;
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (a[i] % a[j] == 0) {
                    if (dp[i] < dp[j] + 1) {
                        prev[i] = j;
                        dp[i] = dp[j] + 1;
                    }
                }
            }
            if (dp[i] > dp[maxIdx]) {
                maxIdx = i;
            }
        }
        List<Integer> res = new ArrayList<>();
        int k = maxIdx;
        while (k >= 0) {
            res.add(a[k]);
            k = prev[k];
        }
        return res;
    }

    boolean checkIthBit(int x, int i) {
        return (x & (1 << i)) != 0;
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

    void outputL(List<Integer> l) {
        for (int e : l) pw.print(e + " ");
        pr("");
    }

    private void run() {
        read_write_file(); // comment this before submission
        FastScanner fs = new FastScanner();
        int n = fs.nextInt();
        solve(n);
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
        new B58().run();
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