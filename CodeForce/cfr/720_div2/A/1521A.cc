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

ll MAX = pow(10, 18);
void run () {
	ll a, b;
	cin >> a >> b;
    ll p = a * b;
    for (ll z = p; z <= MAX; z *= p) {
        for (ll x = a; x < z; x *= a) {
            ll y = z - x;
            if (y % a == 0 && (y != x)) {
                cout << "YES" << '\n';
                cout << x << ' ' << y << ' ' << z << '\n';
                return;
            }
        }
    }
    cout << "NO" << '\n';
}

void read_write_file () {
	freopen("input.txt", "r", stdin);
	freopen("output.txt", "w", stdout);
}

int main () {
	// read_write_file();
	ios::sync_with_stdio(false);
	cin.tie(nullptr);
	int t;
	cin >> t;
	while (t--) run();
	return 0;
}
