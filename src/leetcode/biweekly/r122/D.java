/**
 * 01/22/24 afternoon
 * https://leetcode.com/contest/biweekly-contest-122/problems/divide-an-array-into-subarrays-with-minimum-cost-ii/
 */
package leetcode.biweekly.r122;

import java.util.TreeSet;

// Accepted
// reference: skywalkert
public class D {
    public long minimumCost(int[] a, int k, int dist) {
        TreeSet<Pair> L = new TreeSet<>(), R = new TreeSet<>();
        int n = a.length;
        long res = Long.MAX_VALUE, cur = 0;
        for (int i = 1; i < n; i++) {
            L.add(new Pair(a[i], i));
            cur += a[i];
            if (L.size() >= k) {
                Pair last = L.pollLast();
                cur -= last.first;
                R.add(last);
            }
            if (i - dist > 0) {
                res = Math.min(res, cur);
                Pair it = new Pair(a[i - dist], i - dist);
                if (L.contains(it)) {
                    cur -= it.first;
                    L.remove(it);
                    if (!R.isEmpty()) {
                        it = R.pollFirst();
                        cur += it.first;
                        L.add(it);
                    }
                } else {
                    R.remove(it);
                }
            }
        }
        res += a[0];
        return res;
    }

    class Pair implements Comparable<Pair> {
        int first, second;

        Pair(int first, int second) {
            this.first = first;
            this.second = second;
        }

        @Override
        public int compareTo(Pair o) {
            if (first == o.first) return Integer.compare(second, o.second);
            return Integer.compare(first, o.first);
        }
    }
}
