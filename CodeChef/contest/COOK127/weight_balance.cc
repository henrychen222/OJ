/**
 * 03/21/21 noon
 * https://www.codechef.com/COOK127C/problems/WEIGHTBL
 */

#include <bits/stdc++.h>
using namespace std;

// Accepted --- 0.26 sec
int main () {
	int t;
	cin >> t;
	while (t--) {
		int w1, w2, x1, x2, M;
		cin >> w1 >> w2 >> x1 >> x2 >> M;
		int min = x1 * x2;
		int max = x2 * M;
		int increase = w2 - w1;
		if (increase < min || increase > max) {
			cout << 0 << '\n';
		} else {
			cout << 1 << '\n';
		}
		
	}
	return 0;
}