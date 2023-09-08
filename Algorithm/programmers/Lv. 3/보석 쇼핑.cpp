#include <string>
#include <vector>
#include <unordered_set>
#include <map>

using namespace std;

vector<int> solution(vector<string> gems) {
    unordered_set<string> s;
    for (auto g : gems) {
        s.insert(g);
    }
    int kinds = s.size();
    
    map<string, int> m;
    int start = 0;
    int end = 0;
    int size = gems.size();
    vector<int> answer = { 0, size };
    while (end < size) {
        m[gems[end]]++;
        end++;
        if (m.size() == kinds) {
            while (start < end) {
                if (m[gems[start]] > 1) {
                    m[gems[start]]--;
                    start++;
                } 
                else {
                    if (end - start < answer[1] - answer[0] + 1) {
                        answer[0] = start + 1;
                        answer[1] = end;
                    }
                    break;
                }
            }
        }
    }
    return answer;
}
