#include <bits/stdc++.h>
using namespace std;

int r, c, cnt;
char arr[10000][500];
bool visited[10000][500];
int dy[3] = {-1, 0, 1};

bool dfs(int y, int x) {
    visited[y][x] = true;
    if (x == c - 1) return true;
    for (int i = 0; i < 3; i++) {
        int ny = y + dy[i];
        int nx = x + 1;
        
        if (ny < 0 || ny >= r || nx >= c) continue;
        if (arr[ny][nx] == 'x') continue;
        if (visited[ny][nx]) continue;
        if (dfs(ny, nx)) return true;
    }
    return false;
}

int main()
{
    ios::sync_with_stdio(false); cin.tie(NULL);
    
    cin >> r >> c;
    for (int i = 0; i < r; i++) {
        for (int j = 0; j < c; j++) {
            cin >> arr[i][j];
        }
    }
    
    for (int i = 0; i < r; i++) {
        if (dfs(i, 0)) cnt++;   
    }
    cout << cnt;
    return 0;
}
