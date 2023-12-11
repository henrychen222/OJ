/*
 * 12/8/23 night
 * https://leetcode.com/contest/weekly-contest-374/problems/count-the-number-of-infection-sequences/
 */
package leetcode.weekly.r374;

import java.util.*;

public class D {

    // reference: https://leetcode.cn/circle/discuss/XH8i1L/
    // Accepted --- uwi 331ms
    public int numberOfSequence(int n, int[] sick) {
        int m = sick.length, mod = 1000000007, healthy = n - m;
        Combinatorics C = new Combinatorics(n + 5, mod);
        long res = 1;
        res = res * C.ifact[sick[0]] % mod;
        res = res * C.ifact[n - 1 - sick[m - 1]] % mod;
        for (int i = 1; i < m; i++) {
            int d = sick[i] - sick[i - 1] - 1;
            if (d > 0) {
                res = res * C.ifact[d] % mod; // 乘分母的逆元
                res = res * pow_mod(2, d - 1, mod) % mod;
            }
        }
        res = res * C.fact[n - m] % mod; // 乘分子
        return (int) res;
    }


    // Accepted kmjp 437ms
    public int numberOfSequence1(int n, int[] sick) {
        int m = sick.length, mod = 1000000007, healthy = n - m;
        Combinatorics C = new Combinatorics(n + 5, mod);
        long res = 1;
        long[] p = buildPowerOf2Array(n, mod);
        res *= C.comb(healthy, sick[0]);
        res %= mod;
        healthy -= sick[0];
        res *= C.comb(healthy, n - 1 - sick[m - 1]);
        res %= mod;
        healthy -= n - 1 - sick[m - 1];
        for (int i = 1; i < m; i++) {
            int d = sick[i] - sick[i - 1] - 1;
            if (d > 0) {
                res *= C.comb(healthy, d);
                res %= mod;
                healthy -= d;
                res *= p[d - 1];
                res %= mod;
            }
        }
        return (int) res;
    }

    long[] buildPowerOf2Array(int n, int mod) {
        long[] power = new long[n];
        power[0] = 1;
        for (int i = 1; i < n; i++) power[i] = power[i - 1] * 2 % mod;
        return power;
    }

    long pow_mod(long a, long b, int mod) {
        long r = 1;
        while (b > 0) {
            if (b % 2 == 1) r = r * a % mod;
            b >>= 1;
            a = a * a % mod;
        }
        return r;
    }

    class Combinatorics {
        long[] fact, ifact, inv;
        int mod;

        Combinatorics(int N, int mod) {
            fact = new long[N];
            ifact = new long[N];
            inv = new long[N];
            this.mod = mod;
            fact[0] = ifact[0] = inv[1] = 1;
            for (int i = 2; i < N; i++) inv[i] = (mod - mod / i) * inv[mod % i] % mod;
            for (int i = 1; i < N; i++) {
                fact[i] = fact[i - 1] * i % mod;
                ifact[i] = ifact[i - 1] * inv[i] % mod;
            }
        }

        long comb(int n, int k) {
            if (n < k || k < 0) return 0;
            return fact[n] * ifact[k] % mod * ifact[n - k] % mod;
        }
    }

    public void run() {
        int n = 5;
        int[] sick = {0, 4};
        int n2 = 4;
        int[] sick2 = {1};
        pr(numberOfSequence(n, sick));
        pr(numberOfSequence(n2, sick2));
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
