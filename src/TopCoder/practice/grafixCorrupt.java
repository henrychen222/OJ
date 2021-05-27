/**
 * 04/10/21 morning
 * https://arena.topcoder.com/index.html#/u/practiceCode/1417/2770/2997/2/1417
 */

package TopCoder.practice;

import java.util.*;
import static java.lang.System.out;

public class grafixCorrupt {

	// Accepted 275.04 points
	public int selectWord(String[] dic, String cand) {
		int n = dic.length;
		int cn = cand.length();
		int[] cnt = new int[n];
		int max = 0;
		for (int i = 0; i < n; i++) {
			String s = dic[i];
			int ct = 0;
			for (int j = 0; j < cn; j++) {
				if (s.charAt(j) == cand.charAt(j)) ct++;
			}
			max = Math.max(max, ct);
			cnt[i] = ct;
		}
//		out.println(Arrays.toString(cnt));
//		out.println(max);
		if (max == 0) return -1;
		for (int i = 0; i < n; i++) {
			if (cnt[i] == max) return i;
		}
		return -1;
	}

	public static void main(String[] args) {
		grafixCorrupt t = new grafixCorrupt();
		String[] dictionary = { "cat", "cab", "lab" };
		String candidate = "dab";
		String candidate2 = "lag";
		String candidate3 = "bic";
		String[] dictionary2 = { "zkv", "izs", "fed", "waa", "ttx", "bgt", "quy", "dtq", "dgo", "yrs", "cid", "nln",
				"pvz", "txt", "zun", "erd", "jen", "klh", "kxy", "emf", "mqt", "lza", "dzb", "ndx", "vfr", "jhs", "dkm",
				"elb" };
		String candidate4 = "cwd";
		String[] dictionary3 = { "zhadjsg", "vzptftx", "fbaslxs", "ejejncm", "xpxkeae", "ixrrtzw", "ovctbzx", "sfzekhh",
				"lxzixjk", "jixdpik", "bkianck", "laclyin", "uqmdkfx", "dimswqo", "fojhetr", "grntrce", "obdtqwx",
				"bhojwcy", "zuuuvst", "mvqtoly", "aftmupx", "govuidx", "qklpret", "yptccki", "uxdnslh", "wudrusz",
				"uwxbvou", "ouytqun", "pjdexqe", "xraaqdw", "lxmoncl", "sjnjfgb", "qrlqgvc", "fgvoadm", "yohsrxw",
				"udpvrsr", "mklucgt" };
		String candidate5 = "vklikgf";
		out.println(t.selectWord(dictionary, candidate));
		out.println(t.selectWord(dictionary, candidate2));
		out.println(t.selectWord(dictionary, candidate3));
		out.println(t.selectWord(dictionary2, candidate4));
		out.println(t.selectWord(dictionary3, candidate5));
	}

}
