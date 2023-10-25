/**
 * 03/29/23 afternoon
 * http://poj.org/problem?id=3981
 */
package poj.page30.p3981;

import java.util.*;
import java.io.*;

class Main {
    static PrintWriter pw;

    // Accepted --- http://poj.org/showsource?solution_id=24064481
    private void run() throws IOException {
        read_write_file(); // comment this before submission
        FastScanner fs = new FastScanner();
        String s;
        while ((s = fs.nextLine()) != null) {
            pr(s.replaceAll("you", "we"));
        }
    }

    // Accepted --- http://poj.org/showsource?solution_id=24064480
    private void run1() throws IOException {
        read_write_file(); // comment this before submission
        FastScanner fs = new FastScanner();
        String s;
        while ((s = fs.nextLine()) != null) { // issue EOF problem http://poj.org/showsource?solution_id=24064478 (RE)
            String res = "", cur = "";
            int i;
            for (i = 0; i < s.length(); i++) {
                char c = s.charAt(i);
                if (c == ' ') {
                    res += cur.equals("you") ? "we" : cur;
                    res += " ";
                    cur = "";
                } else {
                    cur += c;
                }
            }
            res += cur.equals("you") ? "we" : cur;
            pr(res);
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

        String nextLine() throws IOException {
            return br.readLine();
        }
    }

    void tr(Object... o) {
        pw.println(Arrays.deepToString(o));
    }
}