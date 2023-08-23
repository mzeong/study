/**
 * 첫 번째 풀이
 */
#include <string>
#include <vector>
#include <algorithm>

using namespace std;

vector<int> solution(vector<string> operations) {
    vector<int> answer;
    for (string str : operations) {
        string op = str.substr(0, str.find(" "));
        int num = stoi(str.substr(str.find(" ")+1, str.length()));
        
        if (op == "I") {
            answer.push_back(num);
            continue;
        }
        if (answer.empty()) continue; 
        else if (num == 1) {
            sort(answer.begin(), answer.end());
            answer.pop_back();
        } else {
            sort(answer.rbegin(), answer.rend());
            answer.pop_back();
        }
    }
    if (answer.empty()) return { 0, 0 };
    else {
        sort(answer.begin(), answer.end());
        int size = answer.size();
        return { answer[size-1], answer[0] };
    }
}

/**
 * 두 번째 풀이
 */
#include <string>
#include <vector>
#include <set>

using namespace std;

vector<int> solution(vector<string> operations) {
    multiset<int> mset;
    for (auto str : operations) {
        char op = str[0];
        int num = stoi(str.substr(2, str.length()));
        
        if (op == 'I') mset.insert(num);
        else {
            if (mset.empty()) continue;
            if (num == 1) mset.erase(--mset.end());
            else mset.erase(mset.begin());
        }
    }
    
    if (mset.empty()) return { 0, 0 };
    else return { *--mset.end(), *mset.begin() };
}
