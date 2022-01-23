/**
 * 11/21/21 morning
 * https://www.codechef.com/COOK135B/problems/MISSSUMS
 */

package codechef.contest.cook.b_135;

import java.util.*;
import java.io.*;

class MakeDivisible {
    static PrintWriter pw;

    // Accepted --- https://www.codechef.com/viewsolution/54148338
    // reference: https://www.codechef.com/viewsolution/54084544
    void solve(int n, int[] a) {
        int mod1 = 0, mod2 = 0, sum = 0;
        for (int x : a) {
            if (x % 3 == 0) continue;
            if (x % 3 == 1) {
                mod1++;
            } else {
                mod2++;
            }
            sum += x;
        }
        if ((mod1 + 2 * mod2) % 3 != 0) {
            pr(-1);
        } else {
            int res = 2 * Math.abs(mod1 - mod2) / 3 + Math.min(mod1, mod2);
            pr(res);
        }
    }

    ////////////////////////////////////////////////////////////////
    // don't know
    void solve2(int n, int[] a) {
        long sum = 0, tot = 0;
        for (int x : a) {
            if (x % 3 == 0) continue;
            tot++;
            sum += x;
        }
        if (sum == 0) {
            pr(0);
            return;
        }
        if (sum % 3 != 0) {
            pr(-1);
            return;
        }
        long[][] p = new long[(int) tot][];
        for (int i = 0; i < n; i++) {
            if (a[i] % 3 == 0) continue;
            long lb = -1, ub = -1;
            for (int x = a[i]; ; x++) {
                if (x % 3 == 0) {
                    ub = x;
                    break;
                }
            }
            for (int x = a[i]; ; x--) {
                if (x % 3 == 0) {
                    lb = x;
                    break;
                }
            }
            p[i] = new long[]{lb - a[i], ub - a[i]};
        }
        Arrays.sort(p, (x, y) -> Long.compare(x[1], y[1]));
        tr(p);
    }

    // WA
    void solve1(int n, int[] a) {
        long sum = 0, tot = 0;
        for (int x : a) {
            if (x % 3 == 0) continue;
            tot++;
            sum += x;
        }
        // tr(sum, tot);
        if (sum % 3 == 0 && tot % 2 == 0) {
            pr(tot / 2);
        } else {
            pr(-1);
        }
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
        new MakeDivisible().run();
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

// TreeMap<Integer, Integer> m = new TreeMap<>();
//            while (m.size() > 0) {
//                tr(m);
//                int x = m.firstKey(), xocc = m.get(x);
//                for (int y : m.keySet()) {
//                    int yocc = m.get(y);
//                    long add = (long) x + y;
//                    int cnt = Math.min(xocc, yocc);
//                    if (add % 3 == 0) {
//                        res++;
//                        if (xocc > cnt) {
//                            m.put(x, xocc - cnt);
//                        } else {
//                            m.remove(x);
//                        }
//                        if (yocc > cnt) {
//                            m.put(y, yocc - cnt);
//                        } else {
//                            m.remove(y);
//                        }
//                        break;
//                    }
//                }
//            }