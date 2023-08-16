#include <bits/stdc++.h>
using namespace std;

int n, m;
int arr[10][10], arr2[10][10];
vector<pair<int, int>> v;
int dy[4] = { 0, 1, 0, -1 };
int dx[4] = { 1, 0, -1, 0 };


void upd(int y, int x, int dir) {
    dir %= 4;
    while(1){
        y += dy[dir];
        x += dx[dir];
        if (y < 0 || y >= n || x < 0 || x >= m) return;
        if (arr2[y][x] == 6) return;
        if (arr2[y][x] != 0) continue;
        arr2[y][x] = 7;
    }
}

int main()
{
    ios::sync_with_stdio(0); cin.tie(0);
    
    cin >> n >> m;
    int count = 0;
    for (int i = 0; i < n; i++) {
        for (int j = 0; j < m; j++) {
            cin >> arr[i][j];
            if (arr[i][j] > 0 && arr[i][j] < 6) v.push_back({i, j});
            if (arr[i][j] == 0) count++;
        }
    }
    for (int tmp = 0; tmp < (1 << (2 * v.size())); tmp++) {
        for (int i = 0; i < n; i++) {
            for (int j = 0 ; j < m; j++) {
                arr2[i][j] = arr[i][j];
            }
        }
        int brute = tmp;
        for (int i = 0; i < v.size(); i++) {
            int dir = brute % 4;
            brute /= 4;
            int y = v[i].first;
            int x = v[i].second;
            switch(arr[y][x]) {
                case 1:  {
                    upd(y, x, dir); 
                    break;
                }
                case 2: {
                    upd(y, x, dir);
                    upd(y, x, dir + 2);
                    break;
                }
                case 3: {
                    upd(y, x, dir);
                    upd(y, x, dir + 1);
                    break;
                }
                case 4: {
                    upd(y, x, dir);
                    upd(y, x, dir + 1);
                    upd(y, x, dir + 2);
                    break;
                }
                case 5: {
                    upd(y, x, dir);
                    upd(y, x, dir + 1);
                    upd(y, x, dir + 2);
                    upd(y, x, dir + 3);
                    break;
                }
            }
            int cnt = 0;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    cnt += (arr2[i][j] == 0);
                }
            }
            count = min(count, cnt);
        }
    }
    cout << count;
    return 0;
}
