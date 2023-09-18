#include <string>
#include <vector>

using namespace std;

bool can_cross_bridge(int x, vector<int>& stones, int k) {
    int cnt = 0;
    for (int i = 0; i < stones.size(); i++) {
        if (stones[i] < x) {
            cnt++;
            if (cnt >= k) return false;
        } else {
            cnt = 0;
        }
    }
    return true;
}

int solution(vector<int> stones, int k) {
    int answer = 0;
    int i = 1, j = 200000000;
    while (i <= j) {
        int mid = (i + j) / 2;
        if (can_cross_bridge(mid, stones, k)) {
            answer = max(answer, mid);
            i = mid + 1;
        }
        else {
            j = mid - 1;
        }
    }
    return answer;
}
