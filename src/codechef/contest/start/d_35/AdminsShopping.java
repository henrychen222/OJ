/**
 * 04/20/22 morning
 * https://www.codechef.com/START35D/problems/ADMINSHOP
 */
package codechef.contest.start.d_35;

import java.util.*;
import java.io.*;

// Accepted
class AdminsShopping {
    static PrintWriter pw;
    int[] a;
    int n, x, min;
    long sum;

    /*
     depends on min
     1    2      3        4
     1   2 3    4 5 6   7 8 9 10
     7   8 10   1 2 9   4 5 6 3
     6   4 5    7 8 3       1 2
     2   1 6     10
     3   7 9
     4
     5
     6
     8
     9
     10
     */
    void solve(int n, int x, int[] a) {
        int min = Integer.MAX_VALUE;
        for (int e : a) {
            min = Math.min(min, e);
            sum += e;
        }
        long each = (long) Math.ceil((double) x / min);
        long res = Math.max(n, each);
        // long high = (long) n * x;
        // long res = BinarySearch(0, high);
        pr(res);
    }

//    long BinarySearch(long low, long high) {
//        while (low <= high) {
//            long mid = low + (high - low) / 2;
//            if (possible(mid)) {
//                low = mid + 1;
//            } else {
//                high = mid - 1;
//            }
//        }
//        return low;
//    }
//
//    boolean possible(long h) {
//        long needHour = (long) min * x;
//        return needHour <= h;
//    }

    private void run() {
        read_write_file(); // comment this before submission
        FastScanner fs = new FastScanner();
        int t = fs.nextInt();
        while (t-- > 0) {
            n = fs.nextInt();
            x = fs.nextInt();
            a = fs.readArray(n);
            solve(n, x, a);
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
        new AdminsShopping().run();
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
