#include <string>
#include <vector>
#include <algorithm>

using namespace std;

long long solution(int n, vector<int> times) {
    sort(times.begin(), times.end());
    
    long long left = 1; 
    long long right = (long long)times.back() * n;
    long long answer = right;
    
    while (left <= right) {
        long long mid = (left + right) / 2;
        long long cnt = 0; //mid 시간 동안 심사할 수 있는 사람 수 
        
        for (auto time : times) {
            cnt += mid / time;
        }
        
        if (cnt >= n) {
            answer = min(answer, mid);
            right = mid - 1;
        } else {
            left = mid + 1;
        }
    }
        
    return answer;
}
