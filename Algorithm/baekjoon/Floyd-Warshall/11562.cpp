#include <bits/stdc++.h>

using namespace std;

const int INF = INT_MAX / 2;

int main()
{
    ios::sync_with_stdio(false); cin.tie(0);
    
    int n, m; cin >> n >> m;
    
    vector<vector<int>> dist(n + 1, vector<int>(n + 1, INF));
    while (m--) {
        int u, v, b; cin >> u >> v >> b;
        dist[u][v] = 0;
        dist[v][u] = (b ? 0 : 1);
    }
    for (int i = 1; i <= n; i++) dist[i][i] = 0;
    
    for (int k = 1; k <= n; k++) {
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                dist[i][j] = min(dist[i][j], dist[i][k] + dist[k][j]);
            }
        }
    }
    
    int k; cin >> k;
    while (k--) {
        int s, e; cin >> s >> e;
        cout << dist[s][e] << "\n";
    }
    
    return 0;
}
