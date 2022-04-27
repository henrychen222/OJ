/**
 * 03/09/22 morning
 * https://www.codechef.com/START29B/problems/PMA
 */
package codechef.contest.start.b_29;

import java.util.*;
import java.io.*;

// Accepted
class PlusleMinunArray {
    static PrintWriter pw;

    /*
    [−3,1,−1,0,−2,2,3]
     3 + (-1) + 1 + (-0) + 2 + (-2) + 3 = 9 - 3
     */
    void solve(int n, int[] a) {
        // test(a);
        for (int i = 0; i < n; i++) {
            if (i % 2 != 0) a[i] = -a[i];
        }
        long sum = 0;
        for (int x : a) sum += x;
//        int[] sufMin = suffixMin(a), sufMax = suffixMax(a);
//        tr("suffixMin", sufMin);
//        tr("suffixMax", sufMax);

        // 正数最小值 和负数最小值交换
        int posMin = Integer.MAX_VALUE, negMin = Integer.MAX_VALUE;
        long posSum = 0, negSum = 0;
//        List<Integer> pos = new ArrayList<>(), neg = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (i % 2 == 0) {
                posMin = Math.min(posMin, a[i]);
//                pos.add(a[i]);
                posSum += a[i];
            } else {
                negMin = Math.min(negMin, a[i]);
//                neg.add(a[i]);
                negSum += a[i];
            }
        }
//        tr(posMin, negMin);
//        tr(pos, posSum, neg, negSum);
        posSum = posSum - posMin + (-negMin);
        negSum = negSum - negMin + (-posMin);
        pr(Math.max(sum, negSum + posSum));
    }

//    int[] suffixMin(int[] a) {
//        int n = a.length, min = Integer.MAX_VALUE;
//        int[] res = new int[n];
//        for (int i = n - 1; i >= 0; i--) {
//            min = Math.min(min, a[i]);
//            res[i] = min;
//        }
//        return res;
//    }
//
//    int[] suffixMax(int[] a) {
//        int n = a.length, max = Integer.MIN_VALUE;
//        int[] res = new int[n];
//        for (int i = n - 1; i >= 0; i--) {
//            max = Math.max(max, a[i]);
//            res[i] = max;
//        }
//        return res;
//    }

    void test(int[] a) {
        int n = a.length;
        long max = Long.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                tr("swap", a[i], a[j]);
                swap(a, i, j);
                tr("after swap", a);
                long sum = 0;
                for (int k = 0; k < n; k++) {
                    if (k % 2 == 0) {
                        sum += a[k];
                    } else {
                        sum += -a[k];
                    }
                }
                tr("each", sum);
                max = Math.max(max, sum);
                swap(a, i, j);
                tr("swap back", a);
            }
        }
        tr(max);
    }

    void swap(int[] a, int i, int j) {
        int tmp = a[i];
        a[i] = a[j];
        a[j] = tmp;
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
        new PlusleMinunArray().run();
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
            for (int i = 0; i < n; i++) a[i] = Math.abs(nextInt());
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

