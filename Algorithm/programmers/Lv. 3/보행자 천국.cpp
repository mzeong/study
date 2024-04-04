#include <vector>

using namespace std;

int MOD = 20170805;

int solution(int m, int n, vector<vector<int>> city_map) {
    vector<vector<int>> answer(m, vector<int>(n));
    
    for (int y = 0; y < m; y++) {
        for (int x = 0; x < n; x++) {
            if (y == 0 && x == 0) {
                answer[y][x] = 1;
                continue;
            } 
            
            if (city_map[y][x] != 0) {
                answer[y][x] = 0;
            } else {
                int up = 0, prev_y = y - 1;
                while (prev_y >= 0) {
                    if (city_map[prev_y][x] != 2) {
                        up = answer[prev_y][x];
                        break;
                    }
                    prev_y--;
                }
                
                int left = 0, prev_x = x - 1;
                while (prev_x >= 0) {
                    if (city_map[y][prev_x] != 2) {
                        left = answer[y][prev_x];
                        break;
                    }
                    prev_x--;
                }
                
                answer[y][x] = (up + left) % MOD;
            }
        }
    }
    
    return answer[m - 1][n - 1];
}
