// 05/31/21 afternoon
// https://discuss.codechef.com/t/charges-editorial/90418
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

ll cal (string s) {
  ll dis = 0;
  int n = s.length();
  for (int i = 0; i < n - 1; i++) {
    if (s[i] == s[i + 1]) {
      dis += 2;
    } else {
      dis++;
    }
  }
  return dis;
}

// Accepted https://www.codechef.com/viewsolution/47292653
void run () {
  int n, k;
  cin >> n >> k;
  string s;
  cin >> s;
  vector<int> arr(k);
  for (int i = 0; i < k; i++) {
    cin >> arr[i];
  }
  if (n == 1) {
    cout << 0 << endl;
    return;
  }
  ll dis = cal(s);
  for (int i = 0; i < k; i++) {
    int kk = arr[i] - 1;
    if (kk == 0) {
      string pre, cur;
      pre.push_back(s[kk]);
      pre.push_back(s[kk + 1]);
      s[kk] ^= 1;
      cur.push_back(s[kk]);
      cur.push_back(s[kk + 1]);
      dis = dis - cal(pre) + cal(cur);
      // cout << pre << " " << cur << " " << s << " " << endl;
      cout << dis << endl;
    } else if (kk == n - 1) {
      string pre, cur;
      pre.push_back(s[kk - 1]);
      pre.push_back(s[kk]);
      s[kk] ^= 1;
      cur.push_back(s[kk - 1]);
      cur.push_back(s[kk]);
      dis = dis - cal(pre) + cal(cur);
      cout << dis << endl;
    } else {
      string pre, cur;
      pre.push_back(s[kk - 1]);
      pre.push_back(s[kk]);
      pre.push_back(s[kk + 1]);
      s[kk] ^= 1;
      cur.push_back(s[kk - 1]);
      cur.push_back(s[kk]);
      cur.push_back(s[kk + 1]);
      dis = dis - cal(pre) + cal(cur);
      cout << dis << "\n";
    }
  }
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

