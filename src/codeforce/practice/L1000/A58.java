/**
 * 10/31/21 night
 * https://codeforces.com/problemset/problem/58/A
 */
package codeforce.practice.L1000;

import java.util.*;
import java.io.*;

public class A58 {

    static PrintWriter pw;

    // Accepted --- https://codeforces.com/problemset/submission/58/133874015
    private void run() {
        read_write_file(); // comment this before submission
        FastScanner fs = new FastScanner();
        char[] a = fs.next().toCharArray();
        Map<Character, ArrayList<Integer>> m = new HashMap<>();
        for (int i = 0; i < a.length; i++) {
            if (!m.containsKey(a[i])) m.put(a[i], new ArrayList<>());
            m.get(a[i]).add(i);
        }
        // tr(m);
        List<Integer> res = new ArrayList<>();
        char[] search = new char[]{'h', 'e', 'l', 'l', 'o'};
        int lastIdx = -1;
        for (char look : search) {
            // tr(lastIdx, look, lastIdx);
            boolean found = false;
            List<Integer> l = m.getOrDefault(look, new ArrayList<>());
            for (int idx : l) {
                if (idx > lastIdx) {
                    res.add(idx);
                    lastIdx = idx;
                    found = true;
                    break;
                }
            }
            if (!found) {
                pr("NO");
                return;
            }
            // tr("res", res);
        }
        pr("YES");
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
        new A58().run();
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
            for (int i = 0; i < n; i++)
                a[i] = nextInt();
            return a;
        }

        Integer[] readIntegerArray(int n) {
            Integer[] a = new Integer[n];
            for (int i = 0; i < n; i++)
                a[i] = nextInt();
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