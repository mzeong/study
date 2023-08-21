#include <string>
#include <vector>

using namespace std;

int solution(vector<vector<int>> triangle) {
    int height = triangle.size();
    
    vector<vector<int>> dp(height);
    dp[0].push_back(triangle[0][0]); //초기화
    
    for (int i = 1; i < height; i++) {
        for (int j = 0; j < triangle[i].size(); j++) {
            int cur = triangle[i][j];
            int pre; 
            if (j == 0) pre = dp[i-1][j];
            else if (j == i) pre = dp[i-1][j-1];
            else pre = max(dp[i-1][j-1], dp[i-1][j]);
            dp[i].push_back(pre + cur);
        }
    }
    
    int answer = 0;
    for (int i = 0; i < height; i++) {
        answer = max(answer, dp[height-1][i]);
    }
    return answer;
}
