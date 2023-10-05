#include <bits/stdc++.h>

using namespace std;

const int INF = INT_MAX / 2;

int main()
{
    ios::sync_with_stdio(false); cin.tie(0);
    
    int n, m; cin >> n >> m;
    vector<vector<int>> dist(n + 1, vector<int>(n + 1, INF));
    vector<vector<int>> answer(n + 1, vector<int>(n + 1));
    while (m--) {
        int a, b, t; cin >> a >> b >> t;
        dist[a][b] = t;
        dist[b][a] = t;
        answer[a][b] = b;
        answer[b][a] = a;
    }
    for (int i = 1; i <= n; i++) dist[i][i] = 0;
    
    for (int k = 1; k <= n; k++) {
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (dist[i][j] > dist[i][k] + dist[k][j]) {
                    dist[i][j] = dist[i][k] + dist[k][j];
                    answer[i][j] = answer[i][k];
                    answer[j][i] = answer[j][k];
                }
            }
        }
    }
    
    for (int i = 1; i <= n; i++) {
        for (int j = 1; j <= n; j++) {
            if (i == j) cout << "- ";
            else cout << answer[i][j] << " ";
        }
        cout << "\n";
    }
    
    return 0;
}
