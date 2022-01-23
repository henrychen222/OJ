/**
 * 01/17/22 morning
 * https://www.codechef.com/problems/TWTCLOSE
 */
package codechef.practice.beginner;

import java.util.*;
import java.io.*;

class ClosingTweets {
    static PrintWriter pw;

    // Accepted --- https://www.codechef.com/viewsolution/56556652
    // fix other's code https://discuss.codechef.com/t/wa-in-twtclose/21227
    private void run() throws IOException {
        read_write_file(); // comment this before submission
        FastScanner fs = new FastScanner();
        int n = fs.nextInt(), k = fs.nextInt(), sum = 0;
        int[] a = new int[n];
        while (k-- > 0) {
            String[] s = fs.readLine().split(" ");
            if (s[0].equals("CLICK")) {
                int idx = Integer.parseInt(s[1]) - 1;
                if (a[idx] == 0) {
                    a[idx] = 1;
                    sum++;
                } else {
                    a[idx] = 0;
                    sum--;
                }
            } else {
                Arrays.fill(a, 0);
                sum = 0;
            }
            pr(sum);
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

    public static void main(String[] args) throws IOException {
        pw = new PrintWriter(System.out);
        new ClosingTweets().run();
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

        char nextChar() {
            return next().charAt(0);
        }

        String readLine() throws IOException {
            return br.readLine();
        }
    }

    void tr(Object... o) {
        pw.println(Arrays.deepToString(o));
    }
}
