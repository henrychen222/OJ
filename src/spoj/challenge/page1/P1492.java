/**
 * 04/19/26 evening
 * https://www.spoj.com/problems/SLEXSORT/
 */
package spoj.challenge.page1;

import java.util.*;
import java.io.*;

class P1492 {
    static PrintWriter pw;

    // Accepted --- https://www.spoj.com/status/SLEXSORT,henrychen222/
    void solve(String a, int n, String[] words) {
//        tr(a, n, words);
        Arrays.sort(words, (x, y) -> {
            int len = Math.min(x.length(), y.length());
            for (int i = 0; i < len; i++) {
                char cx = x.charAt(i), cy = y.charAt(i);
                int orderX = a.indexOf(cx), orderY = a.indexOf(cy);
                if (orderX < orderY) {
                    return -1;
                } else if (orderX > orderY) {
                    return 1;
                }
            }
            if (x.length() < y.length()) {
                return -1;
            } else if (x.length() > y.length()) {
                return 1;
            }
            return 0;
        });
        for(String e: words) pr(e);
        pr("");
    }

    private void run() {
        read_write_file(); // comment this before submission
        FastScanner fs = new FastScanner();
        int t = fs.nextInt();
        while (t-- > 0) {
            String a = fs.next();
            int n = fs.nextInt();
            String[] words = new String[n];
            for (int i = 0; i < n; i++) words[i] = fs.next();
            solve(a, n, words);
        }
    }

    void read_write_file() {
        FileInputStream instream = null;
        PrintStream outstream = null;
        try {
            String INPUT = "input.txt";
            instream = new FileInputStream(INPUT);
            String OUTPUT = "output.txt";
            outstream = new PrintStream(new FileOutputStream(OUTPUT));
            System.setIn(instream);
            System.setOut(outstream);
        } catch (Exception ignore) {
        }
    }

    public static void main(String[] args) {
        pw = new PrintWriter(System.out);
        new P1492().run();
        pw.close();
    }

    <T> void pr(T t) {
        pw.println(t);
    }

    static class FastScanner {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer("");

        String next() {
            while (!st.hasMoreTokens())
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException ignore) {
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