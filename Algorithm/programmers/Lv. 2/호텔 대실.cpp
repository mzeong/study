#include <string>
#include <vector>
#include <algorithm>

using namespace std;

int solution(vector<vector<string>> book_time) {
    int answer = 0;

    vector<int> s, e;
    for (auto bt : book_time) {
        int startMinutes = stoi(bt[0].substr(0, 2)) * 60 + stoi(bt[0].substr(3, 2));
        int endMinutes = stoi(bt[1].substr(0, 2)) * 60 + stoi(bt[1].substr(3, 2)) + 10;
        s.push_back(startMinutes);
        e.push_back(endMinutes);
    }
    sort(s.begin(), s.end());
    sort(e.begin(), e.end());

    int i = 0, j = 0;
    int cnt = 0;
    while (i < book_time.size() && j < book_time.size()) {
        if (e[j] > s[i]) {
            cnt++; 
            i++;
            answer = max(answer, cnt);
        } else {
            cnt--;
            j++;
        }
    }
    return answer;
}
