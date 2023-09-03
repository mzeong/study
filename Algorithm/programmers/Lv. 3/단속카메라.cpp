#include <string>
#include <vector>
#include <algorithm>

using namespace std;

bool cmp(vector<int>& a, vector<int>& b) {
    return a[1] < b[1];
}

int solution(vector<vector<int>> routes) {
    sort(routes.begin(), routes.end(), cmp);    
    int p = -300001;
    int answer = 0;
    for (auto r : routes) {
        if (p < r[0]) {
            p = r[1];
            answer++;
        }
    }
    return answer;
}
