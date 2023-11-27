/**
 * 10/25/23 afternoon  10/28/23 morning
 * https://www.luogu.com.cn/problem/P1166
 */
package luogu.level3_yellow.P1166;

import java.util.*;
import java.io.*;

class Main {

    static PrintWriter pw;

    /*
     /   /   /   72
     /   /   /   /
     12 12 34
     / / / / / / / / / / / / 2 (长度>12)
     */
    /*
     https://www.luogu.com.cn/record/list?pid=P1166&user=henrychenOutlook&page=1 (WA + RE)
     Accepted --- https://www.luogu.com.cn/record/132001933
     */
    void solve(String[] a) {
        int n = a.length;
//        tr(n, a);
        int[][] b = new int[n][];
        int[] score = new int[n];
        boolean[] valid = new boolean[n];
        for (int i = 0; i < n; i++) {
            String s = a[i];
            if (s.equals("/")) {
                b[i] = new int[]{10, 0, 1};
            } else {
                if (s.charAt(s.length() - 1) == '/') {
                    b[i] = new int[]{s.charAt(0) - '0', 10 - (s.charAt(0) - '0'), 2};
                } else {
                    char second = s.length() < 2 ? '0' : s.charAt(1);
                    b[i] = new int[]{s.charAt(0) - '0', second - '0', 2};
                }
            }
        }
        // tr(b);
        for (int i = 0; i < n; i++) {
            int curScore = b[i][0] + b[i][1];
            score[i] += curScore;
            if (curScore == 10) {
                if (b[i][2] == 1) { // 一轮10分
                    if (i + 1 < n) {
                        score[i] += b[i + 1][0];
                        score[i] += b[i + 1][1];
                        if (b[i + 1][1] != 0) valid[i] = true; // 已经加了后两次打分数
                        if (b[i + 1][0] == 10) {
                            if (i + 2 < n) {
                                score[i] += b[i + 2][0];
                                valid[i] = true; // 后面两轮都打了才算成绩
                            }
                        }
                    }
                } else {
                    if (i + 1 < n) {
                        score[i] += b[i + 1][0];
                        valid[i] = true;
                    }
                }
            } else {
                if (i < n - 1) valid[i] = true;
            }
        }
        int last = -1;
        for (int i = n - 1; i >= 0; i--) {  // find the last round to print
            if (valid[i]) {
                last = i;
                break;
            }
        }
        int cnt = last + 1;
//        tr(score);
//        tr(valid, cnt);
        cnt = Math.min(10, cnt);
        score = Arrays.copyOfRange(score, 0, cnt);
        int[] sum = new int[cnt];
        int cur = 0;
        for (int i = 0; i < cnt; i++) {
            cur += score[i];
            sum[i] = cur;
        }
        outputA(score);
        outputA(sum);
    }

    void outputA(int[] a) {
        for (int e : a) pw.print(e + " ");
        pr("");
    }

    private void run() throws IOException {
        read_write_file(); // comment this before submission
        FastScanner fs = new FastScanner();
        String s = fs.nextLine();
        String[] a = normalizeSpace(s).split(" ");
        solve(a);
    }

    // https://www.baeldung.com/java-string-remove-whitespace
    String normalizeSpace(String s) {
        if (s == null) return null;
        s = s.trim();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c != ' ') {
                if (i - 1 >= 0 && s.charAt(i - 1) == ' ') sb.append(' ');
                sb.append(c);
            }
        }
        return sb.toString();
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

    public static void main(String[] args) throws IOException {
        pw = new PrintWriter(System.out);
        new Main().run();
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

        String nextLine() throws IOException {
            return br.readLine();
        }
    }

    void tr(Object... o) {
        pw.println(Arrays.deepToString(o));
    }
}
