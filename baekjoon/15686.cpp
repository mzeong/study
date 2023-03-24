#include <bits/stdc++.h>
using namespace std;
const int DIST_MAX = 101;

vector<pair<int, int>> home, chicken;
int a[13], dist[101];

int main()
{
    ios::sync_with_stdio(0); cin.tie(0);
    
    int n, m; cin >> n >> m;
    for (int i = 0; i < n; i++) {
        for (int j = 0; j < n; j++) {
            int input; cin >> input;
            if (input == 1) home.push_back({i, j});
            else if (input == 2) chicken.push_back({i, j});
        }
    }
    for (int i = m; i < chicken.size(); i++) a[i] = 1;
    
    for (int i = 0; i < home.size(); i++) dist[i] = DIST_MAX;
    int res = 0;
    do {
    	for (int i = 0; i < chicken.size(); i++) {
            if (a[i] == 0) {
                for (int j = 0; j < home.size(); j++) { 
                    int y = abs(chicken[i].first - home[j].first);
                    int x = abs(chicken[i].second - home[j].second);
                    dist[j] = min(dist[j], y + x);
                }
            }
    	}
    	int tmp = 0;
    	for (int i = 0; i < home.size(); i++) {
    	    tmp += dist[i];
    	    dist[i] = DIST_MAX; // 초기화
    	}
    	res = ((res == 0) ? tmp : min(res, tmp));
    } while (next_permutation(a, a + chicken.size()));
    cout << res;
    return 0;
}
