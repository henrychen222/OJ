/**
 * 03/30/22 morning
 * https://www.codechef.com/START32C/problems/FLIPSORT
 */
package codechef.contest.start.c_32;

import java.util.*;
import java.io.*;

/*
  each time find last 0 index, swap [0, lastZeroIdx], will guarantee substring length is different
  find lastZeroIdx each time: search each time in updated string will TLE
  so, search original string
   last 0 index
   last 1 index
   ....
   we use cutMaxConsecutive With Index  e[e.length - 1] is the last 0 index and last 1 index
 */
class FlipSorting {
    static PrintWriter pw;

    // Accepted --- https://www.codechef.com/viewsolution/61702886
    void solve3(int n, String s) {
        int lastZeroIdx = s.lastIndexOf('0');
        List<int[]> res = new ArrayList<>();
        char[] a = s.toCharArray();
        Data data = cutMaxConsecutiveWithIndex(a);
        List<char[]> d = data.d;
        List<int[]> ia = data.ia;
//        debugArrayInList2(d);
//        debugArrayInList(ia);
        for (int i = d.size() - 1; i >= 0; i--) {
            int[] e = ia.get(i);
            int r = e[e.length - 1];
            if (r <= lastZeroIdx) {
                res.add(new int[]{1, e[e.length - 1] + 1}); // last 0 and last 1 swap, each time find last 0
            }
        }
        pr(res.size());
        for (int[] e : res) pr(e[0] + " " + e[1]);
    }

    // TLE https://www.codechef.com/viewsolution/61699831
    // TLE https://www.codechef.com/viewsolution/61703910
    // Accepted https://www.codechef.com/viewsolution/61704356
    void solve(int n, String s) {
        char[] a = s.toCharArray();
        List<int[]> res = new ArrayList<>();
        int pre = -1;
        while (true) {
            int pos = -1;
            for (int i = pre == -1 ? n - 1 : pre; i >= 0; i--) {
                if (a[i] == '0') {
                    pos = i;
                    pre = i;
                    break;
                }
            }
            // int pos = s.lastIndexOf('0');
            // tr("s", s, "pos" , pos);
            if (pos == -1) break;
            res.add(new int[]{1, pos + 1});
            for (int j = 0; j <= pos; j++) a[j] ^= 1;
//            String l = s.substring(0, pos + 1), r = s.substring(pos + 1);
//            tr("l", l, "r", r);
//            s = flip(l) + r;
            // tr("updated s", new String(a));
        }
        // tr("final", s);
        pr(res.size());
        for (int[] e : res) pr(e[0] + " " + e[1]);
    }

    String flip(String s) {
        String res = "";
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            res += c == '0' ? '1' : '0';
        }
        return res;
    }

    // WA https://www.codechef.com/viewsolution/61650820 (X has to be different)
    void solve1(int n, String s) {
        char[] a = s.toCharArray();
        List<int[]> res = new ArrayList<>();
        if (!operate(a, res)) {
            pr(0);
            return;
        }
        tr("initial", a);
        pr(res.size());
        for (int[] e : res) pr(e[0] + " " + e[1]);
        tr(test(a, res));
//        debugArrayInList(res);
    }

    boolean operate(char[] a, List<int[]> res) {
        int n = a.length, lastZeroIdx = -1;
        for (int i = n - 1; i >= 0; i--) {
            if (a[i] == '0') {
                lastZeroIdx = i;
                break;
            }
        }
        if (lastZeroIdx == -1) return false;
        char[] sub = Arrays.copyOfRange(a, 0, lastZeroIdx + 1);
        tr(a, sub);
        List<char[]> d = cutMaxConsecutive(sub);
        debugArrayInList2(d);
        int l = 0;
        int[] L = new int[d.size()];
        for (int i = 0; i < d.size(); i++) {
            L[i] = l + 1;
            l += d.get(i).length;
        }
        TreeSet<Integer> used = new TreeSet<>();
        for (int i = 0; i < d.size(); i++) {
            char[] e = d.get(i);
            int len = e.length;
            if (e[0] == '1') {
                if (!used.contains(len)) {
                    // tr("ok len", len);
                    res.add(new int[]{L[i], len});
                    used.add(len);
                }
                // res.add(new int[]{l + 1, len});
            }
        }
        // debugArrayInList(res);
        return true;
    }

    boolean test(char[] a, List<int[]> res) {
        for (int[] e : res) {
            int l = e[0] - 1, r = l + e[1] - 1;
            for (int i = l; i <= r; i++) a[i] ^= 1;
        }
        tr(a);
        List<char[]> d = cutMaxConsecutive(a);
        if (d.size() == 1) return true;
        if (d.size() == 2) {
            if (d.get(0)[0] == '0' && d.get(1)[0] == '1') return true;
        }
        return false;
    }

    void debugArrayInList2(List<char[]> l) {
        char[][] res = new char[l.size()][];
        for (int i = 0; i < l.size(); i++) res[i] = l.get(i);
        tr("out", res);
    }

    void debugArrayInList(List<int[]> l) {
        int[][] res = new int[l.size()][];
        for (int i = 0; i < l.size(); i++) res[i] = l.get(i);
        tr("out", res);
    }

    class Data {
        List<char[]> d;
        List<int[]> ia;

        Data(List<char[]> data, List<int[]> indexA) {
            d = data;
            ia = indexA;
        }
    }

    Data cutMaxConsecutiveWithIndex(char[] a) {
        List<char[]> d = new ArrayList<>();
        List<int[]> ia = new ArrayList<>();
        int start = 0, n = a.length;
        for (int i = 0; i + 1 < n; i++) {
            if (a[i + 1] != a[i]) {
                d.add(Arrays.copyOfRange(a, start, i + 1));
                ia.add(new int[]{start, i});
                start = i + 1;
            }
        }
        d.add(Arrays.copyOfRange(a, start, n));
        ia.add(new int[]{start, n - 1});
        return new Data(d, ia);
    }

    List<char[]> cutMaxConsecutive(char[] a) {
        List<char[]> d = new ArrayList<>();
        int start = 0, n = a.length;
        for (int i = 0; i + 1 < n; i++) {
            if (a[i + 1] != a[i]) {
                d.add(Arrays.copyOfRange(a, start, i + 1));
                start = i + 1;
            }
        }
        d.add(Arrays.copyOfRange(a, start, n));
        return d;
    }

    private void run() {
        read_write_file(); // comment this before submission
        FastScanner fs = new FastScanner();
        int t = fs.nextInt();
        while (t-- > 0) {
            int n = fs.nextInt();
            String s = fs.next();
            solve(n, s);
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
        new FlipSorting().run();
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
