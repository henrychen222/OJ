/**
 * 10/31/21 night
 * https://codeforces.com/problemset/problem/43/A
 */
package codeforce.practice.L1000;

import java.util.*;
import java.io.*;

public class A43 {

    static PrintWriter pw;

    // Accepted --- https://codeforces.com/problemset/submission/43/133868884
    private void run() {
        read_write_file(); // comment this before submission
        FastScanner fs = new FastScanner();
        Map<String, Integer> m = new HashMap<>();
        int n = fs.nextInt();
        while (n-- > 0) {
            String s = fs.next();
            m.put(s, m.getOrDefault(s, 0) + 1);
        }
        m = sortMapByValue(m);
        pr(m.keySet().iterator().next());
    }

    Map<String, Integer> sortMapByValue(Map<String, Integer> map) {
        List<Map.Entry<String, Integer>> data = new ArrayList<>(map.entrySet());
        Collections.sort(data, (x, y) -> y.getValue().compareTo(x.getValue()));
        Map<String, Integer> sortedHashMap = new LinkedHashMap<>();
        for (Map.Entry<String, Integer> entry : data) {
            sortedHashMap.put(entry.getKey(), entry.getValue());
        }
        return sortedHashMap;
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
        new A43().run();
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