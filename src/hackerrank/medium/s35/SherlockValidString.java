/**
 * 08/26/22 night 05/02/26 night
 * https://www.hackerrank.com/challenges/sherlock-and-valid-string/problem
 */
package hackerrank.medium.s35;

import java.util.*;
import java.io.*;
import java.util.stream.Collectors;

// Accepted --- https://www.hackerrank.com/challenges/sherlock-and-valid-string/submissions/code/471229510
public class SherlockValidString {
    static PrintWriter pw;

    /*
    aabbc  YES
     */
    void solve(char[] s) {
        Map<Character, Integer> m = new HashMap<>();
        for (char c : s) m.merge(c, 1, Integer::sum);
        if (check(m)) {
            pr("YES");
            return;
        }
        m = sortMapByValueDec(m);
//        tr(m);
        char first = m.keySet().iterator().next();
        // Case 1: Remove one occurrence from the most frequent character.
        m.merge(first, -1, Integer::sum); // highest -1 all occurrence should be the same
        if (check(m)) {
            pr("YES");
            return;
        }
        // Case 2: Remove one occurrence from the least frequent character(the char with frequency 1)
        m.merge(first, 1, Integer::sum); // recover
        m = sortMapByValueInc(m);
//        tr(m);
        char last = m.keySet().iterator().next();
        removeOneOrManyMap(m, last); // should totally remove if it is zero occurrence
        pr(check(m) ? "YES" : "NO");
    }

    boolean check(Map<Character, Integer> m) {
        Map<Integer, Integer> cntMap = new HashMap<>();
        for (int x : m.values()) cntMap.merge(x, 1, Integer::sum);
        return cntMap.size() == 1;
    }

    Map<Character, Integer> sortMapByValueDec(Map<Character, Integer> map) {
        return map.entrySet().stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        Map.Entry::getValue,
                        (a, b) -> a,
                        LinkedHashMap::new
                ));
    }

    Map<Character, Integer> sortMapByValueInc(Map<Character, Integer> map) {
        return map.entrySet().stream()
                .sorted(Map.Entry.comparingByValue())
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        Map.Entry::getValue,
                        (a, b) -> a,
                        LinkedHashMap::new
                ));
    }

    <T> void removeOneOrManyMap(Map<T, Integer> m, T x, int... args) {
        int cnt = args.length == 0 ? 1 : args[0];
        m.merge(x, -cnt, Integer::sum);
        if (m.get(x) == 0) {
            m.remove(x);
        }
    }

    private void run() throws IOException {
        read_write_file(); // comment this before submission
        FastScanner fs = new FastScanner();
        char[] s = fs.readLine().toCharArray();
        solve(s);
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
        } catch (Exception ignore) {
        }
    }

    public static void main(String[] args) throws IOException {
        pw = new PrintWriter(System.out);
        new SherlockValidString().run();
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
                } catch (IOException ignore) {
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
