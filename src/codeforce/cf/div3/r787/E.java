/**
 * 05/05/22 morning
 * https://codeforces.com/contest/1675/problem/E
 */
package codeforce.cf.div3.r787;

import java.util.*;
import java.io.*;

public class E {
    static PrintWriter pw;

    // Accepted --- https://codeforces.com/contest/1675/submission/156028715
    // reference: kmjp
    void solve(int n, int k, char[] s) {
        boolean[] visit = new boolean[26];
        for (int i = 0; i < n; i++) {
            while (s[i] > 'a') {
                if (visit[s[i] - 'a']) { // greedy
                    s[i]--;
                } else if (k > 0) {
                    k--;
                    visit[s[i] - 'a'] = true;
                    s[i]--;
                } else {
                    break;
                }
                // tr(new String(s));
            }
            // tr(new String(s));
        }
        pr(new String(s));
    }

    // Accepted --- https://codeforces.com/contest/1675/submission/156014767
    // reference: cuiaoxiang
    void solve2(int n, int k, char[] s) {
        int[] cnt = new int[26];
        for (int i = 0; i < 26; i++) cnt[i] = i;

//        int[] cnt = new int[n];
//        for (int i = 0; i < n; i++) cnt[i] = s[i] - 'a';
//        int sum = 0;
//        int stop = -1;
//        for (int i = 0; i < n; i++) {
//            if (sum + cnt[i] > k) {
//                stop = Math.max(0, i - 1);
//                break;
//            } else if (sum + cnt[i] == k) {
//                stop = i;
//                break;
//            }
//            sum += cnt[i];
//        }
//        tr(stop);
//        for (int i = 0; i <= stop; i++) {
//            k -= cnt[i];
//            cnt[i] = 0;
//        }
//        tr("update cnt", cnt, 'k', k);

        for (int i = 0; i < n; i++) {
            int cur = s[i] - 'a';
            while (cur != cnt[cur]) cur = cnt[cur];
            while (k > 0 && cur > 0) {
                int next = cnt[cur - 1];
                while (next != cnt[next]) next = cnt[next];
                // cur = cnt[cur] = next;
                cnt[cur] = next;
                cur = cnt[cur];
                k--;
            }
            s[i] = (char) ('a' + cur);
            // tr(s, k, cnt);
        }
        pr(new String(s));
    }

    ////////////////////////////////////////////////////////////////
    /*
      gndcafb

      fndcafb
      endcaeb
      dndcadb
      cnccacb
      bnbbabb
     */
    void solve1(int n, int k, char[] s) {
        int idx = 0;
        while (k-- > 0) {
            if (new String(s).equals("a".repeat(n))) break;
            char pre = preChar(s[idx]);
            // tr("pre", pre, new String(s));
            char old = s[idx];
            for (int i = idx; i < s.length; i++) {
                if (s[i] == old) s[i] = pre;
            }
            // tr("update", new String(s));
            if (s[idx] == 'a') idx++;
        }
        pr(new String(s));
    }

    char preChar(char c) {
        if (c == 'a') return 'z';
        return (char) (c - 1);
        // return String.valueOf((char) (c - 1)).charAt(0);
    }

    private void run() {
        read_write_file(); // comment this before submission
        FastScanner fs = new FastScanner();
        int t = fs.nextInt();
        while (t-- > 0) {
            int n = fs.nextInt(), k = fs.nextInt();
            char[] s = fs.next().toCharArray();
            solve(n, k, s);
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
        new E().run();
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
    }

    void tr(Object... o) {
        pw.println(Arrays.deepToString(o));
    }
}