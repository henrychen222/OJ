/**
 * 03/21/21 noon
 * https://www.codechef.com/cook127c/problems/guessit
 */

#include <bits/stdc++.h>
using namespace std;


// WA
// void run () {
// 	unordered_set<int> se;
// 	while (1) {
// 		// for (int i = 1; i <= 2000; i++) {
// 		int guess = rand() % 1000000 + 1;
// 		if (se.count(guess)) continue;
// 		se.emplace(guess);
// 		cout << guess << '\n';
// 		fflush(stdout);
// 		int response;
// 		cin >> response;
// 		fflush(stdout);
// 		if (response == 0 || response == -1) continue;
// 		return;
// 	}
// }

// Accepted --- 0.09sec
// reference: https://www.geeksforgeeks.org/number-elements-odd-factors-given-range/
void run () {
	for (int i = 1, j = 1; i * i <= 1e6 && j <= 2000; i++, j++) {
		int guess = i * i;
		cout << guess << '\n';
		fflush(stdout);
		int response;
		cin >> response;
		fflush(stdout);
		if (response == 0 || response == -1) continue;
		return;
	}
}

int main () {
	int t;
	cin >> t;
	while (t--) run();
	return 0;
}