#include <string>
#include <vector>
#include <algorithm>
#include <functional>

using namespace std;

int solution(vector<int> A, vector<int> B) {
    sort(A.begin(), A.end(), greater<int>());
    sort(B.begin(), B.end(), greater<int>());
    int i = 0, j = 0, size = A.size();
    int answer = 0;
    while (i < size) {
        if (A[i] < B[j]) {
            i++; j++;
            answer++;
        } else {
            i++;
        }
    }
    return answer;
}
