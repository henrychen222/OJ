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

typedef unsigned long long ll; // issue

// Accepted --- 05/07/26 evening https://www.luogu.com.cn/record/277073661
void run () {
	int n, m;
	cin >> n >> m;
	vector<ll> a(n), b(m);
	for (int i = 0; i < n; i++) cin >> a[i];
    for (int i = 0; i < m; i++) cin >> b[i];
    ll res = 0;
    int i = 0;
    for (ll x : a) {
        while (i < b.size() && b[i] < x) i++;
        int cnt = 0;
        while (i < b.size() && b[i] == x) {
            i++;
            cnt++;
        }
        res ^= cnt;
    }
    cout << res << '\n';
}

void read_write_file () {
	freopen("input.txt", "r", stdin);
	freopen("output.txt", "w", stdout);
}

int main () {
	// read_write_file(); // comment before submission
	ios::sync_with_stdio(false);
	cin.tie(nullptr); // comment for interactive problem
	int t;
	cin >> t;
	while (t--) run();
	return 0;
}