/**
 * 04/15/21 morning
 * https://www.codechef.com/SPYB21B/problems/GOTHAM
 */
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

// void print_array(int a[], int n) {
// 	for (int i = 0; i < n; i++) cout << a[i] << ' ';
// 	cout << endl;
// }

// TLE
void run (int n, int a[], int cnt[], int x, int k) {
	int res = 0;
	int start = x - 1;
	for (int i = start; i < n && k > 0; i++) {
		if (cnt[i] == a[i]) continue;
		if (cnt[i] + k <= a[i]) {
			cnt[i] += k;
			res += (i - start) * k;
			k = 0;
		} else {
			cnt[i] = a[i];
			res += (i - start) * a[i];
			k -= a[i];
		}
	}
	cout << res << '\n';
}

void read_write_file () {
	freopen("input.txt", "r", stdin);
	freopen("output.txt", "w", stdout);
}

int main () {
	read_write_file();
	ios::sync_with_stdio(false);
	cin.tie(nullptr);
	int n, q, x, k;
	cin >> n;
	int a[n];
	int cnt[n];
	for (int i = 0; i < n; i++) {
		cin >> a[i];
		cnt[i] = 0;
	}
	cin >> q;
	while (q--) {
		cin >> x >> k;
		run(n, a, cnt, x, k);
	}
	return 0;
}