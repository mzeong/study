#include <string>
#include <vector>

using namespace std;

vector<int> solution(vector<int> sequence, int k) {
    vector<int> answer(2);
    
    int len = sequence.size() + 1;
    int l = 0;
    int r = 0;
    int sum = sequence[0];
    
    while (l <= r && r < sequence.size()){
        if (sum < k) {
            r++;
            sum += sequence[r];
            continue;
        } 
        else if (sum == k) {
            if (r - l + 1 < len) {
                len = r - l + 1;
                answer[0] = l;
                answer[1] = r;
            }
        } 
        sum -= sequence[l];
        l++;
    }
    return answer;
}
