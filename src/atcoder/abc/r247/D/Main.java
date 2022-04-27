/**
 * 04/10/22 morning
 * https://atcoder.jp/contests/abc247/tasks/abc247_d
 */
package atcoder.abc.r247.D;

import java.util.*;
import java.io.*;

class Main {
    static PrintWriter pw;

    // Accepted
    void solve(int[][] d) {
        Deque<int[]> q = new ArrayDeque<>();
        for (int[] a : d) {
            int n = a.length;
            if (n == 3) {
                q.add(new int[]{a[1], a[2]});
            } else {
                int k = a[1];
                long sum = 0;
                while (true) {
                    if (k - q.peekFirst()[1] < 0) {
                        int[] cur = q.poll();
                        int x = cur[0], occ = cur[1];
                        int rest = occ - k;
                        sum += (long) x * k;
                        q.addFirst(new int[]{x, rest});
                        break;
                    } else if (k - q.peekFirst()[1] == 0) {
                        int[] cur = q.poll();
                        int x = cur[0], occ = cur[1];
                        k -= occ;
                        sum += (long) x * occ;
                        break;
                    } else {
                        int[] cur = q.poll();
                        int x = cur[0], occ = cur[1];
                        k -= occ;
                        sum += (long) x * occ;
                    }
                }
                pr(sum);
            }
        }
    }

    private void run() throws IOException {
        read_write_file(); // comment this before submission
        FastScanner fs = new FastScanner();
        int q = fs.nextInt();
        int[][] d = new int[q][];
        for (int i = 0; i < q; i++) {
            String[] a = fs.readLine().split(" ");
            int[] e = new int[a.length];
            for (int j = 0; j < a.length; j++) e[j] = Integer.parseInt(a[j]);
            d[i] = e;
        }
        solve(d);
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

    public static void main(String[] args) throws IOException {
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

        long nextLong() {
            return Long.parseLong(next());
        }

        double nextDouble() {
            return Double.parseDouble(next());
        }

        String readLine() throws IOException {
            return br.readLine();
        }
    }

    void tr(Object... o) {
        pw.println(Arrays.deepToString(o));
    }
}