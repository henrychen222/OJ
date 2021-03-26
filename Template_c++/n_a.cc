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

void run () {
	int n;
	cin >> n;
	vector<int> a(n);
	// vector<ll> a(n);
	for (int i = 0; i < n; i++) cin >> a[i];
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