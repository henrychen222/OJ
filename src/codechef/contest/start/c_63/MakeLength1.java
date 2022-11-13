/**
 * 11/02/22 morning
 * https://www.codechef.com/START63C/problems/MAKELENGTH1
 */
package codechef.contest.start.c_63;

import java.util.*;
import java.io.*;

// Accepted
class MakeLength1 {
    static PrintWriter pw;

    /*
    4
    9
    000111000
    7
    0111100
    1
    1
    0
    0
     */
    void solve(int n, char[] s) {
        if (n == 1) {
            pr("YES");
            return;
        }
        List<char[]> d = cutMaxConsecutive(s);
        // debugArrayInList(d);
        for (int i = 0; i < d.size(); i++) {
            char[] e = d.get(i);
            if (e[0] == '1') {
                if (e.length % 2 != 0) {
                    pr("NO");
                    return;
                } else {
                    d.set(i, new char[]{'0'});
                }
            }
        }
        // debugArrayInList(d);
        pr("YES");
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

    void debugArrayInList(List<char[]> l) {
        char[][] res = new char[l.size()][];
        for (int i = 0; i < l.size(); i++) res[i] = l.get(i);
        tr("out", res);
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
        new MakeLength1().run();
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
