/**
 * 04/10/21 noon
 * https://arena.topcoder.com/index.html#/u/coding/18605/13428/1
 */

package TopCoder.contest.RookieSRM_4;

import java.util.*;
import java.util.Map.Entry;

import static java.lang.System.out;

public class MarblePicking {
		  
	public static Map<Character, Integer> sortMapByValues(Map<Character, Integer> map) {
		List<Entry<Character, Integer>> data = new ArrayList<>(map.entrySet());
		Collections.sort(data, new Comparator<Entry<Character, Integer>>() {
			public int compare(Entry<Character, Integer> o1, Entry<Character, Integer> o2) {
				return o2.getValue().compareTo(o1.getValue());
			}
		});
		Map<Character, Integer> sortedHashMap = new LinkedHashMap<>();
		for (Iterator<Entry<Character, Integer>> it = data.iterator(); it.hasNext();) {
			Map.Entry<Character, Integer> entry = it.next();
			sortedHashMap.put(entry.getKey(), entry.getValue());
		}
		return sortedHashMap;
	}
	
	// Accepted, System test failed
	public int fewestColors(String[] marbles, int cnt) {
		Map<Character, Integer> m = new HashMap<>();
		for (String s: marbles) {
			int n = s.length();
			for (int i = 0; i < n; i++) {
				char c = s.charAt(i);
				m.put(c, m.getOrDefault(c, 0) + 1);
			}
		}
		// out.println(m);
		Map<Character, Integer> nm = sortMapByValues(m);
		// out.println(nm + " " + cnt);
		int res = 0;
		int sum = 0;
		for (int occ: nm.values()) {
			if (sum >= cnt) break;
		    sum += occ;
		    res++;
		    // if (sum >= cnt) break;  issue
		}
		return res;
	}
	
	public static void main(String[] args) {
		MarblePicking t = new MarblePicking();
		String[] marbles = {"AABBCC"};
		int cnt = 3;
		String[] marbles2 = {"ABC","ABC"};
		int cnt2 = 2;
		String[] marbles3 = {"AAABBBCCCDDDDE"};
		int cnt3 = 4;
		String[] marbles4 = {"AAABBBCCCDDDDE"};
		int cnt4 = 10;
	    out.println(t.fewestColors(marbles, cnt)); // 2
	    out.println(t.fewestColors(marbles2, cnt2)); // 1
	    out.println(t.fewestColors(marbles3, cnt3)); // 1
	    out.println(t.fewestColors(marbles4, cnt4)); // 3
	    
	    
	    String[] marbles_sys_test1 = {"A"};
		int cnt_sys_test1 = 0;
		out.println(t.fewestColors(marbles_sys_test1, cnt_sys_test1));
	}

}
