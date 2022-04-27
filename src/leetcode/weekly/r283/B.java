/**
 * 03/05/22 evening
 * https://leetcode.com/contest/weekly-contest-283/problems/append-k-integers-with-minimal-sum/
 */
package leetcode.weekly.r283;

import java.util.TreeSet;

class B {
    long sumOfRange (long l, long r) {
        return (l + r) * (r - l + 1) / 2;
    }

    // Accepted
    public long minimalKSum(int[] a, int k) {
        TreeSet<Integer> ts = new TreeSet<>();
        for (int x: a) ts.add(x);
        long res = 0, l = 0, tot = 0;
        for (int r: ts) {
            long cnt = r - l - 1;
            if (cnt > 0) {
                long sum, start, end;
                if (tot + cnt >= k) {
                    long need = k - tot;
                    start = l + 1;
                    end = l + need;
                    sum = sumOfRange(start, end);
                    res += sum;
                    tot += cnt;
                    break;
                } else {
                    start = l + 1;
                    end = r - 1;
                    sum = sumOfRange(start, end);
                    res += sum;
                    tot += cnt;
                }
            }
            l = r;
        }
        if (tot < k) {
            long need = k - tot;
            res += sumOfRange(l + 1, l + need);
        }
        return res;
    }
}