/**
 * 06/01/22 morning
 * https://www.codechef.com/START41C/problems/ISPAR
 */
package codechef.contest.start.c_41;

import java.util.*;
import java.io.*;

class IsThisPriorityParity {
    static PrintWriter pw;

    // Accepted --- https://www.codechef.com/viewsolution/65934433
    void solve(long n, long k) {
        // long res = JosephRingRemovingKth(n, k);
        char check = JosephRingRemovingKthEvenOdd(n, k);
        // tr(res, check);
        pr(check == 'E' ? "EVEN" : "ODD");
    }

    char JosephRingRemovingKthEvenOdd(long n, long k) {
        if (k == 1) {
            return n % 2 == 0 ? 'E' : 'O';
        } else if (k == 2) {
            return 'O';
        } else {
            return 'E';
        }
    }

    // correct https://stackoverflow.com/questions/3810789/removal-of-every-kth-person-from-a-circle-find-the-last-remaining-person
    long JosephRingRemovingKth(long n, long k) {
        long last = 0;
        for (int i = 2; i <= n; i++) last = (last + k) % i;
        return last + 1;
    }

    /*
     https://en.wikipedia.org/wiki/Josephus_problem
     https://www.geeksforgeeks.org/josephus-problem-set-1-a-on-solution/
     */
    long JosephRingRemovingSecond(long n) { // k == 2
        long v = n - Long.highestOneBit(n);
        return 2 * v + 1;
    }

    private void run() {
        read_write_file(); // comment this before submission
        FastScanner fs = new FastScanner();
        int t = fs.nextInt();
        while (t-- > 0) {
            long n = fs.nextLong(), k = fs.nextLong();
            solve(n, k);
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
        new IsThisPriorityParity().run();
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
    }

    void tr(Object... o) {
        pw.println(Arrays.deepToString(o));
    }
}
