#include <bits/stdc++.h>

using namespace std;

int main()
{
    ios::sync_with_stdio(false); cin.tie(0);
    
    int n; cin >> n;
    
    vector<vector<int>> dist(n + 1, vector<int>(n + 1));
    for (int i = 1; i <= n; i++) {
        for (int j = 1; j <= n; j++) {
            cin >> dist[i][j];
        }
    }
    
    vector<vector<int>> road(n + 1, vector<int>(n + 1, 1));
    for (int i = 1; i <= n; i++) {
        for (int j = 1; j <= n; j++) {
            if (i == j) {
                road[i][j] = 0;
                continue;
            }
            for (int k = 1; k <= n; k++) {
                if (k == i || k == j) continue;
                if (dist[i][j] == dist[i][k] + dist[k][j]) road[i][j] = 0;
                else if (dist[i][j] > dist[i][k] + dist[k][j]) {
                    cout << -1;
                    return 0;
                }
            }
        }
    }
    
    int answer = 0;
    for (int i = 1; i <= n; i++) {
        for (int j = i + 1; j <= n; j++) {
            if (road[i][j]) answer += dist[i][j];
        }
    }
    cout << answer;
    
    return 0;
}
