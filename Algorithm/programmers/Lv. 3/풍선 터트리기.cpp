#include <string>
#include <vector>
#include <climits>

using namespace std;

int solution(vector<int> a) {
    int n = a.size();
    vector<int> left_min(n, INT_MAX), right_min(n, INT_MAX);

    left_min[0] = a[0];
    for (int i = 1; i < n; i++) {
        left_min[i] = min(left_min[i - 1], a[i]);
    }
    right_min[n - 1] = a[n - 1];
    for (int i = n - 2; i >= 0; i--) {
        right_min[i] = min(right_min[i + 1], a[i]);
    }

    int answer = n;
    for (int i = 0; i < n; i++) {
        if (left_min[i] < a[i] && right_min[i] < a[i]) { //2회 이상 작은 풍선이 온다면 살아 남을 수 없음 
            answer--;
        }
    }

    return answer;
}
