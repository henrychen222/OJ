/**
 * 05/25/22 afternoon
 * https://codeforces.com/contest/1686/problem/C
 */
package codeforce.cf.div2.r794;

import java.util.*;
import java.io.*;

public class C {
    static PrintWriter pw;

    // 06/07/22 night complete
    // Accepted --- https://codeforces.com/contest/1686/submission/158463133
    // reference: https://codeforces.com/contest/1685/standings SecondThread tourist
    void solve(int n, int[] a) {
        // tr("a", a);
        int[] b = ZigzagArray(a);
        // tr("b", b);
        boolean ok = true;
        for (int i = 0; i < n; i++) {
            int li = (i - 1 + n) % n, ri = (i + 1) % n;
            if (b[i] < b[li] && b[i] < b[ri]) continue;
            if (b[i] > b[li] && b[i] > b[ri]) continue;
            ok = false;
        }
        if (ok) {
            pr("YES");
            outputA(b);
        } else {
            pr("NO");
        }
    }

    int[] ZigzagArray(int[] a) {
        shuffleSort(a);
        int n = a.length;
        int[] res = new int[n];
        for (int i = 0; i < n / 2; i++) {
            res[2 * i] = a[i];
            res[2 * i + 1] = a[i + n / 2];
        }
        return res;
    }

    ///////////////////////////////////////////////////////////
    // WA
    void solve1(int n, int[] a) {
        int[] sa = alternateSort(a);
        // tr("sa", sa);
        if (test(sa)) {
            pr("YES");
            outputA(sa);
            return;
        }
        pr("NO");
    }

    boolean test(int[] a) {
        int n = a.length;
        for (int i = 0; i < n; i++) {
            int cur = a[i];
            int pre, next;
            if (i == 0) {
                pre = a[n - 1];
                next = a[i + 1];
            } else if (i == n - 1) {
                pre = a[i - 1];
                next = a[0];
            } else {
                pre = a[i - 1];
                next = a[i + 1];
            }
            // tr(pre, cur, next);
            if (!small(pre, cur, next) && !large(pre, cur, next)) return false;
        }
        return true;
    }

    boolean large(int pre, int cur, int next) {
        return cur > pre && cur > next;
    }

    boolean small(int pre, int cur, int next) {
        return cur < pre && cur < next;
    }

    boolean isAlternate(int[] a) {
        int n = a.length;
        char[] mark = new char[n];
        for (int i = 0; i < n; i++) {
            int cur, next;
            if (i + 1 < n) {
                cur = a[i];
                next = a[i + 1];
            } else {
                cur = a[i];
                next = a[0];
            }
            if (cur < next) {
                mark[i] = '<';
            } else if (cur > next) {
                mark[i] = '>';
            } else {
                mark[i] = '=';
            }
        }
        mark[n - 1] = a[n - 1] < a[0] ? '<' : '>';
        Set<Character> even = new HashSet<>(), odd = new HashSet<>();
        for (int i = 0; i < n - 1; i++) {
            if (i % 2 == 0) {
                even.add(mark[i]);
            } else {
                odd.add(mark[i]);
            }
        }
        tr(mark, "even", even, "odd", odd);
        if (even.size() == 1 && odd.size() == 1) {
            char x = even.iterator().next(), y = odd.iterator().next();
            if ((x == '<' && y == '>') || (x == '>' && y == '<')) return true;
        }
        return false;
    }

    int[] alternateSort(int[] a) {
        shuffleSort(a);
        int n = a.length, i = 0, j = n - 1;
        int[] res = new int[n];
        int p = 0;
        while (i < j) {
            res[p++] = a[j--];
            res[p++] = a[i++];
        }
        if (n % 2 != 0) res[p] = a[i];
        return res;
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

    void outputA(int[] a) {
        for (int e : a) pw.print(e + " ");
        pr("");
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