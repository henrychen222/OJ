/**
 * 02/10/25 evening 05/09/26 evening
 * https://www.luogu.com.cn/problem/P1112
 */
package luogu.level3_yellow.page1.P1112;

import java.io.*;
import java.util.*;

// Accepted --- https://www.luogu.com.cn/record/277278608
// reference: https://blog.csdn.net/qq_41700151/article/details/98963229
class Main {
    static PrintWriter pw;

    /*
     2 11 190000 960000 2
     191919
     383838
     575757
     699050
     767676
     959595
     */
    void buildNumberIteration(int l, int r, int L, int R, int k) {
        int[] cnt = new int[10000001];
        for (int base = l; base <= r; base++) {
            for (int first = 1; first < base; first++) {
                for (int second = 0; second < base; second++) {
                    if (first != second) {
                        int x = 0, len = 0;
                        while (x <= R) {
                            if (len % 2 == 0) {
                                x = base * x + first;
                            } else {
                                x = base * x + second;
                            }
                            len++;
                            if (x >= L && x <= R) {
                                cnt[x]++;
                            }
                        }
                    }
                }
            }
        }
        for (int x = L; x <= R; x++) {
            if (cnt[x] == k) pr(x);
        }
    }

    private void run() {
        read_write_file(); // comment this before submission
        FastScanner fs = new FastScanner();
        int l = Integer.parseInt(fs.next()), r = Integer.parseInt(fs.next()),
                L = Integer.parseInt(fs.next()), R = Integer.parseInt(fs.next()), k = Integer.parseInt(fs.next());
        buildNumberIteration(l, r, L, R, k);
    }

    void read_write_file() {
        FileInputStream instream = null;
        PrintStream outstream = null;
        try {
            String INPUT = "input.txt";
            instream = new FileInputStream(INPUT);
            String OUTPUT = "output.txt";
            outstream = new PrintStream(new FileOutputStream(OUTPUT));
            System.setIn(instream);
            System.setOut(outstream);
        } catch (Exception ignored) {
        }
    }

    public static void main(String[] args) {
        pw = new PrintWriter(System.out);
        new Main().run();
        pw.close();
    }

    <T> void pr(T t) {
        pw.println(t);
    }

    static class FastScanner {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer("");

        String next() {
            while (!st.hasMoreTokens())
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException ignored) {
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
