// 03/05/21 night

#include <iostream>
#include <cmath>
using namespace std;

typedef long long ll;

// C++ 14: TLE SubTask 1 (0.00sec) + SubTask 2.3 (0.14sec) AC
// C++ 17: TLE SubTask 1 (0.00sec) + SubTask 2.3 (0.13sec) AC
// void solve (ll c) {
// 	ll d = 1LL * (log10(c) / log10(2) + 1);
//     ll tmp = 1 << d;
// 	if (tmp == c) d++;
// 	ll max = 1 << d;
// 	ll res = 0;
// 	ll mid = 0;
// 	if (max % 2 == 0) {
// 		mid = max / 2;
// 	} else {
// 		mid = max / 2 + 1;
// 	}
// 	for (ll a = 0; a <= mid; a++) {
// 		ll b = c ^ a;
// 		if (b >= mid && b <= max) {
// 				ll p = a * b;
// 				if (p > res) res = p;
// 			}
// 		}
//     cout << res << '\n';
// }


// C++ 17: TLE SubTask 1 (0.00sec) + SubTask 2.3 (0.14sec) AC
// void solve (ll c) {
// 	ll d = 1LL * (log10(c) / log10(2) + 1);
//     ll tmp = 1 << d;
// 	if (tmp == c) d++;
// 	ll max = 1 << d;
// 	ll res = 0;
// 	ll mid = 0;
// 	if (max % 2 == 0) {
// 		mid = max / 2;
// 	} else {
// 		mid = max / 2 + 1;
// 	}
// 	for (ll a = 0; a <= mid; a++) {
// 		ll b = c ^ a;
//         if (b < mid || b > max) continue;
//         ll p = a * b;
// 		if (p > res) res = p;
//     }
//     cout << res << '\n';
// }


// C++ 17: TLE SubTask 1 (0.00sec) + SubTask 2.3 (0.09sec) AC
void solve (ll c) {
    ll d = 0;
	for (ll i = 0; i < c; i++) {
			ll tmp = 1 << i;
		if (tmp == c) {
			d = i + 1;
			break;
		} else if (tmp > c){
			d = i;
			break;
		}
	}
	ll max = 1 << d;
	ll res = 0;
	ll mid = 0;
	if (max % 2 == 0) {
		mid = max / 2;
	} else {
		mid = max / 2 + 1;
	}
	for (ll a = 0; a <= mid; a++) {
		ll b = c ^ a;
        if (b < mid || b > max) continue;
        ll p = a * b;
		if (p > res) res = p;
    }
    cout << res << '\n';
}

int main() {
    ios::sync_with_stdio(false);
    int t;
    cin >> t;
    while (t--) {
       ll c;
       cin >> c;
       solve(c);
    }
}