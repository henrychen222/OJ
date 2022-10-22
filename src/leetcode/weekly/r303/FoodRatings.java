/**
 * 07/23/22 night
 * https://leetcode.com/contest/weekly-contest-303/problems/design-a-food-rating-system/
 */
package leetcode.weekly.r303;

import java.util.*;

// Accepted --- 420ms reference: kmjp
public class FoodRatings {
    int n;
    Map<String, TreeSet<Node>> cm;
    Map<String, String> fm;
    Map<String, Integer> rm;

    public FoodRatings(String[] foods, String[] cuisines, int[] ratings) {
        n = foods.length;
        cm = new HashMap<>(); // cuisine -> Node
        fm = new HashMap<>(); // food -> cuisine
        rm = new HashMap<>(); // food -> rating
        for (int i = 0; i < n; i++) {
            fm.put(foods[i], cuisines[i]);
            rm.put(foods[i], ratings[i]);
            cm.computeIfAbsent(cuisines[i], x -> new TreeSet<>()).add(new Node(ratings[i], foods[i]));
        }
//        debugNode(cm);
//        tr("food map", fm);
//        tr("rating map", rm);
    }

    public void changeRating(String food, int newRating) {
        String cuisine = fm.get(food);
        cm.get(cuisine).remove(new Node(rm.get(food), food));
        rm.put(food, newRating);
        cm.get(cuisine).add(new Node(rm.get(food), food));
    }

    public String highestRated(String cuisine) {
        return cm.get(cuisine).first().name;
    }

    class Node implements Comparable<Node> {
        int rate;
        String name;

        Node(int rate, String name) {
            this.rate = rate;
            this.name = name;
        }

        @Override
        public int compareTo(Node y) {
            if (rate == y.rate) return name.compareTo(y.name); // same rating, lexical smaller comes first
            return Integer.compare(y.rate, rate); // higher rating comes first
        }
    }

    void debugNode(Map<String, TreeSet<Node>> cm) {
        Map<String, List<String>> m = new HashMap<>();
        for (String e : cm.keySet()) {
            TreeSet<Node> ts = cm.get(e);
            List<String> l = new ArrayList<>();
            for (Node node : ts) l.add(node.rate + " " + node.name);
            m.put(e, l);
        }
        tr(m);
    }

    public static void main(String[] args) {
        FoodRatings foodRatings = new FoodRatings(new String[]{"kimchi", "miso", "sushi", "moussaka", "ramen", "bulgogi"}, new String[]{"korean", "japanese", "japanese", "greek", "japanese", "korean"}, new int[]{9, 12, 8, 15, 14, 7});
        tr(foodRatings.highestRated("korean")); // "kimchi"
        tr(foodRatings.highestRated("japanese")); // "ramen"
        foodRatings.changeRating("sushi", 16);
        tr(foodRatings.highestRated("japanese")); // "sushi"
        foodRatings.changeRating("ramen", 16);
        tr(foodRatings.highestRated("japanese")); // "ramen"
    }

    static void tr(Object... o) {
        System.out.println(Arrays.deepToString(o));
    }
}
