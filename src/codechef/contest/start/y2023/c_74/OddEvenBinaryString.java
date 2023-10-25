/**
 * 01/18/23 morning
 * https://www.codechef.com/START74C/problems/ODDEVENBS
 */
package codechef.contest.start.y2023.c_74;

import java.util.*;
import java.io.*;

class OddEvenBinaryString {
    static PrintWriter pw;

    // Accepted
    void solve(int n, int[] b) {
        List<Integer> a = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (b[i] == 1) {
                a.add(i + 1);
            }
        }
        int rest = n - a.size();
        // tr(a, rest);
        if (rest < 0 || rest % 2 != 0) {
            pr("NO");
        } else {
            pr("YES");
        }
    }

    int[] parityEncoding(int[] a) {
        int n = a.length;
        Map<Integer, Integer> m = counter(a);
        int[] res = new int[n];
        for (int i = 0; i < n; i++) {
            if (m.getOrDefault(i + 1, 0) % 2 != 0) {
                res[i] = 1;
            }
        }
        return res;
    }

    Map<Integer, Integer> counter(int[] a) {
        Map<Integer, Integer> m = new HashMap<>();
        for (int x : a) m.put(x, m.getOrDefault(x, 0) + 1);
        return m;
    }

    private void run() {
        read_write_file(); // comment this before submission
        FastScanner fs = new FastScanner();
        int t = fs.nextInt();
        while (t-- > 0) {
            int n = fs.nextInt();
            int[] b = fs.readArray(n);
            solve(n, b);
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
        new OddEvenBinaryString().run();
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
