#include <string>
#include <vector>

using namespace std;

int visited[18];
int answer;

void dfs(vector<int> info, vector<vector<int>> edges, int sheep, int wolf) {
    if (sheep <= wolf) {
        return;
    }
    if (answer < sheep) {
        answer = sheep;
    }
    
    for (auto edge : edges) {
        int parent = edge[0], child = edge[1];
        
        if (!visited[parent] || visited[child]) continue;
        
        visited[child] = 1;
        if (info[child] == 0) {
            dfs(info, edges, sheep + 1, wolf);
        } else {
            dfs(info, edges, sheep, wolf + 1);
        }
        visited[child] = 0;
    }
}

int solution(vector<int> info, vector<vector<int>> edges) {
    visited[0] = 1;
    dfs(info, edges, 1, 0);
    return answer;
}
