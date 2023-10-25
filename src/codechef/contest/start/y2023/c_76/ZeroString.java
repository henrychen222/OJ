/**
 * 02/01/23 morning
 * https://www.codechef.com/START76C/problems/ZEROSTRING
 */
package codechef.contest.start.y2023.c_76;

import java.util.*;
import java.io.*;

class ZeroString {
    static PrintWriter pw;

    // Accepted --- https://www.codechef.com/viewsolution/87797086
    // reference: https://www.codechef.com/viewsolution/87616147
    void solve(int n, char[] s) {
        int zero = 0, one = 0;
        for (char c : s) {
            if (c == '0') {
                zero++;
            } else {
                one++;
            }
        }
        int deleteAllOne = one, deleteAllZeroAndFlip = zero + 1;
        pr(Math.min(deleteAllOne, deleteAllZeroAndFlip));
    }

    ////////////////////////////////////////////////////
    void solve1(int n, char[] s) {
        List<char[]> d = cutMaxConsecutive(s);
        int res = 0;
        for (char[] e : d) {
            if (e[0] == '1') res++; // flip is for all string not part
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
        new ZeroString().run();
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
