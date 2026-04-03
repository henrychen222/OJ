/**
 * 12/25/24 morning
 * https://www.codechef.com/START166C/problems/COSTPERM
 */
package codechef.contest.start.y2024.c166;

import java.util.*;
import java.io.*;

class CostlyPermutations {
    static PrintWriter pw;

    // Accepted

    /*
    1
    5
    3 2 5 4 1

     cycles        [1->3->5->1] [2->2] [4->4]
     cycle length  3 1 1

     initial heap: [1,1,3]
     merge 1+1=2, cost=2   [2, 3]
     merge 2+3=5, cost=5   [7]
     */
    void solve(int[] a) {
       long res = costlyPermutations(a);
       pr(res);
    }

    List<List<Integer>> findCycles(int[] P) {
        int N = P.length;
        boolean[] visited = new boolean[N];
        List<List<Integer>> cycles = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            if (!visited[i]) {
                List<Integer> cycle = new ArrayList<>();
                int current = i;
                while (!visited[current]) {
                    visited[current] = true;
                    cycle.add(current);
                    current = P[current] - 1; // 1-based to 0-based index
                }
                cycles.add(cycle);
            }
        }
        return cycles;
    }

    // Main method to compute the minimum cost
    long costlyPermutations(int[] P) {
        List<List<Integer>> cycles = findCycles(P);
        List<Integer> cycleLengths = new ArrayList<>();

        for (List<Integer> cycle : cycles) {
            cycleLengths.add(cycle.size());
        }

        // Greedy approach to merge cycles
        PriorityQueue<Integer> minHeap = new PriorityQueue<>(cycleLengths);
        long totalCost = 0;

        while (minHeap.size() > 1) {
            // Take the two smallest cycles
            int smallest = minHeap.poll();
            int secondSmallest = minHeap.poll();

            // Merge them and calculate the cost
            int cost = smallest + secondSmallest;
            totalCost += cost;

            // Add the merged cycle back
            minHeap.add(smallest + secondSmallest);
        }
        return totalCost;
    }

    private void run() {
        read_write_file();
        FastScanner fs = new FastScanner();
        int t = fs.nextInt();
        while (t-- > 0) {
            int n = fs.nextInt();
            int[] a = fs.readArray(n);
            solve(a);
        }
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
        new CostlyPermutations().run();
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

