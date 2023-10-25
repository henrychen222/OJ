/**
 * 03/18/23 morning
 * https://leetcode.com/contest/biweekly-contest-100/problems/find-score-of-an-array-after-marking-all-elements/
 */
package leetcode.biweekly.r100;

import java.util.*;

// Accepted (work another 51 min after contest)
public class C {
    public long findScore(int[] a) {
        int n = a.length;
        long res = 0;
        TreeMap<Integer, TreeSet<Integer>> m = counter_value_in_indexA_in(a);
        while (m.size() > 0) {
            int x = m.firstKey();
            res += x;
            TreeSet<Integer> ia = m.get(x), iar = null, ial = null;
            int pickIdx = ia.first();
            Integer l = null, r = null;
            if (pickIdx + 1 < n) {
                r = a[pickIdx + 1];
                iar = m.get(r);
            }
            if (pickIdx - 1 >= 0) {
                l = a[pickIdx - 1];
                ial = m.get(l);
            }
            // tr(x, l, r, m);
            if (l != null) op(m, ial, pickIdx - 1, l);
            if (r != null) op(m, iar, pickIdx + 1, r);
            op(m, ia, pickIdx, x);
            // tr("remove", m);
        }
        return res;
    }

    void op(TreeMap<Integer, TreeSet<Integer>> m, TreeSet<Integer> ia, int idx, int v) {
        if (ia != null) {
            ia.remove(idx);
            if (ia.size() > 0) {
                m.put(v, ia);
            } else {
                m.remove(v);
            }
        }
    }

    TreeMap<Integer, TreeSet<Integer>> counter_value_in_indexA_in(int[] a) {
        TreeMap<Integer, TreeSet<Integer>> m = new TreeMap<>();
        for (int i = 0; i < a.length; i++) {
            if (!m.containsKey(a[i])) m.put(a[i], new TreeSet<>());
            m.get(a[i]).add(i);
        }
        return m;
    }

    public void run() {
        int[] a = {2, 1, 3, 4, 5, 2};
        int[] a2 = {2, 3, 5, 1, 3, 2};
        int[] a_debug_debug1_short = {730, 519, 1623, 1579, 1735, 1015, 1579, 1003};
        int[] a_debug1 = {730, 1721, 1993, 1532, 962, 519, 1365, 1307, 1992, 1623, 1579, 1735, 1015, 1579, 1003, 1277, 1255, 1254, 810, 1767, 206, 1837, 920, 1203, 1876, 521, 625, 483, 572, 922, 1936, 1014, 1835, 694, 19, 209, 1438, 127, 1716, 1272, 444, 1739, 148, 1580, 802, 1093, 1543, 452, 257, 103, 877, 749, 1418, 348, 1555, 1552, 818, 555, 1628, 547, 553, 1742, 1062, 1199, 1987, 818, 491, 1211};
        pr(findScore(a));
        pr(findScore(a2));
        pr(findScore(a_debug_debug1_short)); // 4116
        pr(findScore(a_debug1)); // 23202
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

/*
[730,519,1623,1579,1735,1015,1579,1003]

[1579,1735,1015,1579,1003]   519
[1579,1735,1015]   519 + 1003
[1579]   519 + 1003 + 1015
[]   519 + 1003 + 1015 + 1579
 */
