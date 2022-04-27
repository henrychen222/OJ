/**
 * 04/09/22 evening
 * https://leetcode.com/contest/weekly-contest-288/problems/maximum-product-after-k-increments/
 */
package leetcode.weekly.r288;

import java.util.*;

class C {
    private final int mod = (int) 1e9 + 7;

    // Accepted
    public int maximumProduct(int[] a, int k) {
        TreeMap<Integer, Integer> m = counter(a);
        while (k-- > 0) {
            int min = m.firstKey();
            addOneOrManyMap(m, min + 1);
            removeOneOrManyMap(m, min);
        }
        // tr(m);
        long res = 1;
        for (int x : m.keySet()) {
            res = (res * pow_mod(x, m.get(x))) % mod;
        }
        return (int) res;
    }

    long pow_mod(long a, long b) {
        long r = 1;
        while (b > 0) {
            if (b % 2 == 1) r = r * a % mod;
            b >>= 1;
            a = a * a % mod;
        }
        return r;
    }

    <T> void addOneOrManyMap(TreeMap<T, Integer> m, T x, int... args) {
        int cnt = args.length == 0 ? 1 : args[0];
        m.put(x, m.getOrDefault(x, 0) + cnt);
    }

    <T> void removeOneOrManyMap(TreeMap<T, Integer> m, T x, int... args) {
        int cnt = args.length == 0 ? 1 : args[0], occ = m.get(x);
        if (occ > cnt) {
            m.put(x, occ - cnt);
        } else {
            m.remove(x);
        }
    }

    TreeMap<Integer, Integer> counter(int[] a) {
        TreeMap<Integer, Integer> m = new TreeMap<>();
        for (int x : a) m.put(x, m.getOrDefault(x, 0) + 1);
        return m;
    }

    public void run() {
        int[] a = {0, 4};
        int k = 5;
        int[] a2 = {6, 3, 3, 2};
        int k2 = 2;
        tr(maximumProduct(a, k));
        tr(maximumProduct(a2, k2));
    }

    public static void main(String[] args) {
        new C().run();
    }

    void tr(Object... o) {
        System.out.println(Arrays.deepToString(o));
    }
}