/**
 * 03/31/23 night 04/10/23 afternoon fixed
 * http://poj.org/problem?id=3809
 */
package poj.page29.p3809;

import java.util.*;
import java.io.*;

// Accepted --- http://poj.org/showsource?solution_id=24087809
// reference: https://www.cnblogs.com/GBRgbr/archive/2012/08/17/2644270.html
class Main {
    static PrintWriter pw;
    int[] question;
    int[][] dp;
    int n, m;

    void solve(char[][] g) {
        question = new int[n + 5];
        dp = new int[(1 << m) + 5][(1 << m) + 5];
        for (int i = 0; i < dp.length; i++) Arrays.fill(dp[i], -1);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (g[i][j] == '1') question[i] += 1 << j;
            }
        }
        pr(dfs(0, 0));
    }

    int dfs(int state, int quest) {
        // tr(state, quest, dp[state][quest]);
        if (dp[state][quest] != -1) return dp[state][quest];
        int cnt = 0;
        for (int i = 0; i < n; i++) {
            if ((question[i] & state) == quest) cnt++;
        }
        if (cnt <= 1) return dp[state][quest] = 0;  //如果没有两个人答案是重复的
        int ans = Integer.MAX_VALUE;
        for (int i = 0; i < m; i++) {
            if ((state & (1 << i)) != 0) continue;    //如果问题 i 已经在状态state中, 跳过
            dp[state | (1 << i)][quest] = dfs(state | (1 << i), quest); //选择问题i, 对问题i的回答为"否"
            dp[state | (1 << i)][quest | (1 << i)] = dfs(state | (1 << i), quest | (1 << i)); //选择问题i, 对问题i的回答为"是"
            ans = Math.min(ans, Math.max(dp[state | (1 << i)][quest], dp[state | (1 << i)][quest | (1 << i)]) + 1);
        }
        return dp[state][quest] = ans;
    }

    private void run() {
        read_write_file(); // comment this before submission
        FastScanner fs = new FastScanner();
        while (true) {
            m = fs.nextInt();
            n = fs.nextInt();
            if (m == 0 && n == 0) break;
            char[][] g = new char[n][];
            for (int i = 0; i < n; i++) g[i] = fs.next().toCharArray();
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
    }

    void tr(Object... o) {
        pw.println(Arrays.deepToString(o));
    }
}