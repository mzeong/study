#include <bits/stdc++.h>

using namespace std;

int dy[4] = { 0, 1, 0, -1 };
int dx[4] = { 1, 0, -1, 0 };

int main()
{
    ios::sync_with_stdio(false); cin.tie(0);
    
    int n, m; cin >> n >> m;
    vector<vector<int>> arr(n, vector<int>(m));
    vector<pair<int, int>> fish;
    int sy, sx, ey, ex;
    for (int i = 0; i < n; i++) {
        string str; cin >> str;
        for (int j = 0; j < m; j++) {
            if (str[j] == 'S') sy = i, sx = j;
            else if (str[j] == 'H') ey = i, ex = j;
            else if (str[j] == 'D') arr[i][j] = -1;
            else if (str[j] == 'F') fish.push_back({ i, j });
        }
    }

    vector<vector<int>> p_to_f(n, vector<int>(m, -1)); //펭귄->물고기
    queue<pair<int, int>> q;
    p_to_f[sy][sx] = 0;
    q.push({ sy, sx });
    while (!q.empty()) {
        auto [y, x] = q.front();
        q.pop();
        
        for (int i = 0; i < 4; i++) {
            int ny = y + dy[i];
            int nx = x + dx[i];
            
            if (ny < 0 || ny >= n || nx < 0 || nx >= m) continue;
            if (arr[ny][nx] == -1 || p_to_f[ny][nx] > -1) continue;
            
            p_to_f[ny][nx] = p_to_f[y][x] + 1;
            q.push({ ny, nx });
        }
    }

    vector<vector<int>> h_to_f(n, vector<int>(m, -1)); //집->물고기
    h_to_f[ey][ex] = 0;
    q.push({ ey, ex });
    while (!q.empty()) {
        auto [y, x] = q.front();
        q.pop();
        
        for (int i = 0; i < 4; i++) {
            int ny = y + dy[i];
            int nx = x + dx[i];
            
            if (ny < 0 || ny >= n || nx < 0 || nx >= m) continue;
            if (arr[ny][nx] == -1 || h_to_f[ny][nx] > -1) continue;
            
            h_to_f[ny][nx] = h_to_f[y][x] + 1;
            q.push({ ny, nx });
        }
    }
    
    int answer = INT_MAX;
    for (auto [y, x] : fish) {
        if (p_to_f[y][x] == -1 || h_to_f[y][x] == -1) continue;
        answer = min(answer, p_to_f[y][x] + h_to_f[y][x]);
    }
    cout << (answer == INT_MAX ? -1 : answer);
    
    return 0;
}
