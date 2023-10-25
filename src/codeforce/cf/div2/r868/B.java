/**
 * 04/27/23 morning
 * https://codeforces.com/contest/1823/problem/B
 */
package codeforce.cf.div2.r868;

import java.util.*;
import java.io.*;

public class B {
    static PrintWriter pw;

    // Pretests passed
    void solve(int n, int k, int[] p) {
        int[] a = Arrays.copyOf(p, n);
        shuffleSort(a);
        List<TreeSet<Integer>> gp = new ArrayList<>(), ga = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            TreeSet<Integer> curP = new TreeSet<>(), curA = new TreeSet<>();
            for (int j = i; j < n; j += k) {
                curP.add(p[j]);
                curA.add(a[j]);
            }
            gp.add(curP);
            ga.add(curA);
        }
//        tr(p);
//        tr(a);
//        tr(gp);
//        tr(ga);
        int[] diff = new int[gp.size()];
        for (int i = 0; i < diff.length; i++) {
            TreeSet<Integer> curP = gp.get(i), curA = ga.get(i);
            int d = 0;
            for (int x : curP) {
                if (!curA.contains(x)) d++;
            }
            diff[i] = d;
        }
        // tr("diff", diff);
        boolean allZero = true;
        long sum = 0;
        for (int d : diff) {
            if (d != 0) allZero = false;
            sum += d;
        }
        if (sum > 2) {
            pr(-1);
            return;
        }
        pr(allZero ? 0 : 1);
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
            int n = fs.nextInt(), k = fs.nextInt();
            int[] p = fs.readArray(n);
            solve(n, k, p);
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
        new B().run();
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