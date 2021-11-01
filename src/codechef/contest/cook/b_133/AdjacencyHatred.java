/**
 * 09/19/21 noon
 * https://www.codechef.com/COOK133B/problems/ADJHATE
 */
package codechef.contest.cook.b_133;

import java.io.*;
import java.util.*;

class AdjacencyHatred {

    static PrintWriter pw;

    // Accepted
    void solve(int n, int[] a) {
        List<Integer> odd = new ArrayList<>();
        List<Integer> even = new ArrayList<>();
        for (int x : a) {
            if (x % 2 == 0) {
                even.add(x);
            } else {
                odd.add(x);
            }
        }
        // tr(odd, even);
        int lo = odd.size(), le = even.size();
        if (le == 0 || lo == 0) {
            pr(-1);
            return;
        }
        odd.addAll(even);
        output(odd);
        // test(odd);
    }

    void test(List<Integer> a) {
        int n = a.size();
        long res = 0;
        for (int i = 1; i < n; i++) {
            res += Math.abs(a.get(i) - a.get(i - 1));
        }
        tr("test", res, res % 2 == 1);
    }

    void output(List<Integer> a) {
        for (int e : a) {
            pw.print(e + " ");
        }
        pr("");
    }

    private void run() {
        read_write_file(); // comment this before submission
        FastScanner fs = new FastScanner();
        int t = fs.nextInt();
        while (t-- > 0) {
            int n = fs.nextInt();
            int[] a = fs.readArray(n);
            solve(n, a);
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
        new AdjacencyHatred().run();
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