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

// Accepted --- 0.02sec https://www.codechef.com/viewsolution/47290474
ll findSum(string s) {
	int n = s.length();
	// cout << s << " " << n << endl;
	ll sum = 0LL;
	for (int i = 0; i + 1 < n; i++) {
		if (s[i] == s[i + 1]) {
			sum += 2LL;
		} else {
			sum++;
		}
	}
	return sum;
}

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
	ll TotalDis = findSum(s);
	// cout << "dis " << TotalDis << endl;
	for (int e : query) {
		int index = e - 1;
		if (index == 0) {
			TotalDis -= findSum(s.substr(index, 2));
			s[index] ^= 1;
			TotalDis += findSum(s.substr(index, 2));
			// cout << "1 " << TotalDis << '\n';
		} else if (index == n - 1) {
			TotalDis -= findSum(s.substr(index - 1, 2));
			s[index] ^= 1;
			TotalDis += findSum(s.substr(index - 1, 2));
			// cout << "2 " << TotalDis << '\n';
		} else {
			TotalDis -= findSum(s.substr(index - 1, 3));
			s[index] ^= 1;
			TotalDis += findSum(s.substr(index - 1, 3));
			// cout << "3 " << TotalDis << '\n';
		}
		// cout << s << '\n';
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
