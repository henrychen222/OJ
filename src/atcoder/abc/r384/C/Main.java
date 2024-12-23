/**
 * 12/14/24 morning
 * https://atcoder.jp/contests/abc384/tasks/abc384_c
 */
package atcoder.abc.r384.C;

import java.util.*;
import java.io.*;

// Accepted
class Main {
    static PrintWriter pw;

    Map<String, Integer> m;

    int cal(String s, int[] a) {
        int score = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == 'A') {
                score += a[0];
            } else if (c == 'B') {
                score += a[1];
            } else if (c == 'C') {
                score += a[2];
            } else if (c == 'D') {
                score += a[3];
            } else if (c == 'E') {
                score += a[4];
            }
        }
        return score;
    }

    void sortMapByValue(Map<String, Integer> map) {
        List<Map.Entry<String, Integer>> data = new ArrayList<>(map.entrySet());
        data.sort((x, y) -> {
            if (!x.getValue().equals(y.getValue())) return y.getValue().compareTo(x.getValue());
            return x.getKey().compareTo(y.getKey()); // lexicographically smaller
        });
        data.forEach(e -> pr(e.getKey()));
    }

    private void run() {
        read_write_file(); // comment this before submission
        FastScanner fs = new FastScanner();
        int[] a = fs.readArray(5);
        m = new HashMap<>() {{
            put("ABCDE", cal("ABCDE", a));
            put("BCDE", cal("BCDE", a));
            put("ACDE", cal("ACDE", a));
            put("ABDE", cal("ABDE", a));
            put("ABCE", cal("ABCE", a));
            put("ABCD", cal("ABCD", a));
            put("CDE", cal("CDE", a));
            put("BDE", cal("BDE", a));
            put("ADE", cal("ADE", a));
            put("BCE", cal("BCE", a));
            put("ACE", cal("ACE", a));
            put("BCD", cal("BCD", a));
            put("ABE", cal("ABE", a));
            put("ACD", cal("ACD", a));
            put("ABD", cal("ABD", a));
            put("ABC", cal("ABC", a));
            put("DE", cal("DE", a));
            put("CE", cal("CE", a));
            put("BE", cal("BE", a));
            put("CD", cal("CD", a));
            put("AE", cal("AE", a));
            put("BD", cal("BD", a));
            put("AD", cal("AD", a));
            put("BC", cal("BC", a));
            put("AC", cal("AC", a));
            put("AB", cal("AB", a));
            put("E", cal("E", a));
            put("D", cal("D", a));
            put("C", cal("C", a));
            put("B", cal("B", a));
            put("A", cal("A", a));
        }};
        sortMapByValue(m);
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
        new Main().run();
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