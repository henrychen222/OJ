/**
 * 07/06/22 morning
 * https://www.codechef.com/START46C/problems/ARMTRN
 */
package codechef.contest.start.c_46;

import java.util.*;
import java.io.*;

class ArmyTraining {
    static PrintWriter pw;

    // Accepted --- https://www.codechef.com/viewsolution/68416982
    // reference: https://discuss.codechef.com/t/armtrn-editoriale/102033
    void solve(int n, int[] a) {
        long tot = 0, res = 0, sum = 0;
        Arrays.sort(a);
        a = reverseA(a);
        for (int x : a) tot += x;
        for (int i = 0; i < n; i++) {
            long attack = sum, defense = 1000L * (n - i) - (tot - sum);
            res = Math.max(res, attack * defense);
            sum += a[i];
        }
        pr(res);
    }

    ////////////////////////////////////////////
    /*
     10 10 10 10
     (90 * 2) * (10 * 2) = 180 * 20 = 3600
     90 * (10 * 3) = 90 * 30 = 2700
     (90 * 3) * 10 = 270 * 10 = 2700
     */
    // WA
    void solve1(int n, int[] a) {
        long attack = 0, defense = 0, sum = 0;
        Arrays.sort(a);
        a = reverseA(a);
        for (int x : a) {
            if (x > 1000 - x) {
                attack += x;
            } else if (x < 1000 - x) {
                defense += 1000 - x;
            } else {
                sum += x;
            }
        }
        // tr(a, "first", attack, defense, sum);
        while (sum > 0) {
            if (attack >= defense) {
                defense += 500;
            } else {
                attack += 500;
            }
            sum -= 500;
        }
        // tr("second", attack, defense, sum);
        pr(attack * defense);
    }

    int[] reverseA(int[] a) {
        int n = a.length;
        int[] b = new int[n];
        for (int i = 0; i < n; i++) b[i] = a[n - i - 1];
        return b;
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
        new ArmyTraining().run();
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
