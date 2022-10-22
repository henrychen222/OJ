/**
 * 08/27/22 morning
 * https://www.acwing.com/problem/content/4610/
 */
package acwing.r66.B;

import java.util.*;
import java.io.*;

class Main {
    static PrintWriter pw;

    /*
     ABABABBAB????????????ABABABABA???????????ABABABABA?????????KLCSJB?????????Z -> ABABABBABAAAAAAAAAAAAABABABABAAAAAAAAAAAAABABABABADEFGHIMNOKLCSJBPQRTUVWXYZ
     */
    // Accepted
    void solve(char[] s) {
        int n = s.length;
        boolean ok = false;
        for (int i = 0; i + 26 - 1 < n; i++) {
            char[] sub = Arrays.copyOfRange(s, i, i + 26);
            String[] need = make(sub);
            // tr(sub, need);
            if (need[1].equals("good")) {
                String t = need[0];
                // tr("t", t);
                int p = 0;
                for (int j = i, cnt = 0; cnt < 26; j++, cnt++) {
                    if (s[j] == '?') {
                        s[j] = t.charAt(p++);
                    }
                }
                ok = true;
                break;
            }
        }
        for (int i = 0; i < n; i++) {
            if (s[i] == '?') s[i] = 'A';
        }
        pr(ok ? new String(s) : -1);
    }

    String[] make(char[] a) {
        boolean[] has = new boolean[26];
        int cnt = 0;
        for (char c : a) {
            if (c != '?') {
                has[c - 'A'] = true;
            } else {
                cnt++;
            }
        }
        String res = "";
        for (int i = 0; i < 26; i++) {
            if (!has[i]) res += (char) (i + 'A');
        }
        String mark = cnt >= res.length() ? "good" : "bad";
        return new String[]{res, mark};
    }

    private void run() throws IOException {
        read_write_file(); // comment this before submission
        FastScanner fs = new FastScanner();
        char[] s = fs.readLine().toCharArray();
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

        String readLine() throws IOException {
            return br.readLine();
        }
    }

    void tr(Object... o) {
        pw.println(Arrays.deepToString(o));
    }
}