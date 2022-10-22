/**
 * 09/07/22 night
 * https://codeforces.com/problemset/problem/61/B
 */
package codeforce.practice.L1300;

import java.util.*;
import java.io.*;

public class B61 {
    static PrintWriter pw;

    // Accepted --- https://codeforces.com/problemset/submission/61/171291184
    private void run() throws IOException {
        read_write_file(); // comment this before submission
        FastScanner fs = new FastScanner();
        String a = parse(fs.nextLine()), b = parse(fs.nextLine()), c = parse(fs.nextLine());
        String[] answer = {a + b + c, a + c + b, b + a + c, b + c + a, c + a + b, c + b + a};
//        tr(answer);
        int n = fs.nextInt();
        while (n-- > 0) {
            String s = parse(fs.nextLine());
            if (Arrays.stream(answer).anyMatch(e -> e.equals(s))) {
                pr("ACC");
            } else {
                pr("WA");
            }
        }
    }

    String parse(String s) {
        String res = "";
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (isSign(c)) continue;
            res += Character.toLowerCase(c);
        }
        return res;
    }

    boolean isSign(char c) {
        return "-;_".indexOf(c) != -1;
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
        new B61().run();
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