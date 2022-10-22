/**
 * 10/18/22 night
 * https://codeforces.com/problemset/problem/41/C
 */
package codeforce.practice.L1300;

import java.util.*;
import java.io.*;

public class C41 {
    static PrintWriter pw;

    // Accepted --- https://codeforces.com/problemset/submission/41/176962191
    void solve(String s) {
        s = s.replaceAll("at", "@").replaceAll("dot", ".");
        if (s.charAt(0) == '.') s = "dot" + s.substring(1);
        if (s.charAt(s.length() - 1) == '.') s = s.substring(0, s.length() - 1) + "dot";
        List<Integer> at = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '@') {
                at.add(i);
            }
        }
        // tr(s, at);
        if (at.size() > 1) {
            List<String> d = work(s, at);
            // tr("begin", d);
            Collections.sort(d, new lexical_smallest_comp());
            // tr("after", d);
            pr(d.get(0));
        } else {
            pr(s);
        }
    }


    class lexical_smallest_comp implements Comparator<String> {
        public int compare(String x, String y) {
            int mark = x.compareTo(y);
            if (mark < 0) {
                return -1;
            } else if (mark > 0) {
                return 1;
            } else {
                return 0;
            }
        }
    }

    List<String> work(String s, List<Integer> at) {
        List<String> res = new ArrayList<>();
        for (int start : at) {
            String t = "";
            for (int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);
                if (c == '@') {
                    if (i != start) {
                        t += "at";
                    } else {
                        t += c;
                    }
                } else {
                    t += c;
                }
            }
            if (valid(t)) res.add(t);
        }
        return res;
    }

    boolean valid(String s) {
        return s.charAt(0) != '@' && s.charAt(s.length() - 1) != '@';
    }

    private void run() {
        read_write_file(); // comment this before submission
        FastScanner fs = new FastScanner();
        String s = fs.next();
        solve(s);
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
        new C41().run();
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