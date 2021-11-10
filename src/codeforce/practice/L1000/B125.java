/**
 * 11/05/21 evening
 * https://codeforces.com/problemset/problem/125/B
 */
package codeforce.practice.L1000;

import java.util.*;
import java.io.*;

public class B125 {

    static PrintWriter pw;

    // Accepted --- https://codeforces.com/problemset/submission/125/134449662  a little tricky
    private void run() {
        read_write_file(); // comment this before submission
        FastScanner fs = new FastScanner();
        String ss = fs.next();
        List<String> d = new ArrayList<>();
        for (int i = 0; i < ss.length(); i++) {
            char c = ss.charAt(i);
            if (c != '<' && c != '>' && c != '/') {
                d.add(ss.charAt(i - 1) == '/' ? "/" + c : c + "");
            }
        }
        // tr(d);
        int n = d.size();
        String[][] a = new String[n][];
        Set<Integer> used = new HashSet<>();
        for (int i = 0; i < n; i++) {
            String s = d.get(i);
            if (s.charAt(0) == '/') {
                for (int j = i - 1; j >= 0; j--) { // look for matched height
                    if (!used.contains(j) && a[j] != null && a[j][0].equals(s.substring(1))) {
                        a[i] = new String[]{"/" + a[j][0], a[j][1]};
                        used.add(j);
                        break;
                    }
                }
            } else {
                int ignore = 0;
                for (int j = i; j >= 0; j--) {
                    if (d.get(j).charAt(0) == '/') {
                        ignore += 2;
                    }
                }
                int h = i - ignore;
                a[i] = new String[]{s, h + ""};
            }
        }
        // tr(a);
        for (String[] e : a) pr(" ".repeat(Integer.parseInt(e[1]) * 2) + "<" + e[0] + ">");
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
        new B125().run();
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
