/**
 * 03/28/21 morning
 * https://atcoder.jp/contests/arc116/tasks/arc116_a
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

typedef long long ll;

// Accepted --- 299ms
// reference: https://www.geeksforgeeks.org/check-if-count-of-even-divisors-of-n-is-equal-to-count-of-odd-divisors/
void run () {
	ll n;
	cin >> n;
	ll res = (n - 2) % 4;
	// cout << res << endl;
    if (res == 0) {
    	cout << "Same" << endl;
    } else if (res & 1) {
    	cout << "Odd" << endl;
    } else {
    	cout << "Even" << endl;
    }
}

void read_write_file () {
	freopen("input.txt", "r", stdin);
	freopen("output.txt", "w", stdout);
}

int main () {
	read_write_file();
	ios::sync_with_stdio(false); // not wrote this 364ms
	cin.tie(nullptr);
	int t;
	cin >> t;
	while (t--) run();
	return 0;
}