#include <bits/stdc++.h>
using namespace std;

int n, m, k, r, c;
int sticker[12][12], nb[42][42];

bool pastable(int y, int x) {
    for (int i = 0; i < r; i++) {
        for (int j = 0; j < c; j++) {
            if (nb[y + i][x + j] && sticker[i][j]) return false;
        }
    }
    
    for (int i = 0; i < r; i++) {
        for (int j = 0; j < c; j++) {
            if (sticker[i][j]) nb[y + i][x + j] = 1;
        }
    }
    return true;
}

void rotate() {
    int tmp[12][12];
    
    for (int i = 0; i < r; i++) {
        for (int j = 0; j < c; j++) {
            tmp[i][j] = sticker[i][j];
        }
    }
    
    for (int i = 0; i < r; i++) {
        for (int j = 0; j < c; j++) {
            sticker[j][i] = tmp[r-1-i][j];
        }
    }
    swap(r, c);
}

int main()
{
    ios::sync_with_stdio(0); cin.tie(0);
    
    cin >> n >> m >> k;
    while (k--) {
        cin >> r >> c;
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                cin >> sticker[i][j];
            }
        }
        
        for (int rot = 0; rot < 4; rot++) {
            bool isPaste = false;
            for (int y = 0; y <= n - r; y++) {
                if (isPaste) break;
                for (int x = 0; x <= m - c; x++) {
                    if (pastable(y, x)) {
                        isPaste = true;
                        break;
                    }
                }
            }
            if (isPaste) break;
            rotate();
        }
    }
    
    int cnt = 0;
    for (int i = 0; i < n; i++) {
        for (int j = 0; j < m; j++) {
            cnt += nb[i][j];
        }
    }
    cout << cnt << '\n';
    return 0;
}
