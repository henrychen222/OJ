/**
 * 02/16/22 morning
 * https://www.codechef.com/START26C/problems/SMOKE
 */
package codechef.contest.start.c_26;

import java.util.*;
import java.io.*;

class ControlPollution {
    static PrintWriter pw;

    // Accepted
    void solve(int n, int x, int y) {
        long res = Long.MAX_VALUE;
        int maxBus = n / 100 + 1, maxCar = n / 4 + 1;
        // tr("max", maxBus, maxCar);
        for (int bus = 0; bus <= maxBus; bus++) {
            for (int car = 0; car <= maxCar; car++) {
                // tr(bus, car);
                if (100 * bus + 4 * car >= n) {
                    long t = (long) bus * x + (long) car * y;
                    res = Math.min(res, t);
                }
            }
        }
        pr(res);
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
        new ControlPollution().run();
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
