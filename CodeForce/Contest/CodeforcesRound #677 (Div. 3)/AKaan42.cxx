#include <iostream>
#include <vector>

using namespace std;

typedef long long lo;
typedef pair<lo, lo> PII;

#define fi first
#define se second
#define mp make_pair
#define endl "\n"
#define pb push_back
#define fio() ios_base::sync_with_stdio(false); cin.tie(NULL); cout.tie(NULL)
#define FOR for (int i = 1; i <= n; i++)
#define mid ((start + end) / 2)
#define ort ((bas + son) / 2)

const lo inf = 1000000000000000000;
const lo KOK = 100000;
const lo LOG = 30;
const lo li = 500005;
const lo mod = 1000000007;

int n, m, b[li], a[li], k, flag, t;
int cev;
string s;
vector<int> v;

int main(void)
{
    scanf("%d", &t);
    while (t--)
    {
        scanf("%d", &n);
        int mx = 0;
        FOR
        {
            scanf("%d", &a[i]);
            mx = max(mx, a[i]);
        }
        a[0] = 2000000000;
        a[n + 1] = 2000000000;
        cev = -1;
        FOR
        {
            if (a[i] == mx && a[i] > a[i - 1])
            {
                cev = i;
                break;
            }
            if (a[i] == mx && a[i] > a[i + 1])
            {
                cev = i;
                break;
            }
        }
        printf("%d\n", cev);
    }
    return 0;
}