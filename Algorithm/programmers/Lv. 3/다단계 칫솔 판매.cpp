#include <string>
#include <vector>
#include <map>

using namespace std;

map<string, int> m;

void distribute(int cur, int cost, vector<string>& referral, vector<int>& answer) {
    int ncost = cost * 0.1;
    answer[cur] += cost - ncost;
    string nxt = referral[cur];
    if (ncost >= 1 && (m.find(nxt) != m.end())) {
        distribute(m[nxt], ncost, referral, answer);
    }
}

vector<int> solution(vector<string> enroll, vector<string> referral, vector<string> seller, vector<int> amount) {
    for (int i = 0; i < enroll.size(); i++) {
        m.insert({enroll[i], i});
    }

    vector<int> answer(enroll.size());
    for (int i = 0; i < seller.size(); i++) {
        distribute(m[seller[i]], amount[i] * 100, referral, answer);
    }

    return answer;
}
