package leetcode.weekly.r316;

class C {
    int[] a, b;
    int n;

    // Accepted
    public long minCost(int[] A, int[] B) {
        a = A;
        b = B;
        n = a.length;
        int low = Integer.MAX_VALUE, high = Integer.MIN_VALUE;
        for (int x : a) {
            low = Math.min(low, x);
            high = Math.max(high, x);
        }
        while ((high - low) > 2) {
            int mid1 = low + (high - low) / 3;
            int mid2 = high - (high - low) / 3;
            long cost1 = computeCost(mid1), cost2 = computeCost(mid2);
            if (cost1 < cost2) {
                high = mid2;
            } else {
                low = mid1;
            }
        }
        long res = Long.MAX_VALUE;
        for (int v = low; v <= high; v++) res = Math.min(res, computeCost(v));
        return res;
    }

    long computeCost(int v) {
        long res = 0;
        for (int i = 0; i < n; i++) res += (long) Math.abs(a[i] - v) * b[i];
        return res;
    }
}