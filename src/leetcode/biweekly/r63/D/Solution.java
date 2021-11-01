/**
 * 10/16/21 morning
 * https://leetcode.com/contest/biweekly-contest-63/problems/kth-smallest-product-of-two-sorted-arrays/
 */
package leetcode.biweekly.r63.D;

import java.util.*;
import java.io.*;

public class Solution {

    static PrintWriter pw;

    public PriorityQueue<List<Long>> res_queue;

    // TLE 62/112
    public long kthSmallestProduct(int[] a, int[] b, long k) {
        res_queue = new PriorityQueue<>((x, y) -> Long.compare(x.get(0) * x.get(1), (y.get(0) * y.get(1))));
        kSmallestPairs(a, b, k);
        long res = 0;
        // tr(res_queue);
        while (k-- > 0) {
            List<Long> cur = res_queue.poll();
            res = cur.get(0) * cur.get(1);
            // tr("cur", cur, "res", res);
        }
        return res;
    }

    public List<List<Long>> kSmallestPairs(int[] nums1, int[] nums2, long k) {
        PriorityQueue<long[]> queue = new PriorityQueue<>((x, y) -> Long.compare(x[0] * x[1], y[0] * y[1]));

        List<List<Long>> result = new ArrayList<>();
        if (nums1.length == 0 || nums2.length == 0 || k == 0) return result;

        for (int i = 0; i < nums1.length; i++) queue.add(new long[]{nums1[i], nums2[0], 0});

        while (!queue.isEmpty()) {
            long[] cur = queue.poll();
            List<Long> tmp = new ArrayList<>();
            tmp.add(cur[0]);
            tmp.add(cur[1]);
            res_queue.add(tmp);
            if (cur[2] == nums2.length - 1) continue;
            queue.offer(new long[]{cur[0], nums2[(int) cur[2] + 1], cur[2] + 1});
        }
        return result;
    }

    public void run() {
        int[] nums1 = {2, 5};
        int[] nums2 = {3, 4};
        long k = 2;
        pw.println(kthSmallestProduct(nums1, nums2, k));
        int[] nums1_2 = {-4, -2, 0, 3};
        int[] nums2_2 = {2, 4};
        long k2 = 6;
        pw.println(kthSmallestProduct(nums1_2, nums2_2, k2));

        int[] nums1_3 = {-2, -1, 0, 1, 2};
        int[] nums2_3 = {-3, -1, 2, 4, 5};
        long k3 = 3;
        pw.println(kthSmallestProduct(nums1_3, nums2_3, k3));

        int[] nums1_debug1 = {-100000, 100000};
        int[] nums2__debug1 = {-100000, 100000};
        long k_debug1 = 1;
        pw.println(kthSmallestProduct(nums1_debug1, nums2__debug1, k_debug1)); // -10000000000

        int[] nums1_debug2 = {-9, -6, -4, -2, -1, 5};
        int[] nums2__debug2 = {-9, -7, -4, -2, 4, 4, 7, 9, 10, 10};
        long k_debug2 = 1;
        pw.println(kthSmallestProduct(nums1_debug2, nums2__debug2, k_debug2)); // -90
    }

    public static void main(String[] args) {
        pw = new PrintWriter(System.out);
        new Solution().run();
        pw.close();
    }

    void tr(Object... o) {
        pw.println(Arrays.deepToString(o));
    }
}

