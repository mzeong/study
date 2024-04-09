#include <string>
#include <vector>
#include <cmath>

using namespace std;

vector<int> solution(vector<long long> numbers) {
    vector<int> answer;
    
    for (long long number : numbers) {
        if (number < 2) {
            answer.push_back(number);
            continue;
        }
        
        int size = 3;
        while (number > pow(2, size)) {
            size = 2 * size + 1;
        }
        vector<int> v(size + 1);
        for (int i = v.size() - 1; number >= 1; i--) {
            v[i] = number % 2;
            number /= 2;
        }
        
        int result = 1;
        for (int i = 2, j = 4; i <= v.size() / 2 && result; i *= 2, j *= 2) {
            for (int k = i; k < v.size(); k += j) {
                if ((v[k - i / 2] == 1 || v[k + i / 2] == 1) && v[k] == 0) {
                    result = 0;
                    break;
                }
            }
        }
        answer.push_back(result);
    }
    
    return answer;
}
