// Accepted --- 202ms https://codeforces.com/contest/1465/submission/101922403
#include <iostream>
using namespace std;

bool ok(long long a)
{
    long long b = a;
    while (b)
    {
        long long rem = b % 10;
        b /= 10;
        if (rem != 0 && a % rem != 0)
            return false;
    }
    return true;
}

void solve()
{
    long long num;
    cin >> num;
    while (true)
    {
        if (ok(num))
        {
            cout << num << '\n';
            return;
        }
        num++;
    }
}

int main()
{
    ios_base::sync_with_stdio(false);
    cin.tie(0);
    cout.tie(0);
    int t;
    cin >> t;
    while (t--)
        solve();
}