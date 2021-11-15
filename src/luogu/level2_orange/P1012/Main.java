/**
 * 11/11/21 afternoon
 * https://www.luogu.com.cn/problem/P1012
 */
package luogu.level2_orange.P1012;

import java.util.*;
import java.io.*;

class Main {

    static PrintWriter pw;

    // Accepted --- https://www.luogu.com.cn/record/62308038
    private void run() throws IOException {
        read_write_file(); // comment this before submission
        FastScanner fs = new FastScanner();
        int N = fs.nextInt();
        String[] a = fs.nextLine().split(" ");
        Arrays.sort(a, (x, y) -> {
            long sxy = Long.parseLong(x + y), syx = Long.parseLong(y + x);
            return sxy > syx ? -1 : 1;
        });
        // tr(a);
        String res = "";
        for (String e : a) res += e;
        pr(res);
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

        String nextLine() throws IOException {
            return br.readLine();
        }

        int nextInt() {
            return Integer.parseInt(next());
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