#include <string>
#include <vector>

using namespace std;

void rotate(vector<vector<int>>& key) {
    int m = key.size();
    vector<vector<int>> temp(m, vector<int>(m));

    for (int i = 0; i < m; i++) {
        for (int j = 0; j < m; j++) {
            temp[j][m - i - 1] = key[i][j]; 
        }
    }
    
    key = temp;
}

bool check(vector<vector<int>>& board, vector<vector<int>>& key, int y, int x, int n) {
    int m = key.size();
    
    bool flag = true;
    for (int i = 0; i < m; i++) {
        for (int j = 0; j < m; j++) {
            board[y + i][x + j] += key[i][j];
        }
    }
    
    for (int i = 0; i < n; i++) {
        for (int j = 0; j < n; j++) {
            if (board[i + m - 1][j + m - 1] != 1) {
                flag = false;
                break;
            }
        }
    }
    
    for (int i = 0; i < m; i++) {
        for (int j = 0; j < m; j++) {
            board[y + i][x + j] -= key[i][j];
        }
    }
    
    return flag;
}

bool solution(vector<vector<int>> key, vector<vector<int>> lock) {
    int m = key.size();
    int n = lock.size();
    int b = n + 2 * (m - 1); 
    
    vector<vector<int>> board(b, vector<int>(b));
    
    for (int i = 0; i < n; i++) {
        for (int j = 0; j < n; j++) {
            board[i + m - 1][j + m - 1] = lock[i][j];
        }
    }
    
    for (int r = 0; r < 4; r++) {
        for (int i = 0; i <= b - m; i++) {
            for (int j = 0; j <= b - m; j++) {
                if (check(board, key, i, j, n)) return true;
            }
        }
        rotate(key);
    }
    
    return false;
}
