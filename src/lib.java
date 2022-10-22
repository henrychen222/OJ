/**
 * 09/05/21 created
 */

import java.util.*;

public class lib {

    //////////////////// Map ////////////////////////////////
    Map<Integer, Integer> counter(int[] a) {
        Map<Integer, Integer> m = new HashMap<>();
        for (int x : a) m.put(x, m.getOrDefault(x, 0) + 1);
        return m;
    }

    <T> void addOneOrManyMap(TreeMap<T, Integer> m, T x, int... args) {
        int cnt = args.length == 0 ? 1 : args[0];
        m.put(x, m.getOrDefault(x, 0) + cnt);
    }

    <T> void removeOneOrManyMap(TreeMap<T, Integer> m, T x, int... args) {
        int cnt = args.length == 0 ? 1 : args[0], occ = m.get(x);
        if (occ > cnt) {
            m.put(x, occ - cnt);
        } else {
            m.remove(x);
        }
    }

    Map<Integer, ArrayList<Integer>> counter_value_in_indexA_in(int[] a) {
        Map<Integer, ArrayList<Integer>> m = new HashMap<>();
        for (int i = 0; i < a.length; i++) m.computeIfAbsent(a[i], x -> new ArrayList<>()).add(i);
        return m;
    }

    ///////////////////////// Array //////////////////////////////////
    void sortArray(int[] a) {
        shuffleArray(a);
        Arrays.sort(a);
    }

    void shuffleArray(int[] a) {
        int n = a.length;
        Random rnd = new Random();
        for (int i = 0; i < n; i++) {
            int tmp = a[i];
            int randomPos = i + rnd.nextInt(n - i);
            a[i] = a[randomPos];
            a[randomPos] = tmp;
        }
    }

    //////////////////////////// Graph /////////////////////////////////////////
    List<List<Integer>> initializeGraph(int n) {
        List<List<Integer>> g = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            g.add(new ArrayList<>());
        }
        return g;
    }

    //////////////////////////// Pair /////////////////////////////////////////
    class Pair implements Comparable<Pair> {
        int first, second;

        Pair(int first, int second) {
            this.first = first;
            this.second = second;
        }

        @Override
        public int compareTo(Pair y) {
            if (first == y.first) return Integer.compare(second, y.second);
            return Integer.compare(first, y.first);
        }
    }

    ////////////////////////// lower_bound + upper_bound /////////////////////
    int lower_bound(int[] a, int x) {
        int low = 0, high = a.length;
        while (low < high) {
            int mid = low + high >>> 1;
            if (a[mid] < x) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        return low;
    }

    int upper_bound(int[] a, int x) {
        int low = 0, high = a.length;
        while (low < high) {
            int mid = low + high >>> 1;
            if (x < a[mid]) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }

    int lower_bound2(int[] a, int x) {
        int idx = Arrays.binarySearch(a, x);
        if (idx < 0) {
            return -idx - 1;
        }
        return idx;
    }
}
