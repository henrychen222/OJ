/**
 * 03/17/21 evening  03/21/21 night complete
 * https://www.codechef.com/COOK126C/problems/PASSWD
 */

package CodeChef.contest.COOK.JanuaryCookOff2021_126;

import java.util.*;
import java.io.*;
import static java.lang.System.out;

class Password {

	// Accepted --- 0.72sec
	void solve(String s) {
		Boolean lower, upper, digit, special;
		lower = upper = digit = special = false;
		int n = s.length();
		if (n < 10) {
			prs("NO");
			return;
		}
		for (int i = 0; i < n; i++) {
			char c = s.charAt(i);
			if (isLower(c))
				lower = true;
			if (isUpper(c)) {
				if (i != 0 && i != n - 1)
					upper = true;
			}
			if (isDigit(c)) {
				if (i != 0 && i != n - 1)
					digit = true;
			}
			if (isSpecial(c)) {
				if (i != 0 && i != n - 1)
					special = true;
			}
		}
		if (lower == false || upper == false || digit == false || special == false) {
			prs("NO");
			return;
		}
		prs("YES");
	}

	// Accepted --- 0.62sec
	void solve2(String s) {
		Boolean lower, upper, digit, special;
		lower = upper = digit = special = false;
		int n = s.length();
		if (n < 10) {
			prs("NO");
			return;
		}
		for (int i = 0; i < n; i++) {
			char c = s.charAt(i);
			if (isLower(c)) {
				lower = true;
				break;
			}
		}
		for (int i = 1; i < n - 1; i++) {
			char c = s.charAt(i);
			if (isUpper(c)) {
				upper = true;
				break;
			}
		}
		for (int i = 1; i < n - 1; i++) {
			char c = s.charAt(i);
			if (isDigit(c)) {
				digit = true;
				break;
			}
		}
		for (int i = 1; i < n - 1; i++) {
			char c = s.charAt(i);
			if (isSpecial(c)) {
				special = true;
				break;
			}
		}
		if (lower == false || upper == false || digit == false || special == false) {
			prs("NO");
			return;
		}
		prs("YES");
	}

	// Accepted --- 0.68sec
	// reference: https://www.codechef.com/viewsolution/43963396
	void solve3(String s) {
		int lower, upper, digit, special;
		lower = upper = digit = special = 0;
		int n = s.length();
		for (int i = 1; i < n - 1; i++) {
			char c = s.charAt(i);
			if (isLower(c))
				lower++;
			if (isUpper(c))
				upper++;
			if (isDigit(c))
				digit++;
			if (isSpecial(c))
				special++;
		}
		if (isLower(s.charAt(0)) || isLower(s.charAt(n - 1)))
			lower++;
		if (n >= 10 && lower > 0 && upper > 0 && digit > 0 && special > 0) {
			prs("YES");
			return;
		}
		prs("NO");
	}

////////////////////// fucking issue ///////////////////
	// out.println(isLower('#')); this is should false, but true
//	Boolean isLower(char c) {
//		if (Character.toLowerCase(c) == c)
//			return true;
//		return false;
//	}

//	Boolean isUpper(char c) {
//	if (Character.toUpperCase(c) == c)
//		return true;
//	return false;
//}

////////////////////////////// fast //////////////////////////////////////
//	Boolean isLower(char c) {
//		if (c >= 97 && c <= 122)
//			return true;
//		return false;
//	}
//
//	Boolean isUpper(char c) {
//		if (c >= 65 && c <= 90)
//			return true;
//		return false;
//	}
////////////////////////////////////////////////////////////////////
	
////////////////////////// Also Accepted 0.79sec //////////////////////////////////////////
	Boolean isLower(char c) {
		if (Character.isLowerCase(c))
			return true;
		return false;
	}

	Boolean isUpper(char c) {
		if (Character.isUpperCase(c))
			return true;
		return false;
	}
////////////////////////////////////////////////////////////////////
	Boolean isDigit(char c) {
//		if (c >= '0' && c <= '9')
//			return true;
		if (Character.isDigit(c))
			return true;
		return false;
	}

	Boolean isSpecial(char c) {
		if (c == '@' || c == '#' || c == '%' || c == '&' || c == '?')
			return true;
		return false;
	}

	private void run() {
		FastScanner fs = new FastScanner();
		int t = fs.nextInt();
		while (t-- > 0) {
			String s = fs.next();
			solve(s);
		}
	}

	public static void main(String[] args) {
		new Password().run();
	}

	void prni(int num) {
		out.println(num);
	}

	void prnl(long num) {
		out.println(num);
	}

	void prnd(double num) {
		out.println(num);
	}

	void prs(String s) {
		out.println(s);
	}

	void prc(char c) {
		out.println(c);
	}

	void prai(int[] a) {
		out.println(Arrays.toString(a));
	}

	void pral(long[] a) {
		out.println(Arrays.toString(a));
	}

	void prad(double[] a) {
		out.println(Arrays.toString(a));
	}

	void pras(String[] a) {
		out.println(Arrays.toString(a));
	}

	void prac(char[] a) {
		out.println(Arrays.toString(a));
	}

	void prdai(int[][] a) {
		out.println(Arrays.deepToString(a));
	}

	void prdal(long[][] a) {
		out.println(Arrays.deepToString(a));
	}

	void prdad(double[][] a) {
		out.println(Arrays.deepToString(a));
	}

	void prdas(String[][] a) {
		out.println(Arrays.deepToString(a));
	}

	void prdac(char[][] a) {
		out.println(Arrays.deepToString(a));
	}

	void prli(List<Integer> l) {
		out.println(l);
	}

	void prll(List<Long> l) {
		out.println(l);
	}

	void prld(List<Double> l) {
		out.println(l);
	}

	void prls(List<String> l) {
		out.println(l);
	}

	void prlc(List<Character> l) {
		out.println(l);
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
			for (int i = 0; i < n; i++)
				a[i] = nextInt();
			return a;
		}

		long nextLong() {
			return Long.parseLong(next());
		}
	}
}