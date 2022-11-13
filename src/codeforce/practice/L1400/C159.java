/**
 * 11/04/22 evening + night
 * https://codeforces.com/problemset/problem/159/C
 */
package codeforce.practice.L1400;

import java.util.*;
import java.io.*;

// Accepted: My initial Solution
public class C159 {
    static PrintWriter pw;

    /*
     (ArrayList)
     https://codeforces.com/contest/159/submission/179335064 (use String TLE 4)
     https://codeforces.com/contest/159/submission/179358474 (Accepted --- use StringBuilder 1464ms)
     https://codeforces.com/contest/159/submission/179371052 (Accepted --- use StringBuilder 1372ms)

     (LinkedList)
     https://codeforces.com/contest/159/submission/179336200 (use String TLE 4)
     https://codeforces.com/contest/159/submission/179352507 (use StringBuilder TLE 18)
     */
    private void run() {
        read_write_file(); // comment this before submission
        FastScanner fs = new FastScanner();
        int k = fs.nextInt();
        char[] s = fs.next().repeat(k).toCharArray();
        Map<Character, ArrayList<Integer>> m = counter_value_in_indexA_in(s);
        int n = fs.nextInt();
        for (int i = 0; i < n; i++) {
            int p = fs.nextInt();
            char c = fs.nextChar();
            m.get(c).remove(p - 1);
        }
        pr(buildStringFromDeletion(m, s.length));
    }

    StringBuilder buildStringFromDeletion(Map<Character, ArrayList<Integer>> m, int n) {
        char[] order = new char[n];
        for (char c : m.keySet()) {
            for (int idx : m.get(c)) order[idx] = c;
        }
        StringBuilder res = new StringBuilder(); // use String will cause TLE
        for (char c : order) {
            if (c != 0) res.append(c);
        }
        return res;
    }

    Map<Character, ArrayList<Integer>> counter_value_in_indexA_in(char[] a) {
        Map<Character, ArrayList<Integer>> m = new HashMap<>();
        for (int i = 0; i < a.length; i++) m.computeIfAbsent(a[i], x -> new ArrayList<>()).add(i);
        return m;
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
        new C159().run();
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

        char nextChar() {
            return next().charAt(0);
        }
    }

    void tr(Object... o) {
        pw.println(Arrays.deepToString(o));
    }
}