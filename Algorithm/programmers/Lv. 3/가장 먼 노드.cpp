#include <string>
#include <vector>
#include <queue>

using namespace std;

int solution(int n, vector<vector<int>> edge) {
    vector<vector<int>> graph(n + 1);
    for (auto e : edge) {
        graph[e[0]].push_back(e[1]);
        graph[e[1]].push_back(e[0]);
    }
    
    queue<pair<int, int>> q;
    vector<int> visited(n + 1);
    q.push({1, 0});
    visited[1] = 1;
    
    vector<int> result(50000);
    int max_cnt = 0;
    
    while (!q.empty()) {
        auto [cur, cnt] = q.front();
        q.pop();
        
        result[cnt]++;
        max_cnt = max(max_cnt, cnt);
        
        for (auto nxt : graph[cur]) {
            if (!visited[nxt]) {
                q.push({nxt, cnt + 1});
                visited[nxt] = 1;
            }
        }
    }
    
    return result[max_cnt];
}
