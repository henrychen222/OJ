/**
 * 11/26/22 morning
 * https://www.acwing.com/problem/content/4726/
 */
package acwing.r77.B;

import java.util.*;
import java.io.*;

class Main {
    static PrintWriter pw;

    // Accepted
    void solve(int n) {
        if (n == 1) {
            pr('a');
            return;
        }
        char[] a = {'a', 'b', 'c', 'd', 'e'};
        int l = 1;
        for (int i = 0; 1 << i < n; i++) {
            int v = 1 << i, line = v * 5;
            int r = l + line - 1;
            int[] range = new int[]{l, r};
            tr(v, range);
            if (n >= l && n <= r) {
                double d = (double) (n - l + 1) / v;
                int idx = (int) Math.ceil(d);
                // tr(d, idx);
                pr(a[idx - 1]);
                break;
            }
            l = r + 1;
        }
    }

    /*
     1 a b c d e
     2 aa bb cc dd ee
     4 aaaa bbbb cccc dddd eeee
     8 aaaaaaaa bbbbbbbb cccccccc dddddddd eeeeeeee
     */
    void test(int n) {
        Deque<Character> q = new ArrayDeque<>();
        q.add('a');
        q.add('b');
        q.add('c');
        q.add('d');
        q.add('e');
        int cnt = 0;
        while (true) {
            char x = q.poll();
            tr(x);
            cnt++;
            if (cnt == n) {
                pr(x);
                break;
            }
            q.add(x);
            q.add(x);
        }
    }

    private void run() {
        read_write_file(); // comment this before submission
        FastScanner fs = new FastScanner();
        int n = fs.nextInt();
        solve(n);
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
        new Main().run();
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