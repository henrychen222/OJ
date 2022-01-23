/**
 * 12/19/21 morning
 * https://www.codechef.com/COOK136C/problems/FRIMEET
 */
package codechef.contest.cook.c_136;

import java.util.*;
import java.io.*;

class FriendsMeetup {

    static PrintWriter pw;

    // Accepted
    // fuck 题意理解错了
    // 一开始以为是x1  +1+2+1+2 ....     x2  +2+4 +2+4
    // 然后以为又是x1  +1+2+3+4 ....     x2  +2+4+6+8 ....
    // 实际那是表示坐标移动, x1 一直+1     x2  一直+2
    void solve(long x1, long x2) {
        if (x1 == x2) {
            pr("YES");
        } else if (x1 < x2) {
            pr("NO");
        } else {
            // test(x1, x2);
            pr("YES");
//            long dis = x1 - x2;
//            pr(ts.contains(dis) ? "YES" : "NO");
//            if (dis % 3 == 0 || dis % 3 == 1) {
//                pr("YES");
//            } else {
//                pr("NO");
//            }
        }
    }

    void test(long x1, long x2) {
        long sum = 0;
        for (int i = 0, step1 = 1, step2 = 2; ; i++) {
            tr(x1, x2, "diff", x1 - x2, "step sum", sum);
            if (x1 == x2) {
                pr("YES");
                return;
            } else if (x1 < x2) {
                pr("NO");
                return;
            }
            x1 += step1;
            x2 += step2;
            sum += step2 - step1;
        }
    }

    // TreeSet<Long> ts;

    private void run() {
        read_write_file(); // comment this before submission
        FastScanner fs = new FastScanner();
        // ts = new TreeSet<>();
        int t = fs.nextInt();
//        long sum = 0;
//        for (long i = 1; i < 2000000000; i++) {
//            sum += i;
//            if (sum > 2000000000) {
//                break;
//            } else {
//                ts.add(sum);
//            }
//        }
//        tr(ts.last(), ts.last() > 1000000000);
        while (t-- > 0) {
            long[] a = fs.readArray(2);
            solve(a[0], a[1]);
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
        new FriendsMeetup().run();
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

        long[] readArray(int n) {
            long[] a = new long[n];
            for (int i = 0; i < n; i++) a[i] = nextLong();
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