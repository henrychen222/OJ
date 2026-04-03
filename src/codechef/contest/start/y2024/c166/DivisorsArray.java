/**
 * 12/25/24 morning
 * https://www.codechef.com/START166C/problems/DIVISORS2
 */
package codechef.contest.start.y2024.c166;

import java.util.*;
import java.io.*;

class DivisorsArray {
    static PrintWriter pw;

    void solve(int n, int m, int[] a) {
        List<Integer> primes = sieve(m);
        Map<Integer, Integer> mFactorCount = factorialPrimeFactors(m, primes);
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            res.add(computeDivisors(a[i], mFactorCount, primes));
        }
        outputL(res);
    }

    void outputL(List<Integer> l) {
        for (int e : l) pw.print(e + " ");
        pr("");
    }

    static final int MOD = 1000000007;

    // Sieve of Eratosthenes to find all primes up to M
    public static List<Integer> sieve(int M) {
        boolean[] isPrime = new boolean[M + 1];
        Arrays.fill(isPrime, true);
        isPrime[0] = isPrime[1] = false;

        for (int i = 2; i * i <= M; i++) {
            if (isPrime[i]) {
                for (int j = i * i; j <= M; j += i) {
                    isPrime[j] = false;
                }
            }
        }

        List<Integer> primes = new ArrayList<>();
        for (int i = 2; i <= M; i++) {
            if (isPrime[i]) {
                primes.add(i);
            }
        }
        return primes;
    }

    // Compute the prime factorization of M!
    public static Map<Integer, Integer> factorialPrimeFactors(int M, List<Integer> primes) {
        Map<Integer, Integer> factorCount = new HashMap<>();
        for (int prime : primes) {
            int exp = 0, power = prime;
            while (power <= M) {
                exp += M / power;
                if (power > M / prime) break; // Avoid overflow
                power *= prime;
            }
            factorCount.put(prime, exp);
        }
        return factorCount;
    }

    // Compute the number of divisors for B[i] mod MOD
    public static int computeDivisors(long value, Map<Integer, Integer> mFactorCount, List<Integer> primes) {
        Map<Integer, Integer> factorCount = new HashMap<>(mFactorCount);

        // Factorize value
        for (int prime : primes) {
            if ((long) prime * prime > value) break;
            while (value % prime == 0) {
                factorCount.put(prime, factorCount.getOrDefault(prime, 0) + 1);
                value /= prime;
            }
        }
        if (value > 1) {
            factorCount.put((int) value, factorCount.getOrDefault((int) value, 0) + 1);
        }

        // Compute F(B[i])
        long divisors = 1;
        for (int exp : factorCount.values()) {
            divisors = divisors * (exp + 1) % MOD;
        }
        return (int) divisors;
    }

    private void run() {
        read_write_file();
        FastScanner fs = new FastScanner();
        int n = fs.nextInt(), m = fs.nextInt();
        int[] a = fs.readArray(n);
        solve(n, m, a);
    }

    void read_write_file() {
        FileInputStream instream = null;
        PrintStream outstream = null;
        try {
            String INPUT = "input.txt";
            instream = new FileInputStream(INPUT);
            String OUTPUT = "output.txt";
            outstream = new PrintStream(new FileOutputStream(OUTPUT));
            System.setIn(instream);
            System.setOut(outstream);
        } catch (Exception ignored) {
        }
    }

    public static void main(String[] args) {
        pw = new PrintWriter(System.out);
        new DivisorsArray().run();
        pw.close();
    }

    <T> void pr(T t) {
        pw.println(t);
    }

    static class FastScanner {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer("");

        String next() {
            while (!st.hasMoreTokens())
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException ignored) {
                }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }

        int[] readArray(int n) {
            int[] a = new int[n];
            for (int i = 0; i < n; i++) a[i] = nextInt();
            return a;
        }
    }

    void tr(Object... o) {
        pw.println(Arrays.deepToString(o));
    }
}

