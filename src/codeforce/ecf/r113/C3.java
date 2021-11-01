// 09/09/21 night
// reference: https://codeforces.com/contest/1569/submission/128327132 (KeyurJain)
package codeforce.ecf.r113;

import java.util.*;
import java.io.*;

public class C3 {

    static PrintWriter pw;

    private final int MOD = 998244353;
    private final int N = (int) (2e5 + 5);
    private final int[] factorial = new int[N];
    private final int[] ifactorial = new int[N];

    void comb_init() {
        if (factorial[0] == 0) {
            factorial[0] = 1;
            ifactorial[0] = 1;
            for (int i = 1; i < N; i++) {
                factorial[i] = multiplySafe(factorial[i - 1], i);
                ifactorial[i] = modPow(factorial[i], MOD - 2);
            }
        }
    }

    // Accepted --- https://codeforces.com/contest/1569/submission/128397516
    // read : https://codeforces.com/blog/entry/7108 (Arrays sort to avoid TLE)
    void solve(int n, int[] a) {
        // Arrays.sort(a); // TLE
        Sorting.shuffleAndSort(a);
        if (a[n - 1] > a[n - 2] + 1) {
            pr(0);
        } else if (a[n - 1] == a[n - 2]) {
            pr(factorial[n]);
        } else {
            int totalPermutations = factorial[n];
            int invalidPermutations = 0;
            int countPenultimate = 0;
            for (int i : a) {
                if (i == a[n - 1] - 1) {
                    countPenultimate++;
                }
            }
            for (int i = countPenultimate; i < n; i++) {
                int right = n - i - 1;
                int left = i;
                if (left < countPenultimate) continue;
                int elementsRemaining = n - 1 - countPenultimate;
                int elementsNeeded = left - countPenultimate;
                int leftPermutations = multiplySafe(nCr(elementsRemaining, elementsNeeded), factorial[left]);
                int rightPermuations = factorial[right];
                invalidPermutations = (int) ((1L * invalidPermutations + multiplySafe(leftPermutations, rightPermuations)) % MOD);
            }
            int validPermutations = (totalPermutations - invalidPermutations) % MOD;
            if (validPermutations < 0) validPermutations += MOD;
            pr(validPermutations);
        }
    }

    int nCr(int n, int r) {
        int numerator = factorial[n];
        int denominator = multiplySafe(ifactorial[n - r], ifactorial[r]);
        return multiplySafe(numerator, denominator);
    }

    private int modPow(int a, int b) {
        int ans = 1;
        while (b > 0) {
            if ((b & 1) == 1) {
                ans = multiplySafe(ans, a);
            }
            a = multiplySafe(a, a);
            b >>= 1;
        }
        return ans;
    }

    int multiplySafe(int a, int b) {
        return (int) ((1L * a * b) % MOD);
    }

    static class Sorting {
        public static void shuffleAndSort(int[] arr) {
            shuffleArray(arr);
            Arrays.sort(arr);
        }

        public static void shuffleArray(int[] arr) {
            int n = arr.length;
            Random rnd = new Random();
            for (int i = 0; i < n; ++i) {
                int tmp = arr[i];
                int randomPos = i + rnd.nextInt(n - i);
                arr[i] = arr[randomPos];
                arr[randomPos] = tmp;
            }
        }
    }


    void run() {
        read_write_file(); // comment this before submission
        FastScanner fs = new FastScanner();
        int t = fs.nextInt();
        while (t-- > 0) {
            comb_init();
            int n = fs.nextInt();
            int[] a = fs.readArray(n);
            solve(n, a);
        }
    }

    private final String INPUT = "input.txt";
    private final String OUTPUT = "output.txt";

    void read_write_file() {
        FileInputStream instream = null;
        PrintStream outstream = null;
        try {
            instream = new FileInputStream(INPUT);
            outstream = new PrintStream(new FileOutputStream(OUTPUT));
            System.setIn(instream);
            System.setOut(outstream);
        } catch (Exception e) {
        }
    }

    public static void main(String[] args) {
        pw = new PrintWriter(System.out);
        new C3().run();
        pw.close();
    }

    void pr(int num) {
        pw.println(num);
    }

    void pr(long num) {
        pw.println(num);
    }

    void pr(double num) {
        pw.println(num);
    }

    void pr(String s) {
        pw.println(s);
    }

    void pr(char c) {
        pw.println(c);
    }

    class FastScanner {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer("");

        String next() {
            while (!st.hasMoreTokens())
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }

        int[] readArray(int n) {
            int[] a = new int[n];
            for (int i = 0; i < n; i++)
                a[i] = nextInt();
            return a;
        }

        Integer[] readIntegerArray(int n) {
            Integer[] a = new Integer[n];
            for (int i = 0; i < n; i++)
                a[i] = nextInt();
            return a;
        }

        long nextLong() {
            return Long.parseLong(next());
        }

        double nextDouble() {
            return Double.parseDouble(next());
        }
    }

    void tr(Object... o) {
        pw.println(Arrays.deepToString(o));
    }
}