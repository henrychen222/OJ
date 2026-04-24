/**
 * 04/11/26 night
 * https://codeforces.com/problemset/problem/75/B
 */
package codeforce.practice.L1500;

import java.util.*;
import java.io.*;

public class B75 {
    static PrintWriter pw;

    // Accepted --- https://codeforces.com/problemset/submission/75/370775191
    private void run() throws IOException {
        read_write_file();
        FastScanner fs = new FastScanner();
        String me = fs.next();
        int n = fs.nextInt();
        Map<String, Integer> m = new HashMap<>();
        for (int i = 0; i < n; i++) {
            String[] a = fs.nextLine().split(" ");
            String x = a[0], y = a.length == 5 ? a[3] : a[2];
            y = y.substring(0, y.length() - 2);
//            tr(x, y, me);
            if (x.equals(me)) { // only add points when related to me
                if (y.equals(me)) {
                } else {
                    operate(y, m, a[1]);
                }
            } else {
                if (y.equals(me)) {
                    operate(x, m, a[1]);
                } else { // not related to me, add person to the record but no points
                    m.merge(x, 0, Integer::sum);
                    m.merge(y, 0, Integer::sum);
                }
            }
        }
        m.remove(me);
        m = sortMapByValue(m);
//        tr(m);
        for (String k : m.keySet()) pr(k);
    }

    void operate(String x, Map<String, Integer> m, String mark) {
        if (mark.equals("posted")) {
            m.merge(x, 15, Integer::sum);
        } else if (mark.equals("commented")) {
            m.merge(x, 10, Integer::sum);
        } else {
            m.merge(x, 5, Integer::sum);
        }
    }

    Map<String, Integer> sortMapByValue(Map<String, Integer> map) {
        List<Map.Entry<String, Integer>> data = new ArrayList<>(map.entrySet());
        data.sort((a, b) -> {
            if (!a.getValue().equals(b.getValue())) return Integer.compare(b.getValue(), a.getValue());
            return a.getKey().compareTo(b.getKey()); // lexicographical
        });
        Map<String, Integer> sortedHashMap = new LinkedHashMap<>();
        for (var entry : data) {
            sortedHashMap.put(entry.getKey(), entry.getValue());
        }
        return sortedHashMap;
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

    public static void main(String[] args) throws IOException {
        pw = new PrintWriter(System.out);
        new B75().run();
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

        String nextLine() throws IOException {
            return br.readLine();
        }
    }

    void tr(Object... o) {
        pw.println(Arrays.deepToString(o));
    }
}