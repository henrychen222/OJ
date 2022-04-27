// 03/11/22 night

#include <iostream>
#include <cstdio>
#include <cstdlib>
#include <algorithm>
#include <cmath>
#include <vector>
#include <array>
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

// Accepted --- https://codeforces.com/contest/1651/submission/149407028
void run () {
	int n;
	cin >> n;
	int dx[] = {1, -1, 0, 0}, dy[] = {0, 0, 1, -1};
	vector<array<int, 2>> a(n);
	map<array<int, 2>, int> m;
	for (int i = 0; i < n; ++i) {
		cin >> a[i][0] >> a[i][1];
		m[a[i]] = i;
	}
	queue<array<int, 2>> q;
	map<array<int, 2>, array<int, 2>> source;
	vector<array<int, 2>> res(n);
	for (auto [x, y] : a) {
		for (int k = 0; k < 4; k++) {
			int nx = x + dx[k], ny = y + dy[k];
			array<int, 2> nextP = {nx, ny};
			if (!m.count(nextP)) {
				source[nextP] = {nextP};
				q.push(nextP);
				break;
			}
		}
	}
	int cnt = 0;
	while (!q.empty()) {
		auto [x, y] = q.front();
		q.pop();
		array<int, 2> curP = {x, y};
		for (int k = 0; k < 4; k++) {
			int nx = x + dx[k], ny = y + dy[k];
			array<int, 2> nextP = {nx, ny};
			if (source.count(nextP)) continue;
			source[nextP] = source[curP];
			if (m.count(nextP)) {
				res[m[nextP]] = source[nextP];
				cnt++;
			}
			if (cnt == n) {
				for (auto e: res) cout << e[0] << " " << e[1] << '\n';
				return;
			}
			q.push({nx, ny});
		}
	}
}

int main () {
	ios::sync_with_stdio(false);
	cin.tie(nullptr);
	run();
	return 0;
}