// 2.19 night
#include <iostream>
#include <vector>
#include <queue>
using namespace std;

typedef long long int64;
typedef pair<int, int> ii;
#define SZ(x) (int)((x).size())
template <typename T> static constexpr T inf = numeric_limits<T>::max() / 2;


void print_2DVector(vector<vector<int>> &a) {
  cout << "[";
  for (int i = 0; i < a.size(); i++)
  {
    cout << "[";
    for (int j = 0; j < a[i].size(); j++)
    {
      cout << a[i][j] << " ";
    }
    cout << "]";
  }
  cout << "]" << endl;
}

void print(vector<int> const &input)
{
  for (int i = 0; i < input.size(); i++)
  {
    cout << input.at(i) << ' ';
  }
  cout << endl;
}

vector<int> dijkstra(vector<vector<int>>& a, int s) {
  int n = SZ(a);
  vector<int> d(n, inf<int>);
  d[s] = 0;
  priority_queue<ii, vector<ii>, greater<ii>> Q;
  Q.push({d[s], s});
  cout << d[s] << " " << s << " " << endl;
  while (!Q.empty()) {
    auto [dd, u] = Q.top();
    Q.pop();
    cout << dd << " " << d[u] << " " << endl;
    if (dd != d[u]) continue;
    for (auto& v : a[u]) {
      if (d[v] > d[u] + 1) {
        d[v] = d[u] + 1;
        Q.push({d[v], v});
      }
    }
  }
  return d;
}

int main() {
  vector<vector<int>> a;
  vector<int> v1 {3};
  vector<int> v2 {0, 1, 2};
  a.push_back(v1);
  a.push_back(v1);
  a.push_back(v1);
  a.push_back(v2);
  print_2DVector(a);
  dijkstra(a, 0);
  cout << endl;
  dijkstra(a, 1);
  cout << endl;
  dijkstra(a, 2);
}