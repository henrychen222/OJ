/**
 * 12/23/22 noon
 * https://codeforces.com/problemset/problem/180/C
 */
package codeforce.practice.L1400;

import java.util.*;
import java.io.*;
import java.util.stream.Collectors;

public class C158 {
    static PrintWriter pw;

    // Accepted --- https://codeforces.com/problemset/submission/158/186497862
    private void run() throws IOException {
        read_write_file(); // comment this before submission
        FastScanner fs = new FastScanner();
        Deque<String> cur = new ArrayDeque<>();
        int n = fs.nextInt();
        for (int i = 0; i < n; i++) {
            String[] lines = fs.nextLine().split(" ");
            if (lines[0].equals("pwd")) {
                if (cur.size() == 0) {
                    pr("/");
                } else {
                    String res = "/";
                    for (String s : cur) res += s + "/";
                    pr(res);
                }
            } else {
                if (lines[1].charAt(0) == '/') cur.clear(); // absolute path, starting from the root
                List<String> a = Arrays.stream(lines[1].split("/")).filter(x -> x.length() != 0).collect(Collectors.toList());
                for (String s : a) {
                    if (s.equals("..")) {
                        cur.pollLast();
                    } else {
                        cur.add(s);
                    }
                }
            }
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
        new C158().run();
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