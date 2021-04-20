// 04/15/21 afternoon
#include <iostream>
#include <vector>
#include <set>
using namespace std;

typedef long long ll;
typedef vector<int> VI;

#define rep(i,n)for (int i = 0; i < int(n); ++i)
#define rrep(i,n)for (int i = int(n)-1; i >= 0; --i)
#define all(x) (x).begin(), (x).end()
#define rall(x) (x).rbegin(), (x).rend()

void print_set(set<int> s) {
    int n = s.size();
    cout << "Set {";
    int i = 0;
    for (auto const &e : s) {
        if (i == n - 1) {
            cout << e;
        } else {
            cout << e << ",";
        }
        i++;
    }
    cout << "}" << endl;
}


void read_write_file () {
    freopen("input.txt", "r", stdin);
    freopen("output.txt", "w", stdout);
}

int main() {
    read_write_file();
    ios::sync_with_stdio(false);
    cin.tie(0);
    int n;
    cin >> n;
    VI a(n);
    rep(i, n) cin >> a[i];
    set<int> alive;
    rep(i, n) alive.insert(i);
    int q;
    cin >> q;
    while (q--) {
        int x, k;
        cin >> x >> k;
        ll ans = 0;
        x--;
        cout << "x" << " " << x << " " << *alive.lower_bound(x) << endl;
        for (auto it = alive.lower_bound(x); it != alive.end() && k;) {
            int i = *it;
            print_set(alive);
            cout << *it << endl;
            int c = min(a[i], k);
            ans += ll(c) * (i - x);
            k -= c;
            a[i] -= c;
            it = alive.erase(it);
            //cout << *it << endl;
            if (k == 0) break;

        }
        cout << ans << '\n';
    }
    return 0;
}