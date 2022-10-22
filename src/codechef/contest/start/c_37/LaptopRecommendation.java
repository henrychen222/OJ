/**
 * 05/04/22 morning
 * https://www.codechef.com/START37C/problems/LAPTOPREC
 */
package codechef.contest.start.c_37;

import java.util.*;
import java.io.*;

class LaptopRecommendation {
    static PrintWriter pw;

    // Accepted --- https://www.codechef.com/viewsolution/64230950
    // reference: https://discuss.codechef.com/t/aboveavg-editorial/100968
    void solve(int n, int[] a) {
        Map<Integer, Integer> m = counter(a);
        int maxOcc = Integer.MIN_VALUE, maxV = Integer.MIN_VALUE, cnt = 0;
        for (int k : m.keySet()) {
            if (m.get(k) > maxOcc) {
                maxOcc = m.get(k);
                maxV = k;
            }
        }
        for (int occ : m.values()) {
            if (occ == maxOcc) cnt++;
        }
        pr(cnt > 1 ? "CONFUSED" : maxV);
    }

    // WA one case failed
    // https://www.codechef.com/viewsolution/64182498
    // https://www.codechef.com/viewsolution/64174242
    void solve2(int n, int[] a) {
        Map<Integer, Integer> m = counter(a);
        if (m.size() == 1) {
            pr(a[0]);
            return;
        }
        m = sortMapByValue(m);
        List<Integer> d = new ArrayList<>();
        for (int occ : m.values()) d.add(occ);
        // tr(m, d);
        pr(d.get(0) == d.get(1) ? "CONFUSED" : m.keySet().iterator().next());
    }

    Map<Integer, Integer> sortMapByValue(Map<Integer, Integer> map) {
        List<Map.Entry<Integer, Integer>> data = new ArrayList<>(map.entrySet());
        Collections.sort(data, (a, b) -> b.getValue().compareTo(a.getValue()));
        Map<Integer, Integer> sortedHashMap = new LinkedHashMap<>();
        for (Map.Entry<Integer, Integer> entry : data) {
            sortedHashMap.put(entry.getKey(), entry.getValue());
        }
        return sortedHashMap;
    }

    Map<Integer, Integer> counter(int[] a) {
        Map<Integer, Integer> m = new HashMap<>();
        for (int x : a) m.put(x, m.getOrDefault(x, 0) + 1);
        return m;
    }

    // WA
    void solve1(int n, int[] a) {
        int[] f = new int[11];
        for (int x : a) f[x]++;
        int[][] d = new int[11][];
        for (int i = 0; i < 11; i++) d[i] = new int[]{f[i], i};
        Arrays.sort(d, (x, y) -> y[0] - x[0]);
        // tr(d);
        List<int[]> res = new ArrayList<>();
        for (int i = 10; i >= 0 && res.size() < 2; i--) {
            if (f[i] > 0) res.add(new int[]{f[i], i});
        }
        pr(res.get(0)[0] == res.get(1)[0] ? "CONFUSED" : res.get(0)[1]);
    }

    private void run() {
        read_write_file(); // comment this before submission
        FastScanner fs = new FastScanner();
        int t = fs.nextInt();
        while (t-- > 0) {
            int n = fs.nextInt();
            int[] a = fs.readArray(n);
            solve(n, a);
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
        new LaptopRecommendation().run();
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
