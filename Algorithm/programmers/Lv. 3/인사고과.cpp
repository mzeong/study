#include <string>
#include <vector>
#include <algorithm>

using namespace std;

bool cmp(vector<int>& a, vector<int>& b) { 
    if (a[0] != b[0]) return a[0] > b[0];
    else return a[1] < b[1];
}

int solution(vector<vector<int>> scores) {
    auto target = scores[0];
    
    sort(scores.begin(), scores.end(), cmp);
    int threshold = 0;
    int answer = 1;
    for (const auto& score : scores) {
        if (target[0] < score[0] && target[1] < score[1]) return -1;
        if (threshold <= score[1]) {
            if (target[0] + target[1] < score[0] + score[1]) answer++;
            threshold = score[1];
        }
    }
    
    return answer;
}
