/**
 * 09/07/23 night
 * https://codeforces.com/contest/1872/problem/D
 */
package codeforce.cf.div3.y2023.r895;

import java.util.*;
import java.io.*;

// Accepted 1:49AM
public class D {
    static PrintWriter pw;

    /*
     (100+99+98+97+96) - (1 + 98) = 391  overlap sum 98
     (100+99+96+97+98) - (1 + 96) = 393  overlap sum 96
     */
    void solve(int n, int x, int y) { // make sum x max, overlap sum min
        int cx = n / x, cy = n / y;
        // tr(cx, cy);
        int rx = n, lx = n - cx + 1;
        long sx = sumOfRange(lx, rx);
        int overlap = 0;
//        Set<Integer> posX = new HashSet<>(), posY = new HashSet<>();
//        for (int cnt = 1; cnt <= cx; cnt++) posX.add(cnt * x);
//        for (int cnt = 1; cnt <= cy; cnt++) posY.add(cnt * y);
//        for (int px : posX) {
//            if (posY.contains(px)) {
//                overlap++;
//            }
//        }

        long lcm = lcm(x, y);
        overlap = (int) (n / lcm);

        long overlapSum = sumOfRange(lx, lx + overlap - 1);
        // tr("X", new int[]{lx, rx}, "overlap", overlap, "overlapSum", overlapSum);
        cy -= overlap;
        int ly = 1, ry = 1 + cy - 1;
        long sy = sumOfRange(ly, ry) + overlapSum;
        long res = sx - sy;
        // tr("Y", new int[]{ly, ry}, "cy", cy, "sx", sx, "sy", sy, "res", res);
        pr(res);
    }

    long sumOfRange(long l, long r) {
        return (l + r) * (r - l + 1) / 2;
    }

    long lcm(long a, long b) {
        if (a == 0 || b == 0) return 0;
        return a / gcd(a, b) * b;
    }

    long gcd(long a, long b) {
        return b == 0 ? a : gcd(b, a % b);
    }

    private void run() {
        read_write_file(); // comment this before submission
        FastScanner fs = new FastScanner();
        int t = fs.nextInt();
        while (t-- > 0) {
            int[] a = fs.readArray(3);
            solve(a[0], a[1], a[2]);
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
        new D().run();
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