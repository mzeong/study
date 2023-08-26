#include <string>
#include <vector>
#include <cmath>
#include <queue>

using namespace std;

long long solution(int n, vector<int> works) {
    priority_queue<int> pq;
    for (auto w : works) {
        pq.push(w);
    }
    
    while (!pq.empty() && n--) {
        int w = pq.top();
        pq.pop();
        if (w > 1) pq.push(w-1);
    }
    
    long long answer = 0;
    while (!pq.empty()) {
        int w = pq.top();
        pq.pop();
        answer += pow(w, 2);
    }
    return answer;
}
