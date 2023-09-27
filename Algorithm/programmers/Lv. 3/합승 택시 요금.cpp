#include <string>
#include <vector>
#include <climits>

using namespace std;
const int INF = INT_MAX / 2;

int solution(int n, int s, int a, int b, vector<vector<int>> fares) {
    vector<vector<int>> dist(n + 1, vector<int>(n + 1, INF));
    for (int i = 1; i <= n; i++) {
        dist[i][i] = 0;
    }
    
    for (const auto& fare : fares) {
        dist[fare[0]][fare[1]] = fare[2];
        dist[fare[1]][fare[0]] = fare[2];
    }
    
    for (int k = 1; k <= n; k++) {
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (dist[i][k] + dist[k][j] < dist[i][j]) {
                    dist[i][j] = dist[i][k] + dist[k][j];
                }
            }
        }
    }
    
    int answer = INF;
    for (int i = 1; i <= n; i++) {
        if (dist[s][i] != INF && dist[i][a] != INF && dist[i][b] != INF) {
            answer = min(answer, dist[s][i] + dist[i][a] + dist[i][b]);
        }
    }
    
    return answer;
}
