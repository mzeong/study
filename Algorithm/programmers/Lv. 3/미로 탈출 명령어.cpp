#include <string>
#include <vector>
#include <queue>

using namespace std;
const int n_ = 51;

int dx[4] = { 1, 0, 0, -1 };
int dy[4] = { 0, -1, 1, 0 };
string dir = "dlru";
string visited[n_][n_];

struct square {
    int x;
    int y;
    string p;
};

string solution(int n, int m, int x, int y, int r, int c, int k) {
    queue<square> q;
    visited[x][y] = "";
    q.push({x, y, ""});
    
    while (!q.empty()) {
        square cur = q.front();
        q.pop();
        
        if (cur.x == r && cur.y == c && cur.p.length() == k) {
            return cur.p;
        }

        for (int i = 0; i < 4; i++) {
            int nx = cur.x + dx[i];
            int ny = cur.y + dy[i];

            if (nx < 1 || nx > n || ny < 1 || ny > m) continue;
            if (cur.p.length() + 1 > k) continue;
            if (cur.p.length() + 1 == visited[nx][ny].length() && cur.p >= visited[nx][ny]) continue;

            visited[nx][ny] = cur.p + dir[i];
            q.push({nx, ny, cur.p + dir[i]});
        }
    }

    return "impossible";
}
