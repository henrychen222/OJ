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

void read_write_file () {
	freopen("input.txt", "r", stdin);
	freopen("output.txt", "w", stdout);
}

/*
Accepted
https://codeforces.com/contest/1867/submission/223260496
https://codeforces.com/contest/1867/submission/223259569
https://codeforces.com/contest/1867/submission/223259180
*/
int main () {
	read_write_file();
	ios::sync_with_stdio(false);
	// cin.tie(nullptr);
	int t;
	cin >> t;
	while (t--) {
        int n;
        cin >> n;
        vector<int> a(n);
        for (int i = 0; i < n; i++) cin >> a[i];
        sort(a.begin(), a.end());
        int mex = 0;
        for (int x: a) {
            if (x == mex) mex++;
        }
        while (1) {
            cout << mex << '\n';
            int y;
            cin >> y;
            if (y < 0) {
                break;
            } else {
               mex = y;
            }
        }
    }
	return 0;
}

// int main () {
// 	read_write_file();
// 	ios::sync_with_stdio(false);
// 	cin.tie(nullptr);
// 	int t;
// 	cin >> t;
// 	while (t--) {
//         int n;
//         cin >> n;
//         vector<int> a(n);
//         for (int i = 0; i < n; i++) cin >> a[i];
//         set<int> ts;
//         for (int x: a) ts.insert(x);
//         while (true) {
//             int y;
//             cin >> y;
//             if (y == -1) {
//                 cout << "0" << "\n";
//                 break;
//             } else if (y == -2) {
//                 return 0;
//             } else {
//                 auto it = ts.end();
//                 it--;
//                 int v = *it + 1;
//                 cout << v << "\n";
//                 ts.insert(v);
//                 ts.erase(ts.find(y));
//             }
//         }
//     }
// 	return 0;
// }