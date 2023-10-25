/**
 * 07/01/23 night
 * https://leetcode.com/contest/weekly-contest-352/problems/continuous-subarrays/
 */
package leetcode.weekly.r352;

import java.util.*;

public class C {

    // Accepted
    public long continuousSubarrays(int[] a) {
        int n = a.length, l = 0;
        TreeMap<Integer, Integer> m = new TreeMap<>();
        long res = 0;
        for (int i = 0; i < n; i++) {
            m.merge(a[i], 1, Integer::sum);
            while (m.lastKey() - m.firstKey() > 2) removeOneOrManyMap(m, a[l++]);
            res += i - l + 1;
        }
        return res;
    }

    <T> void removeOneOrManyMap(TreeMap<T, Integer> m, T x, int... args) {
        int cnt = args.length == 0 ? 1 : args[0], occ = m.get(x);
        if (occ > cnt) {
            m.put(x, occ - cnt);
        } else {
            m.remove(x);
        }
    }

    public void run() {
        int[] a = {5, 4, 2, 4}, a2 = {1, 2, 3};
        pr(continuousSubarrays(a));
        pr(continuousSubarrays(a2));
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