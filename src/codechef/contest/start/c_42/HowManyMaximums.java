/**
 * 06/08/22 morning
 * https://www.codechef.com/START42C/problems/HOWMANYMAX
 */
package codechef.contest.start.c_42;

import java.util.*;
import java.io.*;

class HowManyMaximums {
    static PrintWriter pw;

    // Accepted
    void solve(int n, char[] s) {
        List<char[]> d = cutMaxConsecutive(s);
        int res = 0;
        for (char[] e : d) { // find all zeros groups
            if (e[0] == '0') res++;
        }
        if (d.get(0)[0] == '1') res++; // and first one group
        pr(res);
    }

    List<char[]> cutMaxConsecutive(char[] a) {
        List<char[]> d = new ArrayList<>();
        int start = 0, n = a.length;
        for (int i = 0; i + 1 < n; i++) {
            if (a[i + 1] != a[i]) {
                d.add(Arrays.copyOfRange(a, start, i + 1));
                start = i + 1;
            }
        }
        d.add(Arrays.copyOfRange(a, start, n));
        return d;
    }

    // WA
    void solve3(int n, char[] s) {
        if (n - 1 == 1) {
            pr(1);
            return;
        }
        int zero = 0, one = 0;
        for (char c : s) {
            if (c == '0') {
                zero++;
            } else {
                one++;
            }
        }
        int d = Math.abs(zero - one);
        pr(d + 1);
    }


    // WA
    void solve2(int n, char[] s) {
        long res = 0, cur = 0;
        TreeMap<Long, Integer> m = new TreeMap<>();
        for (char c : s) {
            if (c == '0') {
                cur++;
            } else {
                cur--;
            }
            m.put(cur, m.getOrDefault(cur, 0) + 1);
        }
        pr(m.lastEntry().getValue());
    }

    // WA
    void solve1(int n, char[] s) {
        if (n - 1 == 1) {
            pr(1);
            return;
        }
        long res = 0, cur = 0;
        for (int i = 0; i < n - 1; i++) {
            if (i == 0) {
                if (s[i] == '1') res++;
            } else if (i == n - 2) {
                if (s[i] == '0') res++;
            } else {
                if (s[i] == '0' && s[i + 1] == '1') res++;
            }
        }
    }

    private void run() {
        read_write_file(); // comment this before submission
        FastScanner fs = new FastScanner();
        int t = fs.nextInt();
        while (t-- > 0) {
            int n = fs.nextInt();
            char[] s = fs.next().toCharArray();
            solve(n, s);
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
        new HowManyMaximums().run();
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
    }

    void tr(Object... o) {
        pw.println(Arrays.deepToString(o));
    }
}
