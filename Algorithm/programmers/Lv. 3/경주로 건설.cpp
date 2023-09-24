#include <string>
#include <vector>
#include <queue>

using namespace std;

int dy[4] = { 0, 1, 0, -1 };
int dx[4] = { 1, 0, -1, 0 };

struct area{
    int y;
    int x;
    int cost;
    int dir; //상하는 1, 좌우는 0
};

int solution(vector<vector<int>> board) {
    int n = board[0].size();
    int road[n][n][2];
    for (int i = 0; i < n; i++) {
        for (int j = 0; j < n; j++) {
            road[i][j][0] = 5000;
            road[i][j][1] = 5000;
        }
    }

    queue<area> q;
    q.push({0, 0, 0, 0});
    q.push({0, 0, 0, 1});
    road[0][0][0] = 0;
    road[0][0][1] = 0;

    while(!q.empty()) {
        auto [y, x, cost, dir] = q.front();
        q.pop();

        for (int i = 0; i < 4; i++) {
            int nxt_y = dy[i] + y;
            int nxt_x = dx[i] + x;
            int nxt_cost = (i % 2 == dir) ? (cost + 1) : (cost + 6);
            int nxt_dir = i % 2;

            if (nxt_y < 0 || nxt_y >= n || nxt_x < 0 || nxt_x >= n) continue;
            if (board[nxt_y][nxt_x]) continue;

            if (nxt_cost < road[nxt_y][nxt_x][nxt_dir]) {
                road[nxt_y][nxt_x][nxt_dir] = nxt_cost;
                q.push({nxt_y, nxt_x, nxt_cost, nxt_dir});
            } 

        }
    }

    int answer = min(road[n-1][n-1][0], road[n-1][n-1][1]) * 100;
    return answer;
}
