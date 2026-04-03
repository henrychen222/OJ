/**
 * 06/12/25 night
 * https://codeforces.com/problemset/problem/24/B
 */
package codeforce.practice.L1500;

import java.util.*;
import java.io.*;

// Accepted --- https://codeforces.com/problemset/submission/24/324219616
public class B24 {
    static PrintWriter pw;
    Map<String, Integer> OriginalRuleScoreCount = new HashMap<>(), AlternateRuleWinCount = new HashMap<>();
    Map<String, Integer>[] rankCount = MapInArray(51);

    private void run() {
        read_write_file();
        FastScanner fs = new FastScanner();
        int t = fs.nextInt();
        int[] order = {25, 18, 15, 12, 10, 8, 6, 4, 2, 1};

        while (t-- > 0) {
            int n = fs.nextInt();
            for (int i = 0; i < n; i++) {
                String s = fs.next();
                if (i < 10) addOneOrManyMap(OriginalRuleScoreCount, s, order[i]);
                addOneOrManyMap(rankCount[i], s, 1);
                if (i == 0) addOneOrManyMap(AlternateRuleWinCount, s, 1);
            }
        }
//        tr(rankCount);
//        tr(OriginalRuleScoreCount, AlternateRuleWinCount);
        OriginalRuleScoreCount = sortMapByValueOriginalRule(OriginalRuleScoreCount);
        AlternateRuleWinCount = sortMapByValueDesUseOriginalRuleIfTie(AlternateRuleWinCount);
//        tr(OriginalRuleScoreCount, AlternateRuleWinCount);
        pr(OriginalRuleScoreCount.keySet().iterator().next());
        pr(AlternateRuleWinCount.keySet().iterator().next());
    }

    <T> void addOneOrManyMap(Map<T, Integer> m, T x, int... args) {
        int cnt = args.length == 0 ? 1 : args[0];
        m.put(x, m.getOrDefault(x, 0) + cnt);
    }

    Map<String, Integer> sortMapByValueOriginalRule(Map<String, Integer> map) {
        List<Map.Entry<String, Integer>> data = new ArrayList<>(map.entrySet());
        Collections.sort(data, new HigherPointFirstThenWinCountUntilNoTieComparator());
        return new LinkedHashMap<>() {{
            for (var entry : data) {
                put(entry.getKey(), entry.getValue());
            }
        }};
    }

    Map<String, Integer> sortMapByValueDesUseOriginalRuleIfTie(Map<String, Integer> map) {
        List<Map.Entry<String, Integer>> data = new ArrayList<>(map.entrySet());
        Collections.sort(data, (x, y) -> {
            if (x.getValue().equals(y.getValue())) {
                if (!OriginalRuleScoreCount.get(y.getKey()).equals(OriginalRuleScoreCount.get(x.getKey()))) {
                    // If there is tie, champion is the one with most points
                    return Integer.compare(OriginalRuleScoreCount.get(y.getKey()), OriginalRuleScoreCount.get(x.getKey()));
                } else {
                    // Still tie, use original scoring system, same code
                    for (int i = 0; i < rankCount.length; i++) {
                        if (rankCount[i] != null) {
                            if (rankCount[i].containsKey(x.getKey())) {
                                if (rankCount[i].containsKey(y.getKey())) {
                                    if (!rankCount[i].get(y.getKey()).equals(rankCount[i].get(x.getKey()))) {
                                        // win count not equal compare
                                        return Integer.compare(rankCount[i].get(y.getKey()), rankCount[i].get(x.getKey()));
                                    }
                                } else {
                                    return -1;
                                }
                            } else {
                                if (rankCount[i].containsKey(y.getKey())) {
                                    return 1;
                                }
                            }
                        }
                    }
                    return 0;
                }
            }
            return Integer.compare(y.getValue(), x.getValue()); // most wins comes first
        });
        return new LinkedHashMap<>() {{
            for (var entry : data) {
                put(entry.getKey(), entry.getValue());
            }
        }};
    }

    class HigherPointFirstThenWinCountUntilNoTieComparator implements Comparator<Map.Entry<String, Integer>> {
        @Override
        public int compare(Map.Entry<String, Integer> x, Map.Entry<String, Integer> y) {
            if (x.getValue().equals(y.getValue())) {
                for (int i = 0; i < rankCount.length; i++) {
                    if (rankCount[i] != null) {
                        if (rankCount[i].containsKey(x.getKey())) {
                            if (rankCount[i].containsKey(y.getKey())) {
                                if (!rankCount[i].get(y.getKey()).equals(rankCount[i].get(x.getKey()))) {
                                    // win count not equal compare
                                    return Integer.compare(rankCount[i].get(y.getKey()), rankCount[i].get(x.getKey()));
                                }
                            } else {
                                return -1;
                            }
                        } else {
                            if (rankCount[i].containsKey(y.getKey())) {
                                return 1;
                            }
                        }
                    }
                }
                return 0;
            }
            return Integer.compare(y.getValue(), x.getValue()); // higher points comes first
        }
    }

    Map<String, Integer>[] MapInArray(int n) {
        Map<String, Integer>[] res = new HashMap[n];
        for (int i = 0; i < n; i++) res[i] = new HashMap<>();
        return res;
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
        new B24().run();
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
