/**
 * 11/07/21 morning
 * https://atcoder.jp/contests/abc226/tasks/abc226_c
 */
package atcoder.abc.r226.C;

import java.util.*;
import java.io.*;

class Main2 {

    static PrintWriter pw;

    // Accepted --- https://atcoder.jp/contests/abc226/submissions/27118358
    // reference: tourist cuiaoxiang
    void bfs(int n, int[] t, int[][] a) {
        boolean[] visit = new boolean[n];
        Queue<Integer> q = new LinkedList<>(Collections.singleton(n - 1));
        visit[n - 1] = true;
        while (!q.isEmpty()) {
            int cur = q.poll();
            // tr(cur);
            for (int child : a[cur]) {
                int idx = child - 1;
                if (!visit[idx]) {
                    visit[idx] = true;
                    q.add(idx);
                }
            }
        }
        long res = 0;
        for (int i = 0; i < n; i++) {
            if (visit[i]) res += t[i];
        }
        pr(res);
    }

    private void run() {
        read_write_file(); // comment this before submission
        FastScanner fs = new FastScanner();
        int n = fs.nextInt();
        int[][] a = new int[n][];
        int[] t = new int[n];
        for (int i = 0; i < n; i++) {
            t[i] = fs.nextInt();
            int k = fs.nextInt();
            a[i] = fs.readArray(k);
        }
        bfs(n, t, a);
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
        new Main2().run();
        pw.close();
    }

    void pr(int num) {
        pw.println(num);
    }

    void pr(long num) {
        pw.println(num);
    }

    void pr(double num) {
        pw.println(num);
    }

    void pr(String s) {
        pw.println(s);
    }

    void pr(char c) {
        pw.println(c);
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