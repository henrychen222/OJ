/**
 * 07/06/22 morning
 * https://www.codechef.com/START46C/problems/SRTARR
 */
package codechef.contest.start.c_46;

import java.util.*;
import java.io.*;

class SortString {
    static PrintWriter pw;

    // Accepted
    void solve(int n, char[] s) {
        List<char[]> d = cutMaxConsecutive(s);
        char[] t = new char[d.size()];
        for (int i = 0; i < d.size(); i++) t[i] = d.get(i)[0];

        TreeSet<Integer> zero = new TreeSet<>(), one = new TreeSet<>();
        for (int i = 0; i < d.size(); i++) {
            if (t[i] == '0') {
                zero.add(i);
            } else {
                one.add(i);
            }
        }
        // tr(s, t, one, zero);
        if (zero.size() == 0 || one.size() == 0) {
            pr(0);
            return;
        }
        long res = 0;
        for (int i1 : one) {
            if (zero.higher(i1) != null) res++;
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
        new SortString().run();
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
