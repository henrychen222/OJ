/**
 * 07/07/23 morning
 * https://codeforces.com/contest/1846/problem/B
 * https://leetcode.com/problems/find-winner-on-a-tic-tac-toe-game/
 */
package codeforce.cf.div3.y2023.r883;

import java.util.*;
import java.io.*;

public class B {
    static PrintWriter pw;

    // Accepted
    void solve(char[][] g) {
        List<int[]> A = new ArrayList<>(), B = new ArrayList<>(), C = new ArrayList<>();
        int empty = 0;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                char c = g[i][j];
                if (c == 'X') {
                    A.add(new int[]{i, j});
                } else if (c == 'O') {
                    B.add(new int[]{i, j});
                } else if (c == '+') {
                    C.add(new int[]{i, j});
                } else {
                    empty++;
                }
            }
        }
//        debugArrayInList(A);
//        debugArrayInList(B);
//        debugArrayInList(C);
        if (check(A)) {
            pr("X");
        } else if (check(B)) {
            pr("O");
        } else if (check(C)) {
            pr("+");
        } else {
            pr("DRAW");
        }
    }

    boolean check(List<int[]> player) {
        if (player.size() < 3) return false;
        for (int i = 0; i < player.size(); i++) {
            for (int j = i + 1; j < player.size(); j++) {
                for (int k = j + 1; k < player.size(); k++) {
                    if (isWin(player.get(i), player.get(j), player.get(k))) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    boolean isWin(int[] a, int[] b, int[] c) {
        if ((a[0] == b[0] && b[0] == c[0]) || (a[1] == b[1] && b[1] == c[1])) return true;
        if ((a[1] - b[1]) * (b[0] - c[0]) == (a[0] - b[0]) * (b[1] - c[1])) return true; // k equal
        return false;
    }

    void debugArrayInList(List<int[]> l) {
        int[][] res = new int[l.size()][];
        for (int i = 0; i < l.size(); i++) res[i] = l.get(i);
        tr("out", res);
    }

    private void run() {
        read_write_file(); // comment this before submission
        FastScanner fs = new FastScanner();
        int t = fs.nextInt();
        while (t-- > 0) {
            char[][] g = new char[3][];
            for (int i = 0; i < 3; i++) g[i] = fs.next().toCharArray();
            solve(g);
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