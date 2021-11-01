/**
 * 10/16/21 morning
 * https://codingcompetitions.withgoogle.com/kickstart/round/00000000004362d6/00000000008b3a1c
 */
package kickstart.y2021.roundG.B;


import java.util.*;
import java.io.*;

public class Solution {

    static PrintWriter pw;

    // WA
    void solve(int k, int[][] g) {
        // tr(k, g);
        int sx = Integer.MAX_VALUE, sy = Integer.MAX_VALUE;
        int lx = Integer.MIN_VALUE, ly = Integer.MIN_VALUE;
        for (int[] a : g) {
            int x1 = a[0], y1 = a[1], x2 = a[2], y2 = a[3];
            sx = Math.min(sx, x1);
            sx = Math.min(sx, x2);
            sy = Math.min(sy, y1);
            sy = Math.min(sy, y2);

            lx = Math.max(lx, x1);
            lx = Math.max(lx, x2);
            ly = Math.max(ly, y1);
            ly = Math.max(ly, y2);
        }
        // TreeMap<Long, ArrayList<String>> m = new TreeMap<>();
        TreeMap<Long, ArrayList<ArrayList<Integer>>> m = new TreeMap<>();
        for (int x = sx; x <= lx; x++) {
            for (int y = sy; y <= ly; y++) {
                long sum = 0;
                // String ke = x + " " + y;
                ArrayList<Integer> ke = new ArrayList<>();
                ke.add(x);
                ke.add(y);
                for (int[] a : g) {
                    int x1 = a[0], y1 = a[1], x2 = a[2], y2 = a[3];
                    int minDis = minDis(x, y, x1, y1, x2, y2);
                    sum += minDis;
                }
//                tr(x, y, "sum", sum);
//                tr(" ");
//                if (!m.containsKey(sum)) m.put(sum, new ArrayList<>());
                if (!m.containsKey(sum)) m.put(sum, new ArrayList<>());
                m.get(sum).add(ke);
            }
        }
        // pw.println(m);
        ArrayList<ArrayList<Integer>> res = m.firstEntry().getValue();
        Collections.sort(res, new Comparator<ArrayList<Integer>>() {
            @Override
            public int compare(ArrayList<Integer> a, ArrayList<Integer> b) {
                if (a.get(0) == b.get(0)) return Integer.compare(a.get(1), b.get(1));
                return Integer.compare(a.get(0), b.get(0));
            }
        });
        ArrayList<Integer> ans = res.get(0);
        pr(ans.get(0) + " " + ans.get(1));
    }

    int minDis(int x, int y, int downLeftX, int downLeftY, int topRightX, int topRightY) {
        int topLeftX = downLeftX, topLeftY = topRightY;
        int downRightX = topRightX, downRightY = downLeftY;
        if (x >= downLeftX && x <= downRightX && y >= downLeftY && y <= topLeftY) return 0; // inside
        int res1 = man(x, y, downLeftX, downLeftY);
        int res2 = man(x, y, topRightX, topRightY);
        int res3 = man(x, y, topLeftX, topLeftY);
        int res4 = man(x, y, downRightX, downRightY);
        int res = Math.min(Math.min(res1, res2), Math.min(res3, res4));
//        tr("downLeft", downLeftX, downLeftY, res1);
//        tr("topRight", topRightX, topRightY, res2);
//        tr("topLeft", topLeftX, topLeftY, res3);
//        tr("downRight", downRightX, downRightY, res4);
//        tr(res1, res2, res3, res4, "res", res);
        return res;
    }

    int man(int x1, int y1, int x2, int y2) {
        return Math.abs(x1 - x2) + Math.abs(y1 - y2);
    }

    private void run() {
        read_write_file(); // comment this before submission
        FastScanner fs = new FastScanner();
        int t = fs.nextInt();
        for (int cas = 1; cas <= t; cas++) {
            pw.print("Case #" + cas + ": ");
            int k = fs.nextInt();
            int[][] g = new int[k][4];
            for (int i = 0; i < k; i++) {
                g[i] = fs.readArray(4);
            }
            solve(k, g);
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
        new Solution().run();
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
            for (int i = 0; i < n; i++)
                a[i] = nextInt();
            return a;
        }

        Integer[] readIntegerArray(int n) {
            Integer[] a = new Integer[n];
            for (int i = 0; i < n; i++)
                a[i] = nextInt();
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