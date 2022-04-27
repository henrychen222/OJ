/**
 * 04/13/22 morning
 * https://www.codechef.com/START34C/problems/AVGARR
 */
package codechef.contest.start.c_34;

import java.util.*;
import java.io.*;

class AverageArray {
    static PrintWriter pw;

    // Accepted
    void solve(int n, int x) {
        int len = n % 2 == 0 ? n : n - 1;
        TreeSet<Integer> se = new TreeSet<>();
        for (int dis = 1; dis <= len / 2; dis++) {
            se.add(x + dis);
            se.add(x - dis);
        }
        int sum = 0;
        for (int e : se) sum += e;
        int last = n * x - sum;
        if (n % 2 == 1) se.add(last);
        // tr(test(se, n, x), se, last);
        outputSet(se);
    }

    boolean test(TreeSet<Integer> se, int n, int x) {
        int sum = 0;
        for (int e : se) sum += e;
        return sum == n * x;
    }
//    void solve(int n, int x) {
//        int sum = n * x;
//        if (sum == 0) {
//            return;
//        }
//        // int[] res = sum > 0 ? find(n, sum) : find(n, -sum);
//        int[] d = find(n-1, Math.abs(sum));
//        int[] res = new int[n];
//        if (valid(d)) {
//            if (sum > 0) {
//                tr(">0", d);
//                int p = 0;
//                for (int v = d[0]; v <= d[1]; v++) res[p++] = v;
//                res[n-1] = d[2];
//            }
//        }
//        outputA(res);
//    }

    int[] find(int len, long sum) {
        int[] res = {2000, 2000, 2000};
        for (int l = 1; l < sum; l++) {
            int r = l + len;
            long rangeSum = sumOfRange(l, r);
            long last = sum - rangeSum;
            tr(l, r, "last", last);
            if (ok((int) last)) {
                res[0] = l;
                res[1] = r;
                res[2] = (int) last;
                break;
            }
        }
        return res;
    }

    long sumOfRange(long l, long r) {
        return (l + r) * (r - l + 1) / 2;
    }

    boolean ok(int x) {
        return x >= -1000 && x <= 1000;
    }

    boolean valid(int[] res) {
        return ok(res[0]) && ok(res[1]);
    }

    void outputSet(TreeSet<Integer> se) {
        for (int e : se) pw.print(e + " ");
        pr("");
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
        new AverageArray().run();
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
