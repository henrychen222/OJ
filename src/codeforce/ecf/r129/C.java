/**
 * 05/23/22 morning
 * https://codeforces.com/contest/1681/problem/C
 */
package codeforce.ecf.r129;

import java.util.*;
import java.io.*;

// Accepted
public class C {
    static PrintWriter pw;

    /*
    2 3 1 2      1 3 2 2      1 2 3 2    1 2 2 3
    2 3 2 3      2 3 2 3      2 2 3 3    2 2 3 3
     */
    void solve(int n, int[] a, int[] b) {
        int[] sa = Arrays.copyOf(a, n), sb = Arrays.copyOf(b, n);
        shuffleSort(sa);
        shuffleSort(sb);
        // tr("sorted", sa, sb);
        List<String> res = BubbleSort(n, a, b);
        // tr("check", a, b);
        if (Arrays.equals(sa, a) && Arrays.equals(sb, b)) {
            pr(res.size());
            for (String e : res) pr(e);
        } else {
            pr(-1);
        }
    }

    List<String> BubbleSort(int n, int[] a, int[] b) {
        List<String> res = new ArrayList<>();
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (a[j] > a[j + 1] || b[j] > b[j + 1]) {
                    swap(a, j, j + 1);
                    swap(b, j, j + 1);
                    res.add((j + 1) + " " + (j + 2));
                }
            }
        }
        return res;
    }

    void swap(int[] a, int i, int j) {
        int tmp = a[i];
        a[i] = a[j];
        a[j] = tmp;
    }

    void shuffleSort(int[] a) {
        shuffleArray(a);
        Arrays.sort(a);
    }

    void shuffleArray(int[] a) {
        int n = a.length;
        Random rnd = new Random();
        for (int i = 0; i < n; i++) {
            int tmp = a[i];
            int randomPos = i + rnd.nextInt(n - i);
            a[i] = a[randomPos];
            a[randomPos] = tmp;
        }
    }

    private void run() {
        read_write_file(); // comment this before submission
        FastScanner fs = new FastScanner();
        int t = fs.nextInt();
        while (t-- > 0) {
            int n = fs.nextInt();
            int[] a = fs.readArray(n);
            int[] b = fs.readArray(n);
            solve(n, a, b);
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