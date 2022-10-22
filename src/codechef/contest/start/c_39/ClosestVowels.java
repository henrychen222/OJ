/**
 * 05/18/22 morning
 * https://www.codechef.com/START39C/problems/CLOSEVOWEL
 */
package codechef.contest.start.c_39;

import java.util.*;
import java.io.*;

// Accepted
class ClosestVowels {
    static PrintWriter pw;
    final int mod = (int) 1e9 + 7;
    String t = "aeiou";

    void solve(int n, char[] s) {
        long res = 1;
        for (char c : s) {
            if (!isVowel(c)) {
                int ways = ways(c);
                if (ways > 0) res = res * ways % mod;
            }
        }
        pr(res % mod);
    }

    boolean isVowel(char c) {
        return t.indexOf(c) != -1;
    }

    int ways(char c) {
        int[] f = new int[5];
        for (int i = 0; i < 5; i++) f[i] = Math.abs(t.charAt(i) - c);
        Arrays.sort(f);
        int cnt = 0;
        for (int occ : f) {
            if (occ == f[0]) cnt++;
        }
        // tr(c, f, cnt);
        return cnt;
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
        new ClosestVowels().run();
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
