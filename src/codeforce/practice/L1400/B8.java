/**
 * 10/30/22 evening
 * https://codeforces.com/problemset/problem/8/B
 */
package codeforce.practice.L1400;

import java.util.*;
import java.io.*;

public class B8 {
    static PrintWriter pw;

    // Accepted
    // reference: Rick_GT
    void solve(String s) {
        int[][] dis = new int[205][205];
        int x = 100, y = 100;
        for (int i = 0; i < s.length(); i++) {
            dis[x][y]++;
            char c = s.charAt(i);
            if (c == 'U') {
                y++;
            } else if (c == 'L') {
                x--;
            } else if (c == 'D') {
                y--;
            } else if (c == 'R') {
                x++;
            }
            if (dis[x - 1][y] + dis[x + 1][y] + dis[x][y - 1] + dis[x][y + 1] > 1) {
                pr("BUG");
                return;
            }
        }
        pr("OK");
    }

    void solve1(String s) {
        if (hasCycleWalkingRobot(s)) {
            pr("BUG");
            return;
        }
        List<char[]> d = cutMaxConsecutive(s.toCharArray());
        String[] invalid = {"RUL", "RDL", "LUR", "LDR", "URD", "ULD", "DRU", "DLU"};
        for (int i = 0; i + 2 < d.size(); i++) {
            char first = d.get(i)[0], second = d.get(i + 1)[0], third = d.get(i + 2)[0];
            // boolean ok = d.get(i).length == d.get(i + 1).length && d.get(i).length == d.get(i + 2).length;
            boolean ok = d.get(i).length + d.get(i + 2).length >= d.get(i + 1).length;
            String mark = "" + first + second + third;
            if (!ok) {
                for (String e : invalid) {
                    if (mark.equals(e)) {
                        // tr("222");
                        pr("BUG");
                        return;
                    }
                }
            }
        }
        String[] invalid2 = {"RL", "LR", "UD", "DU"};
        for (int i = 0; i + 1 < d.size(); i++) {
            char first = d.get(i)[0], second = d.get(i + 1)[0];
            int diff = Math.abs(d.get(i).length - d.get(i + 1).length);
            String mark = "" + first + second;
            if (diff == 1) {
                for (String e : invalid2) {
                    if (mark.equals(e)) {
                        // tr("333");
                        pr("BUG");
                        return;
                    }
                }
            }
        }
        pr("OK");
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

    boolean hasCycleWalkingRobot(String s) {
        int n = s.length(), x = 0, y = 0, move = 0;
        s = s.repeat(4);
        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            if (c == 'U') {
                y++;
            } else if (c == 'L') {
                x--;
            } else if (c == 'D') {
                y--;
            } else if (c == 'R') {
                x++;
            }
            move++;
            if (move % n == 0 && x == 0 && y == 0) return true;
        }
        return false;
    }

    private void run() {
        read_write_file(); // comment this before submission
        FastScanner fs = new FastScanner();
        String s = fs.next();
        solve(s);
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
        new B8().run();
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