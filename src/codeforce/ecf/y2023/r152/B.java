/**
 * 07/27/23 morning
 * https://codeforces.com/contest/1849/problem/B
 */
package codeforce.ecf.y2023.r152;

import java.util.*;
import java.io.*;
import java.util.stream.Collectors;

public class B {
    static PrintWriter pw;

    // Accepted
    void solve(int n, int k, int[] a) {
        int[][] d = new int[n][];
        for (int i = 0; i < n; i++) d[i] = new int[]{i + 1, (a[i] + k) % k == 0 ? k : (a[i] + k) % k};
        // tr(d);
        Arrays.sort(d, (x, y) -> {
            if (x[1] != y[1]) return y[1] - x[1]; // larger pick up first
            return x[0] - y[0];
        });
        // tr(d);
        List<Integer> res = Arrays.stream(d).map(e -> e[0]).collect(Collectors.toList());
        outputL(res);
    }

//    void solve2(int n, int k, int[] a) {
//        int[][] ct = new int[n][];
//        int keep = -1, swap = 1;
//        for (int i = 0; i < n; i++) ct[i] = new int[]{divideCeil(a[i], k), a[i], i + 1};
//        // tr(ct);
//        Arrays.sort(ct, (x, y) -> {
//            // if (x[0] != y[0]) return x[0] - y[0];
//            if (x[1] != y[1]) {
//                if (x[1] > y[1]) {
//                    int diff = x[1] - y[1];
//                    if (diff < k) { // larger comes first, larger pick up first
//                        return keep;
//                    } else if (diff == k) { // larger will become same to smaller, pick by smaller index
//                        return x[2] - y[2];
//                    } else { // smaller comes first
//                        return swap;
//                    }
//                } else {
//                    int diff = y[1] - x[1];
//                    if (diff < k) {
//                        return swap;
//                    } else if (diff == k) {
//                        return x[2] - y[2];
//                    } else {
//                        return keep;
//                    }
//                }
//            }
//            return x[2] - y[2];
//        });
//        // tr(ct);
//        List<Integer> res = Arrays.stream(ct).map(e -> e[2]).collect(Collectors.toList());
//        outputL(res);
//    }
//
//    int divideCeil(int x, int d) {
//        return (int) Math.ceil((double) x / d);
//    }

    // TLE
    void solve1(int n, int k, int[] a) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((x, y) -> {
            if (x[0] != y[0]) return y[0] - x[0];
            return x[1] - y[1];
        });
        for (int i = 0; i < n; i++) pq.add(new int[]{a[i], i});
        List<Integer> res = new ArrayList<>();
        while (!pq.isEmpty()) {
            int[] cur = pq.poll();
            // tr("cur", cur);
            cur[0] -= k;
            if (cur[0] > 0) {
                pq.add(cur);
            } else {
                res.add(cur[1] + 1);
            }
            // tr("after", pq.toArray());
        }
        outputL(res);
    }

    void outputL(List<Integer> l) {
        for (int e : l) pw.print(e + " ");
        pr("");
    }

    private void run() {
        read_write_file(); // comment this before submission
        FastScanner fs = new FastScanner();
        int t = fs.nextInt();
        while (t-- > 0) {
            int n = fs.nextInt(), k = fs.nextInt();
            int[] a = fs.readArray(n);
            solve(n, k, a);
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
        new B().run();
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



