#include <bits/stdc++.h>

using namespace std;

int dy[12] = { -2, -1, 1, 2, 2, 1, -1, -2, 0, 1, 0, -1 };
int dx[12] = { 1, 2, 2, 1, -1, -2, -2, -1, 1, 0, -1, 0 };

struct monkey {
    int y;
    int x;
    int moved;
    int moved_like_horse;
};

int main()
{
    ios::sync_with_stdio(false); cin.tie(0);
    
    int k; cin >> k;
    int w, h; cin >> w >> h;
    int arr[h][w];
    for (int i = 0; i < h; i++) {
        for (int j = 0; j < w; j++) {
            cin >> arr[i][j];
        }
    }
    
    int visited[h][w][k+1];
    
    queue<monkey> q;
    for (int i = 0; i < h; i++) {
        for (int j = 0; j < w; j++) {
            for (int l = 0; l <= k; l++) {
                visited[i][j][l] = 0;
            }
        }
    }
    visited[0][0][0] = 1;
    q.push({0, 0, 0, 0});
    
    while(!q.empty()) {
        auto [y, x, m, mlh] = q.front();
        q.pop();
        
        if (y == h-1 && x == w-1) {
            cout << m;
            return 0;
        }
        
        for (int i = 0; i < 12; i++) {
            if (i < 8 && mlh >= k) continue;
                
            int ny = y + dy[i];
            int nx = x + dx[i];
            
            if (ny < 0 || ny >= h || nx < 0 || nx >= w) continue;
            if (arr[ny][nx]) continue;
            if (visited[ny][nx][mlh + (i < 8)]) continue;
                
            visited[ny][nx][mlh + (i < 8)] = 1;
            q.push({ny, nx, m+1, mlh + (i < 8)});
        }
    }

    cout << -1;
    
    return 0;
}
