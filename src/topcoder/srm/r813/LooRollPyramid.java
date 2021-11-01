/**
 * 09/17/21 morning
 * https://arena.topcoder.com/index.html#/u/coding/18868/17157/2
 */
package topcoder.srm.r813;

import java.util.*;
import java.io.*;

public class LooRollPyramid {

    static PrintWriter pw;

    // failed System Test
    public int[] countMissing(int n, int[] a, long[] b) {
        int[] res = new int[n];
        for (int i = 0; i < n; i++) {
            long bottom = a[i], tot = b[i];
            long sum = 0, x = bottom;
            // tr("begin", sum);
            while (true) {
                // tr(sum);
                if (sum == tot) {
                    res[i] = 0;
                    break;
                } else if (sum > tot) {
                    res[i] = (int) (sum - tot);
                    break;
                }
                sum += x;
                x--;
            }
        }
        return res;
    }

    public void run() {
        int Q = 4;
        int[] A = {5, 5, 5, 5};
        long[] B = {15, 10, 5, 0};

        int Q2 = 5;
        int[] A2 = {4, 5, 6, 7, 8};
        long[] B2 = {10, 10, 10, 10, 10};

        int Q3 = 10;
        int[] A3 = {987654321, 987654321, 987654321, 987654321, 987654321, 987654321, 987654321, 987654321, 987654321, 987654321};
        long[] B3 = {5432109876543210L, 5432109876543211L, 5432109876543212L, 5432109876543213L, 5432109876543214L, 5432109876543215L, 5432109876543216L, 5432109876543217L, 5432109876543218L, 5432109876543219L};

        pw.println(Arrays.toString(countMissing(Q, A, B)));
        pw.println(Arrays.toString(countMissing(Q2, A2, B2)));
        pw.println(Arrays.toString(countMissing(Q3, A3, B3)));
    }

    public static void main(String[] args) {
        pw = new PrintWriter(System.out);
        new LooRollPyramid().run();
        pw.close();
    }

    void tr(Object... o) {
        pw.println(Arrays.deepToString(o));
    }
}


