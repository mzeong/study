#include <bits/stdc++.h>

using namespace std;

const int INF = INT_MAX / 2;

int main()
{
    ios::sync_with_stdio(false); cin.tie(0);
    
    int v, e; cin >> v >> e;
    
    vector<vector<int>> dist(v + 1, vector<int>(v + 1, INF));
    for (int i = 0; i < e; i++) {
        int a, b, c; cin >> a >> b >> c;
        dist[a][b] = c;
    }
    for (int i = 1; i <= v; i++) dist[i][i] = 0;
    
    for (int k = 1; k <= v; k++) {
        for (int i = 1; i <= v; i++) {
            for (int j = 1; j <= v; j++) {
                dist[i][j] = min(dist[i][j], dist[i][k] + dist[k][j]);
            }
        }
    }
    
    int answer = INF;
    for (int i = 1; i <= v; i++) {
        for (int j = 1; j <= v; j++) {
            if (i == j) continue;
            answer = min(answer, dist[i][j] + dist[j][i]);
        }
    }
    cout << (answer == INF ? -1 : answer);
    
    return 0;
}
