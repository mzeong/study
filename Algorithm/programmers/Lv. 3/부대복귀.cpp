#include <string>
#include <vector>
#include <queue>
#include <climits>

using namespace std;

vector<int> solution(int n, vector<vector<int>> roads, vector<int> sources, int destination) {
    vector<vector<int>> adj(n + 1);
    for (auto road : roads) {
        adj[road[0]].push_back(road[1]);
        adj[road[1]].push_back(road[0]);
    }
    
    vector<int> dist(n + 1, INT_MAX);
    queue<int> q;
    dist[destination] = 0;
    q.push(destination);
    while(!q.empty()) {
        auto cur = q.front();
        q.pop();
        
        for (auto nxt : adj[cur]) {
            if (dist[nxt] > dist[cur] + 1) {
                dist[nxt] = dist[cur] + 1;
                q.push(nxt);
            }
        }
    }
    
    vector<int> answer;
    for (auto src : sources) {
        if (dist[src] == INT_MAX) answer.push_back(-1);
        else answer.push_back(dist[src]);
    }

    return answer;
}
