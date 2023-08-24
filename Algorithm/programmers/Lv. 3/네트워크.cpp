/**
 * 첫 번째 풀이
 */
#include <string>
#include <vector>
#include <algorithm>

using namespace std;

void dfs(int cur, vector<vector<int>>& edge, int visited[]) {
    visited[cur] = 1;
    for (auto nxt : edge[cur]) {
        if (visited[nxt]) continue;
        dfs(nxt, edge, visited);
    }
}

int solution(int n, vector<vector<int>> computers) {
    vector<vector<int>> edge(n);
    for (int i = 0; i < n; i++) {
        for (int j = 0; j < n; j++) {
            if (i == j) continue;
            if (computers[i][j]) edge[i].push_back(j);
        }
    }

    int answer = 0;
    int visited[n];
    fill(visited, visited + n, 0);
    for (int i = 0; i < n; i++) {
        if (visited[i]) continue;
        dfs(i, edge, visited);
        answer++;
    }
    return answer;
}

/**
 * 두 번째 풀이
 */
#include <string>
#include <vector>

using namespace std;

void dfs(int cur, int n, vector<vector<int>>& computers, vector<int>& visited) {
    visited[cur] = 1;
    for (int i = 0; i < n; i++) {
        if (cur != i && visited[i] == 0 && computers[cur][i]) {
            dfs(i, n, computers, visited);
        }
    }
}

int solution(int n, vector<vector<int>> computers) {
    int answer = 0;
    vector<int> visited(n, 0);
    for (int i = 0; i < n; i++) {
        if (visited[i]) continue;
        answer++;
        dfs(i, n, computers, visited);
    }
    return answer;
}
