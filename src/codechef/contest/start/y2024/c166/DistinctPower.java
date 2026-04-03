/**
 * 12/25/24 morning
 * https://www.codechef.com/START166C/problems/DPOWER
 */
package codechef.contest.start.y2024.c166;

import java.util.*;
import java.io.*;

// Accepted
class DistinctPower {
    static PrintWriter pw;

    /*
     [5 8 4 1]   [2 1 3 4]
     [8 4 1]     [1 3-1 4-1]  => [1 2 3]
     [5 4 1]     [2-1 3-1 4-1]   [1 2 3]
     [5 8 1]     [2 1 4-1]       [2 1 3]
     [5 8 4]     [2 1 3]

     [9 1 4 12 7]       [2 5 4 1 3]

                              remove rank
     [10 8 2 11 12 50 1 6 5]               [4 5 8 3 2 1 9 6 7]              affect

     [8 2 11 12 50 1 6 5]                  [5-1 8-1 3 2 1 9-1 6-1 7-1]       5      [4 7 3 2 1 8 5 6]
                                           [4 8-1 3 2 1 9-1 6-1 7-1]         4      [4 7 3 2 1 8 5 6]
                                           [4 5 3 2 1 9-1 6 7]               1      [4 5 3 2 1 8 6 7]
                                           [4-1 5-1 8-1 2 1 9-1 6-1 7-1]     6      [3 4 7 2 1 8 5 6]
                                           [4-1 5-1 8-1 3-1 1 9-1 6-1 7-1]   7      [3 4 7 2 1 8 5 6]
                                           [4-1 5-1 8-1 3-1 2-1 9-1 6-1 7-1] 8      [3 4 7 2 1 8 5 6]
                                           [4 5 8 3 2 1 6 7]                 0      [4 5 8 3 2 1 6 7]
                                           [4 5 8-1 3 2 1 9-1 7-1]           3      [4 5 7 3 2 1 8 6]
                                           [4 5 8-1 3 2 1 9-1 6]             2      [4 5 7 3 2 1 8 6]

                                                                            [5,4] [6, 7, 8]  [3, 2]
     */
    void solve(int n, int[] a) {
        int[] rank = new int[n];
        int[][] d = new int[n][];
        for (int i = 0; i < n; i++) d[i] = new int[]{a[i], i};
        Arrays.sort(d, (x, y) -> Integer.compare(y[0], x[0]));
        for (int i = 0; i < n; i++) rank[d[i][1]] = i + 1;

        int[] rankSort = Arrays.copyOf(rank, n);
        Arrays.sort(rankSort);
        // tr(rank, rankSort);
        int[] affect = new int[n];
        int p = 0;
        for (int remove : rank) {
            int cnt = n - remove;
            affect[p++] = cnt;
        }
        // tr(affect);
        List<int[]> affectCut = cutMaxConsecutive(affect);
        int duplicate = 0;
        for (int[] e : affectCut) duplicate += e.length - 1;
        // debugArrayInList(affectCut);
        pr(n - duplicate);
    }

    List<int[]> cutMaxConsecutive(int[] a) {
        List<int[]> d = new ArrayList<>();
        int start = 0, n = a.length;
        for (int i = 0; i + 1 < n; i++) {
            if (Math.abs(a[i + 1] - a[i]) > 1) { // modify
                d.add(Arrays.copyOfRange(a, start, i + 1));
                start = i + 1;
            }
        }
        d.add(Arrays.copyOfRange(a, start, n));
        return d;
    }

    void debugArrayInList(List<int[]> l) {
        int[][] res = new int[l.size()][];
        for (int i = 0; i < l.size(); i++) res[i] = l.get(i);
        tr("out", res);
    }

    private void run() {
        read_write_file();
        FastScanner fs = new FastScanner();
        int t = fs.nextInt();
        while (t-- > 0) {
            int n = fs.nextInt();
            int[] a = fs.readArray(n);
            solve(n, a);
        }
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
        new DistinctPower().run();
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

