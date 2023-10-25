/**
 * 05/12/23 morning
 * https://codeforces.com/contest/1832/problem/B
 */
package codeforce.ecf.r148;

import java.util.*;
import java.io.*;

public class B {
    static PrintWriter pw;

    // Accepted --- https://codeforces.com/contest/1832/submission/205652462 05/12/23 afternoon
    // reference: https://www.youtube.com/watch?v=UnnP7HAuqxw
    void slidingWindowGreedyAssumeReplace(int n, int k, int[] a) {
        shuffleSort(a);
        a = reverseA(a);
        int l = 0, r = n - 2 * k; // [l, r]: 长度固定滑动窗口，假设一开始都是最小的被删除，窗口中都是最大
        long curSum = 0; // window sum
        for (int i = 0; i < r; i++) curSum += a[i];
        long res = curSum;
        // tr(a, Arrays.copyOfRange(a, l, r), curSum);
        while (r < n - 1) { // 右滑  然后每次删除一个最大 复原原来2个最小
            curSum += a[r];
            curSum += a[r + 1];
            r += 2;
            curSum -= a[l++];
            res = Math.max(res, curSum);
        }
        pr(res);
    }

    int[] reverseA(int[] a) {
        int n = a.length;
        int[] b = new int[n];
        for (int i = 0; i < n; i++) b[i] = a[n - i - 1];
        return b;
    }

    // Accepted
    // reference: tourist
    void solve2(int n, int k, int[] a) {
        shuffleSort(a);
        long[] prefixSum = new long[n + 1];
        for (int i = 1; i <= n; i++) {
            prefixSum[i] = prefixSum[i - 1] + a[i - 1];
        }
        // tr(prefixSum);
        long ans = 0;
        for (int i = 0; i <= k; i++) {
            ans = Math.max(ans, prefixSum[n - k + i] - prefixSum[2 * i]);
            // ans = Math.max(ans, prefixSum[n] - prefixSum[k-i] + prefixSum[2*i]);
        }
        pr(ans);
    }

    // WA
    void solve1(int n, int k, int[] a) {
        long remove = 0, sum = 0;
        for (int x : a) sum += x;
        shuffleSort(a);
        // tr(a);
        for (int i = 0, j = n - 1, t = 0; t < k; t++) {
            long two = (long) a[i] + a[i + 1];
            if (a[j] <= two) {
                // tr("max", a[j]);
                remove += a[j];
                j--;
            } else {
                // tr("min", a[i], a[i + 1]);
                remove += two;
                i += 2;
            }
        }
        long res1 = sum - remove, remove2 = 0, remove3 = 0;
        // tr(remove, k, sum);
        for (int i = 0, t = 0; t < k; i += 2, t++) {
            remove2 += a[i];
            remove2 += a[i + 1];
        }
        for (int i = 0; i < k; i++) remove3 += a[n - i - 1];
        long res2 = sum - remove2, res3 = sum - remove3;
        // tr(res1, res2, res3);
        pr(Math.max(Math.max(res1, res2), res3));
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

    private void run() {
        read_write_file(); // comment this before submission
        FastScanner fs = new FastScanner();
        int t = fs.nextInt();
        while (t-- > 0) {
            int n = fs.nextInt(), k = fs.nextInt();
            int[] a = fs.readArray(n);
            // solve(n, k, a);
            slidingWindowGreedyAssumeReplace(n, k, a);
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
        new B().run();
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
