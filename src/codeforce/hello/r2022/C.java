/**
 * 01/13/22 morning
 * https://codeforces.com/contest/1621/problem/C
 *
 * level: 1700
 */
package codeforce.hello.r2022;

import java.util.*;
import java.io.*;

public class C {
    static PrintWriter pw;
    FastScanner fs;

    // Accepted --- https://codeforces.com/contest/1621/submission/189138976
    // Accepted --- https://codeforces.com/contest/1621/submission/189139348
    // reference: https://codeforces.com/contest/1621/submission/141744457 (js interactive template)
    void solve(int n) {
        // tr(n);
        int[] res = new int[n];
        Arrays.fill(res, -1);
        for (int i = 0; i < n; i++) {
            if (res[i] >= 0) continue;
            Map<Integer, Integer> m = new HashMap<>();
            List<Integer> a = new ArrayList<>();
            while (true) {
                int x = ask(i);
                if (m.containsKey(x)) break;
                m.put(x, 1);
                a.add(x);
            }
            for (int j = 0; j < a.size(); j++) {
                res[a.get(j)] = a.get((j + 1) % a.size());
            }
        }
        outputA(res);
    }

    /////////////////////////////////////////////////////////
    // Accepted --- https://codeforces.com/contest/1621/submission/189137197
    void solve1(int n) {
        // tr("n", n);
        int[] res = new int[n];
        Arrays.fill(res, -1);
        for (int i = 0; i < n; i++) {
            if (res[i] == -1) {
                List<Integer> cycle = new ArrayList<>();
                int answer = ask(i);
                int x = ask(i);
                cycle.add(x);
                while (x != answer) {
                    x = ask(i);
                    cycle.add(x);
                }
                for (int j = 0; j < cycle.size(); j++) {
                    res[cycle.get(j)] = cycle.get((j + 1) % cycle.size());
                }
            }
        }
        outputA(res);
    }

    int ask(int i) {
        pr("? " + (i + 1));
        int x = fs.nextInt();
        return x - 1;
    }

    void outputA(int[] a) {
        prt("! ");
        for (int e : a) prt((e + 1) + " ");
        pr("");
    }

    private void run() {
        read_write_file(); // comment this before submission
        try {
            fs = new FastScanner();
            int t = fs.nextInt();
            while (t-- > 0) {
                int n = fs.nextInt();
                solve(n);
            }
        } catch (NullPointerException e) { // stop if interact ends
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
        new C().run();
        pw.close();
    }

    <T> void pr(T t) {
        pw.println(t);
        pw.flush();
    }

    <T> void prt(T t) {
        pw.print(t);
        pw.flush();
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
    }

    void tr(Object... o) {
        pw.println(Arrays.deepToString(o));
    }
}