/**
 * 02/16/22 morning
 * https://www.codechef.com/START26C/problems/STNGAME
 */
package codechef.contest.start.c_26;

import java.util.*;
import java.io.*;

class StoneGame {
    static PrintWriter pw;

    // Accepted --- https://www.codechef.com/viewsolution/58556273
    // reference: https://www.codechef.com/viewsolution/58529847
    // read: https://discuss.codechef.com/t/stngame-editorial/99261
    void solve(int n, char[] a, char[] b) {
        Arrays.sort(a);
        Arrays.sort(b);
        int AliceStart = 0, AliceEnd = n - 1, BobStart = 0, BobEnd = n - 1;
        char[] s = new char[2 * n];
        int l = 0, r = 2 * n - 1;
        for (int i = 0; i < 2 * n; i++) {
            if (i % 2 == 0) {
                if (BobStart <= BobEnd && a[AliceStart] >= b[BobEnd]) { // set right
                    s[r--] = a[AliceEnd--];
                } else { // set left
                    s[l++] = a[AliceStart++];
                }
            } else {
                if (AliceStart <= AliceEnd && a[AliceStart] >= b[BobEnd]) {
                    s[r--] = b[BobStart++];
                } else {
                    s[l++] = b[BobEnd--];
                }
            }
        }
        pr(new String(s));
    }

    ///////////////////////////////////////////////////////////////
    /*
      wrong, like Bob shouldn't always put his max to first empty index
      if Alice has all chars > Bob's max  so Bob can use Alice's char, so Bob change to set last index
     */
    // WA TLE
    void solve2(int n, char[] a, char[] b) {
        int[] fa = new int[26], fb = new int[26];
        for (char c : a) fa[c - 'a']++;
        for (char c : b) fb[c - 'a']++;
        // tr(fa, fb);
        String s = "";
        for (int t = 0; t < 2 * n; t++) {
            if (t % 2 == 0) {
                for (int i = 0; i < 26; i++) {
                    if (fa[i] > 0) {
                        char c = (char) (i + 'a');
                        s += c;
                        fa[i]--;
                        break;
                    }
                }
            } else {
                for (int i = 25; i >= 0; i--) {
                    if (fb[i] > 0) {
                        char c = (char) (i + 'a');
                        s += c;
                        fb[i]--;
                        break;
                    }
                }
            }
        }
        pr(s);
    }

    void solve1(int n, char[] a, char[] b) {
        TreeMap<Character, Integer> ma = new TreeMap<>(), mb = new TreeMap<>();
        for (char c : a) addOneMap(ma, c);
        for (char c : b) addOneMap(mb, c);
        // tr(n, a, b, ma, mb);
        String s = "";
        for (int i = 0; i < 2 * n; i++) {
            if (i % 2 == 0) { // alice, lexicographically small
                char c = ma.firstKey();
                s += c;
                removeOneMap(ma, c);
            } else {
                char c = mb.lastKey();
                s += c;
                removeOneMap(mb, c);
            }
            // tr(ma, mb, s);
        }
        pr(s);
    }

    void addOneMap(TreeMap<Character, Integer> m, Character c) {
        m.put(c, m.getOrDefault(c, 0) + 1);
    }

    void removeOneMap(TreeMap<Character, Integer> m, Character c) {
        int occ = m.get(c);
        if (occ > 1) {
            m.put(c, occ - 1);
        } else {
            m.remove(c);
        }
    }

    private void run() {
        read_write_file(); // comment this before submission
        FastScanner fs = new FastScanner();
        int t = fs.nextInt();
        while (t-- > 0) {
            int n = fs.nextInt();
            char[] a = fs.next().toCharArray(), b = fs.next().toCharArray();
            solve(n, a, b);
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
        new StoneGame().run();
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
