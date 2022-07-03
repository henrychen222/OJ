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

// Accepted --- 0.03sec https://www.codechef.com/viewsolution/47293393
void run () {
  int n, k;
  cin >> n >> k;
  string s;
  cin >> s;
  vector<int> arr(k);
  for (int i = 0; i < k; i++) {
    cin >> arr[i];
  }
  long long dis = 0;
  for (int i = 0; i < n - 1; i++) {
    if (s[i] == s[i + 1])    dis += 2;
    else if (s[i] != s[i + 1]) dis += 1;
  }
  if (n == 1) {
    cout << 0 << endl;
    return;
  }
  for (int i = 0; i < k; i++) {
    int kk = arr[i] - 1;
    s[kk] ^= 1;
    if (kk == 0) {
      if (s[kk] == s[kk + 1])  dis += 1;
      else dis -= 1;
      cout << dis << endl;
      continue;
    }
    if (kk == n - 1) {
      if (s[kk] == s[kk - 1])  dis += 1;
      else dis -= 1;
      cout << dis << endl;
      continue;
    }
    if (s[kk] == s[kk - 1]) {
      dis += 1;
    } else {
      dis -= 1;
    }
    if (s[kk] == s[kk + 1]) {
      dis += 1;
    } else {
      dis -= 1;
    }
    cout << dis << "\n";
  }
}

void read_write_file () {
  freopen("input.txt", "r", stdin);
  freopen("output.txt", "w", stdout);
}

int main () {
  // read_write_file();
  ios::sync_with_stdio(false);
  cin.tie(0);
  int t;
  cin >> t;
  while (t--) run();
  return 0;
}

