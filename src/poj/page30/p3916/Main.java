/**
 * 03/31/23 night
 * http://poj.org/problem?id=3916
 */
package poj.page30.p3916;

import java.util.*;
import java.io.*;

class Main {
    static PrintWriter pw;

    // Accepted --- http://poj.org/showsource?solution_id=24069882
    private void run() throws IOException {
        read_write_file(); // comment this before submission
        FastScanner fs = new FastScanner();
        while (true) {
            String[] A = fs.nextLine().split(" ");
            if (Arrays.equals(A, new String[]{"0"})) break;
            int n = Integer.parseInt(A[0]);
            int[] a = map(copyOfRange(A, 1, A.length));
            List<Integer> res = new ArrayList<Integer>();
            int pre = -1;
            for (int i = 0; i < n; i++) {
                if (a[i] != pre) res.add(a[i]);
                pre = a[i];
            }
            outputL(res);
        }
    }

    void outputL(List<Integer> l) {
        for (int e : l) pw.print(e + " ");
        pw.print("$" + " ");
        pr("");
    }

    String[] copyOfRange(String[] a, int l, int r) {
        String[] res = new String[r - l];
        int p = 0;
        for (int i = l; i < r; i++) res[p++] = a[i];
        return res;
    }

    int[] map(String[] a) {
        int n = a.length;
        int[] res = new int[n];
        for (int i = 0; i < n; i++) res[i] = Integer.parseInt(a[i]);
        return res;
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

        String nextLine() throws IOException {
            return br.readLine();
        }
    }

    void tr(Object... o) {
        pw.println(Arrays.deepToString(o));
    }
}