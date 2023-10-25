/**
 * 05/23/22 afternoon
 * http://poj.org/problem?id=1002
 */
package poj.page1.p1002;

import java.util.*;
import java.io.*;

class Main {
    static PrintWriter pw;

    // Accepted --- http://poj.org/showsource?solution_id=23517095 3500ms
    // Accepted --- http://poj.org/showsource?solution_id=23517096 3438ms
    private void run() {
        read_write_file(); // comment this before submission
        FastScanner fs = new FastScanner();
        Map<Character, Integer> m = telephoneMap();
        // tr(m);
        int n = fs.nextInt();
        // TreeMap<String, Integer> res = new TreeMap<>(); // Java 1.5 not allowed
        TreeMap<String, Integer> res = new TreeMap<String, Integer>();
        while (n-- > 0) {
            String t = "";
            char[] s = fs.next().toCharArray();
            for (char c : s) {
                if (Character.isUpperCase(c)) {
                    t += m.get(c);
                } else if (Character.isDigit(c)) {
                    t += c - '0';
                }
                if (t.length() == 3) t += '-';
            }
            // tr("t", t);
            // res.put(t, res.getOrDefault(t, 0) + 1); // java 1.5 doesn't has getOrDefault() https://docs.oracle.com/javase/1.5.0/docs/api/java/util/TreeMap.html
            if (res.containsKey(t)) {
                res.put(t, res.get(t) + 1);
            } else {
                res.put(t, 1);
            }
        }
        // tr(res);
        outputM(res);
    }

    Map<Character, Integer> telephoneMap() {
        Map<Character, Integer> m = new HashMap<Character, Integer>();
        int v = 1, i = 0;
        for (char c = 'A'; c <= 'Z'; c++) {
            if (c == 'Q' || c == 'Z') continue;
            if (i % 3 == 0) {
                v++;
            }
            m.put(c, v);
            i++;
        }
        return m;
    }

    void outputM(TreeMap<String, Integer> m) {
        boolean print = false;
        for (String k : m.keySet()) {
            int occ = m.get(k);
            if (occ > 1) {
                print = true;
                pr(k + " " + m.get(k));
            }
        }
        if (!print) pr("No duplicates."); // fuck missed this
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
    }

    void tr(Object... o) {
        pw.println(Arrays.deepToString(o));
    }
}