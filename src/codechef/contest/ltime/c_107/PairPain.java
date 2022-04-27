/**
 * 04/16/22 noon
 * https://www.codechef.com/LTIME107C/problems/PAIRPAIN
 */
package codechef.contest.ltime.c_107;

import java.util.*;
import java.io.*;

class PairPain {
    static PrintWriter pw;

    /*
       WA:
       https://www.codechef.com/viewsolution/63075977
       https://www.codechef.com/viewsolution/63080520

       (After Contest fixed)
       WA:
       https://www.codechef.com/viewsolution/63092063
       https://www.codechef.com/viewsolution/63093253
       https://www.codechef.com/viewsolution/63093511
       https://www.codechef.com/viewsolution/63093952
       Accepted
       https://www.codechef.com/viewsolution/63094437
       https://www.codechef.com/viewsolution/63094786 (combination to calculate 22)
     */
    void solve(int n, int[] a) {
        TreeMap<Integer, ArrayList<Integer>> m = counter_value_in_indexA_in(a);
        List<Integer> one = m.getOrDefault(1, new ArrayList<>()), two = m.getOrDefault(2, new ArrayList<>());
        long res = 0;
        for (int i : one) {
            int c1Any = n - i - 1;
            res += c1Any;
            // tr("one", i, a, c1Any);
        }
        for (int i = 0; i < n; i++) {
            if (a[i] != 1) {
                int j = upper_bound(one, i);
                int cAny1 = one.size() - j;
                res += cAny1;
            }
        }
        // tr(res, two.size());
        if (two.size() > 1) {
            long c22 = combination(two.size(), 2);
            // long twoCat = factorial(two.size() - 1, two.size() - 1);
            // tr("c22", c22);
            res += c22;
        }
//        for (int i : two) {
//            int j2 = upper_bound(two, i);
//            int c22 = two.size() - j2;
//            res += c22;
//        }
        pr(res);
        // tr(test(n, a));
    }

    int upper_bound(List<Integer> a, int x) {
        int low = 0, high = a.size();
        while (low < high) {
            int mid = low + high >>> 1;
            if (x < a.get(mid)) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }

    long combination(long m, long n) {
        return factorial(m, n) / factorial(n, n);
    }

    long factorial(long m, long n) { // example: A(5, 3) = 5 * 4 * 3 = 60
        long res = 1;
        for (long i = m, cnt = 0; i > 0 && cnt < n; i--, cnt++) res *= i;
        return res;
    }

    TreeMap<Integer, ArrayList<Integer>> counter_value_in_indexA_in(int[] a) {
        TreeMap<Integer, ArrayList<Integer>> m = new TreeMap<>();
        for (int i = 0; i < a.length; i++) {
            if (!m.containsKey(a[i])) m.put(a[i], new ArrayList<>());
            m.get(a[i]).add(i);
        }
        return m;
    }

    int test(int n, int[] a) {
        int res = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (a[i] + a[j] >= a[i] * a[j]) res++;
            }
        }
        return res;
    }

    private void run() {
        read_write_file(); // comment this before submission
        FastScanner fs = new FastScanner();
        int t = fs.nextInt();
        while (t-- > 0) {
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
        new PairPain().run();
        pw.close();
    }

    <T> void pr(T t) {
        pw.println(t);
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
            for (int i = 0; i < n; i++) a[i] = nextInt();
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
