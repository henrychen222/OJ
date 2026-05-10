/**
 * 05/07/26 evening
 * https://www.luogu.com.cn/problem/P1366
 */
package luogu.level3_yellow.page2.P1366;

import java.util.*;
import java.io.*;

public class Main {
    static PrintWriter pw;

    // Accepted --- https://www.luogu.com.cn/record/277076031 (FastScanner MLE)
    void solve(long[] a, long[] b) {
        long res = 0;
        int i = 0;
        for (long x : a) {
            while (i < b.length && b[i] < x) {
                i++;
            }
            int cnt = 0;
            while (i < b.length && b[i] == x) {
                i++;
                cnt++;
            }
            res ^= cnt;
        }
        pr(res);
    }

    private void run() throws IOException {
        read_write_file();
        long t = readLong();
        while (t-- > 0) {
            int n = (int) readLong(), m = (int) readLong();
            long[] a = new long[n], b = new long[m];
            for (int i = 0; i < n; i++) a[i] = readLong();
            for (int i = 0; i < m; i++) b[i] = readLong();
            solve(a, b);
        }
    }

    <T> void pr(T t) {
        pw.println(t);
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
        } catch (Exception ignore) {
        }
    }

    public static void main(String[] args) throws IOException {
        pw = new PrintWriter(System.out);
        new Main().run();
        pw.close();
    }

    // ---------- Fast I/O (1 MB buffer, manual parsing) ----------
    private static final byte[] BUF = new byte[1 << 20];
    private static int ptr = 0;
    private static int len = 0;
    private static final InputStream IN = System.in;

    private static byte readByte() throws IOException {
        if (ptr >= len) {
            len = IN.read(BUF);
            ptr = 0;
        }
        return BUF[ptr++];
    }

    // Reads an unsigned 64‑bit integer as a signed long (values fit in signed range)
    private static long readLong() throws IOException {
        long res = 0;
        byte c;
        while ((c = readByte()) < '0' || c > '9') ;
        do {
            res = res * 10 + (c - '0');
        } while ((c = readByte()) >= '0' && c <= '9');
        return res;
    }

    void tr(Object... o) {
        pw.println(Arrays.deepToString(o));
    }
}