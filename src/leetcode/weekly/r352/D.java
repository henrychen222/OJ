/**
 * 07/01/23 night
 * https://leetcode.com/problems/sum-of-imbalance-numbers-of-all-subarrays/
 */
package leetcode.weekly.r352;

import java.util.*;

public class D {
    public int sumImbalanceNumbers(int[] a) {
        int n = a.length;
        int res = 0;
        for (int i = 0; i < n; i++) {
            TreeMap<Integer, Integer> m = new TreeMap<>();
            int cnt = -1;
            for (int j = i; j < n; j++) {
                int v = a[j];
                if (!m.containsKey(v)) {
                    m.merge(v, 1, Integer::sum);
                    cnt++;
                    if (m.containsKey(v - 1)) cnt--;
                    if (m.containsKey(v + 1)) cnt--;
                }
                res += cnt;
            }
        }
        return res;
    }

    public void run() {
        int[] a = {2, 3, 1, 4}, a2 = {1, 3, 3, 3, 5};
        pr(sumImbalanceNumbers(a));
        pr(sumImbalanceNumbers(a2));
    }

    public static void main(String[] args) {
        new D().run();
    }

    <T> void pr(T t) {
        System.out.println(t);
    }

    void tr(Object... o) {
        System.out.println(Arrays.deepToString(o));
    }
}