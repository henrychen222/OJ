// 05/31/21 night

#include <iostream>
#include <cstdio>
#include <cstdlib>
#include <algorithm>
#include <cmath>
#include <vector>
#include <set>
#include <map>
#include <unordered_set>
#include <unordered_map>
#include <queue>
#include <ctime>
#include <cassert>
#include <complex>
#include <string>
#include <cstring>
#include <chrono>
#include <random>
#include <bitset>
using namespace std;

typedef long long ll;

ll check(int x, int y) {
	return x == y ? 2LL : 1LL;
}

ll findSum(string s, int i) {
	if (i == 0)
		return check(s[i + 1], s[i]);
	else if (i == s.length() - 1)
		return check(s[i], s[i - 1]);
	else
		return check(s[i], s[i - 1]) + check(s[i], s[i + 1]);
}

// Accepted --- 0.59sec https://www.codechef.com/viewsolution/47291109
void run () {
	int n, k;
	cin >> n >> k;
	string s;
	cin >> s;
	vector<int> query(k);
	for (int i = 0; i < k; i++) cin >> query[i];
	if (n == 1) {
		cout << 0 << '\n';
		return;
	}
	ll TotalDis = 0;
	for (int i = 0; i < n - 1; i++) {
		TotalDis += check(s[i], s[i + 1]);
	}
	for (int i = 0; i < k; i++) {
		int index = query[i] - 1;
		TotalDis -= findSum(s, index);
		s[index] ^= 1;
		TotalDis += findSum(s, index);
		cout << TotalDis << '\n';
	}
}

void read_write_file () {
	freopen("input.txt", "r", stdin);
	freopen("output.txt", "w", stdout);
}

int main () {
	read_write_file();
	ios::sync_with_stdio(false);
	cin.tie(nullptr);
	int t;
	cin >> t;
	while (t--) run();
	return 0;
}
