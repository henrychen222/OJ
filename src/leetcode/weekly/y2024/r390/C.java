/**
 * 03/23/24 evening
 * https://leetcode.com/contest/weekly-contest-390/problems/most-frequent-ids/
 */
package leetcode.weekly.y2024.r390;

import java.util.*;

public class C {

    // Accepted
    public long[] mostFrequentIDs(int[] a, int[] b) {
        TreeSet<Pair> ts = new TreeSet<>();
        TreeMap<Integer, Long> m = new TreeMap<>();
        int n = a.length;
        long[] res = new long[n];
        for (int i = 0; i < n; i++) {
            int x = a[i];
            long occ = b[i];
            long curOcc = m.getOrDefault(x, 0L);

            if (occ > 0) {
                if (curOcc > 0) {
                    ts.remove(new Pair(x, curOcc));
                    ts.add(new Pair(x, curOcc + occ));
                    m.remove(x);
                    m.put(x, curOcc + occ);
                } else {
                    ts.add(new Pair(x, occ));
                    m.put(x, occ);
                }
            } else if (occ < 0) {
                ts.remove(new Pair(x, curOcc));
                m.remove(x);
                if (curOcc + occ > 0) {
                    ts.add(new Pair(x, curOcc + occ));
                    m.put(x, curOcc + occ);
                }
            }
            //tr(x, occ, m);
            res[i] = ts.size() == 0 ? 0 : ts.first().second;
        }
        return res;
    }

    class Pair implements Comparable<Pair> {
        int first;
        long second;

        Pair(int first, long second) {
            this.first = first;
            this.second = second;
        }

        @Override
        public int compareTo(Pair o) {
            if (o.second != second) return Long.compare(o.second, second);
            return Integer.compare(first, o.first);
        }
    }

    public void run() {
        int[] a = {2, 3, 2, 1}, b = {3, 2, -3, 1};
        int[] a2 = {5, 5, 3}, b2 = {2, -2, 1};
        tr(mostFrequentIDs(a, b));
        tr(mostFrequentIDs(a2, b2));
    }

    public static void main(String[] args) {
        new C().run();
    }

    <T> void pr(T t) {
        System.out.println(t);
    }

    void tr(Object... o) {
        System.out.println(Arrays.deepToString(o));
    }
}