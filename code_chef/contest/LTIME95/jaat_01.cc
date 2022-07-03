// 04/30/21 night
#include <iostream>
#include <unordered_map>
using namespace std;

typedef long long ll;

// Accepted --- 0.14sec
// reference: https://discuss.codechef.com/t/benchp-need-help-partially-correct/88832
int main() {
  int T;
  cin >> T;
  while (T--) {
    int N, W, wr;
    cin >> N >> W >> wr;
    int a[N];
    unordered_map<ll, ll> m;
    for (int i = 0; i < N; i++) {
      cin >> a[i];
      m[a[i]]++;
    }
    if (wr >= W) {
      cout << "YES\n";
    } else if (W > wr) {
      ll sum = 0;
      for (auto itr : m) {
        if (itr.second % 2 == 0) {
          sum += 1LL * itr.first * itr.second;
        } else {
          sum += 1LL * itr.first * (itr.second - 1);
        }
      }
      if (sum + wr >= W) {
        cout << "YES\n";
      } else {
        cout << "NO\n";
      }
    }
  }
  return 0;
}