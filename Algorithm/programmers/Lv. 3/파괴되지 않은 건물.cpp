#include <string>
#include <vector>

using namespace std;

int solution(vector<vector<int>> board, vector<vector<int>> skill) {
    int n = board.size();
    int m = board[0].size();
    
    vector<vector<int>> arr(n, vector<int>(m));
    for (auto sk : skill) {
        int type = sk[0];
        int r1 = sk[1];
        int c1 = sk[2];
        int r2 = sk[3];
        int c2 = sk[4];
        int degree = sk[5];
        
        if (type == 2) degree = -degree; 
        
        arr[r2][c2] -= degree;
        if (r1 > 0) arr[r1-1][c2] += degree;
        if (c1 > 0) arr[r2][c1-1] += degree;
        if (r1 > 0 && c1 > 0) arr[r1-1][c1-1] -= degree;        
    }
    
    int answer = 0;
    for (int r = n-1; r >= 0; r--) {
        for (int c = m-1; c >= 0; c--) {
            if (r < n-1) arr[r][c] += arr[r+1][c];
            if (c < m-1) arr[r][c] += arr[r][c+1];
            if (r < n-1 && c < m-1) arr[r][c] -= arr[r+1][c+1];
            
            board[r][c] += arr[r][c];
            if (board[r][c] > 0) answer++;
        }
    }
    
    return answer;
}
