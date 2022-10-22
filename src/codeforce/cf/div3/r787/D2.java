// 05/05/22 evening
package codeforce.cf.div3.r787;

import java.util.*;
import java.io.*;

public class D2 {
    static PrintWriter pw;

    // Accepted --- https://codeforces.com/contest/1675/submission/156028442
    // reference: jiangly
    void solve(int n, int[] p) {
        boolean[] leaf = new boolean[n + 1];
        Arrays.fill(leaf, true);
        for (int i = 0; i < n; i++) {
            if (i + 1 != p[i]) leaf[p[i]] = false;
        }
        List[] paths = MinimumNumberOfPathDG(n + 1, 1, leaf, p);
        // tr(paths);
        pr(Arrays.stream(paths).filter(Objects::nonNull).count());
        for (List path : paths) {
            if (path != null) {
                pr(path.size());
                outputL(path);
            }
        }
        pr("");
    }

    List[] MinimumNumberOfPathDG(int n, int start, boolean[] leaf, int[] p) {
        boolean[] visit = new boolean[n];
        List[] paths = new List[n];
        for (int i = start; i < n; i++) {
            if (leaf[i]) {
                List<Integer> path = new ArrayList<>();
                for (int parent = i; !visit[parent]; parent = p[parent - 1]) { // child -> parent
                    visit[parent] = true;
                    path.add(parent);
                }
                Collections.reverse(path);
                paths[i] = path;
            }
        }
        return paths;
    }

    List<List<Integer>> initializeGraph(int n) {
        List<List<Integer>> g = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            g.add(new ArrayList<>());
        }
        return g;
    }

    private void run() {
        read_write_file(); // comment this before submission
        FastScanner fs = new FastScanner();
        int t = fs.nextInt();
        while (t-- > 0) {
            int n = fs.nextInt();
            int[] p = fs.readArray(n);
            solve(n, p);
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
        new D2().run();
        pw.close();
    }

    <T> void pr(T t) {
        pw.println(t);
    }

    void outputL(List<Integer> l) {
        for (int e : l) pw.print(e + " ");
        pr("");
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