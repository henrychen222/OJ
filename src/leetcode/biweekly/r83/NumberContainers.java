/**
 * 07/27/22 night
 * https://leetcode.com/contest/biweekly-contest-83/problems/design-a-number-container-system/
 */
package leetcode.biweekly.r83;

import java.util.*;

// Accepted --- 153ms
public class NumberContainers {
    Map<Integer, Integer> im;
    Map<Integer, TreeSet<Integer>> vm;

    public NumberContainers() {
        im = new HashMap<>();
        vm = new HashMap<>();
    }

    public void change(int index, int number) {
        // tr("change", index, number);
        vm.computeIfAbsent(number, x -> new TreeSet<>()).add(index);
        if (im.containsKey(index)) { // remove old number's index
            int oldNumber = im.get(index);
            if (oldNumber != number) vm.get(oldNumber).remove(index);
        }
        im.put(index, number);
        // tr("value map", vm, "index map", im);
    }

    public int find(int number) {
        if (!vm.containsKey(number) || vm.get(number).size() == 0) return -1;
        return vm.get(number).first();
    }

    public static void main(String[] args) {
        NumberContainers nc = new NumberContainers();
        pr(nc.find(10)); // -1
        nc.change(2, 10);
        nc.change(1, 10);
        nc.change(3, 10);
        nc.change(5, 10);
        pr(nc.find(10)); // 1
        nc.change(1, 20);
        pr(nc.find(10)); // 2

        pr("");
        NumberContainers debug1 = new NumberContainers();
        debug1.change(1, 10);
        pr(debug1.find(10));
        debug1.change(1, 20);
        pr(debug1.find(10));
        pr(debug1.find(20));
        pr(debug1.find(30));

        pr("");
        NumberContainers debug2 = new NumberContainers();
        debug2.change(1, 10);
        debug2.change(1, 10);
        pr(debug2.find(10)); // 1
        debug2.change(1, 20);
        pr(debug2.find(10)); // -1
    }

    static <T> void pr(T t) {
        System.out.println(t);
    }

    static void tr(Object... o) {
        System.out.println(Arrays.deepToString(o));
    }
}