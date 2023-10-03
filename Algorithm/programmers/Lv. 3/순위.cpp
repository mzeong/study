#include <string>
#include <vector>

using namespace std;

int solution(int n, vector<vector<int>> results) {
    vector<vector<int>> v(n + 1, vector<int>(n + 1));
    for (const auto& result : results) {
        v[result[0]][result[1]] = 1;
    }
    
    for (int k = 1; k <= n; k++) {
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (!v[i][j] && v[i][k] && v[k][j]) {
                    v[i][j] = 1;
                }
            }
        }
    }
    
    vector<int> row(n + 1), col(n + 1);
    for (int i = 1; i <= n; i++) {
        for (int j = 1; j <= n; j++) {
            row[i] += v[i][j];
            col[j] += v[i][j];
        }
    }
    
    int answer = 0;
    for (int i = 1; i <= n; i++) {
        if (row[i] + col[i] == n - 1) answer++;
    }
    
    return answer;
}
