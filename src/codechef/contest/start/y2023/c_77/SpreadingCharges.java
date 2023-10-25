/**
 * 02/15/23 morning
 * https://www.codechef.com/START77C/problems/CHRGES
 */
package codechef.contest.start.y2023.c_77;

import java.util.*;
import java.io.*;

class SpreadingCharges {
    static PrintWriter pw;

    /*
     1
     4
     -00+
     */
    // Accepted
    void DominoMock(int n, char[] s) {
        boolean allZero = true;
        for (char c : s) {
            if (c != '0') allZero = false;
        }
        if (allZero) {
            pr(n);
            return;
        }
        List<char[]> d = cutMaxConsecutive(s);
        int res = 0;
        for (int i = 1; i < d.size() - 1; i++) {
            char[] l = d.get(i - 1), m = d.get(i), r = d.get(i + 1);
            if (m[0] == '0') {
                boolean oppo = false;
                if (l[0] == '+' && r[0] == '-') oppo = true;
                if (l[0] == '-' && r[0] == '+') oppo = true;
                if (oppo && m.length % 2 != 0) res++; // 0's length should be odd then can keep 1 finally
            }
        }
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

    private void run() {
        read_write_file(); // comment this before submission
        FastScanner fs = new FastScanner();
        int t = fs.nextInt();
        while (t-- > 0) {
            int n = fs.nextInt();
            char[] s = fs.next().toCharArray();
            DominoMock(n, s);
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
        new SpreadingCharges().run();
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
