/**
 * 11/01/21 morning
 * https://www.nowcoder.com/practice/69ef2267aafd4d52b250a272fd27052c?tpId=37
 */
package nowcoder_huawei.HJ58;

import java.util.*;
import java.io.*;

public class Main {

    static PrintWriter pw;

    // Accepted --- https://www.nowcoder.com/profile/410775365/codeBookDetail?submissionId=122057489
    private void run() {
        read_write_file(); // comment this before submission
        FastScanner fs = new FastScanner();
        try {
            while (true) {
                int n = fs.nextInt(), k = fs.nextInt();
                int[] a = fs.readArray(n);
                Arrays.sort(a);
                for (int i = 0; i < k; i++) pw.print(a[i] + " ");
                pr("");
            }
        } catch (NullPointerException e) {
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

        int nextInt() {
            return Integer.parseInt(next());
        }

        int[] readArray(int n) {
            int[] a = new int[n];
            for (int i = 0; i < n; i++) a[i] = nextInt();
            return a;
        }

        Integer[] readIntegerArray(int n) {
            Integer[] a = new Integer[n];
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