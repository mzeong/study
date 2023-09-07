/*
첫 번째 풀이 
*/
#include <string>
#include <vector>
#include <algorithm>
#include <set>

using namespace std;

bool is_banned(string a, string b) {
    if (a.length() != b.length()) return false;
    else {
        for (int i = 0; i < a.length(); i++) {
            if (a[i] != '*' && a[i] != b[i]) return false;
        }
    }
    return true;
}

int solution(vector<string> user_id, vector<string> banned_id) {
    set<string> answer;
    sort(user_id.begin(), user_id.end());
    do {
        vector<string> list;
        for (int i = 0; i < banned_id.size(); i++) {
            if (is_banned(banned_id[i], user_id[i])) {
                list.push_back(user_id[i]);
            }
        }

        string str = "";
        if (list.size() == banned_id.size()) {
            sort(list.begin(), list.end());
            for (const auto& l : list) {
                str += l;
            }
            answer.insert(str);
        }
    } while (next_permutation(user_id.begin(), user_id.end()));

    return answer.size();
}

/*
두 번째 풀이 
*/
#include <string>
#include <vector>
#include <algorithm>
#include <set>

using namespace std;

set<string> answer;
bool used[10];

bool is_banned(string a, string b) {
    if (a.length() != b.length()) return false;
    else {
        for (int i = 0; i < a.length(); i++) {
            if (a[i] != '*' && a[i] != b[i]) return false;
        }
    }
    return true;
}

void dfs(int cnt, vector<string> user_id, vector<string> banned_id) {
    if (cnt == banned_id.size()) {
        string str = "";
        for (int i = 0; i < user_id.size(); i++) {
            if (used[i]) str += user_id[i];
        }
        answer.insert(str);
        return;
    }
    
    for (int i = 0; i < user_id.size(); i++) {
        if (!used[i] && is_banned(banned_id[cnt], user_id[i])) {
            used[i] = true; 
            dfs(cnt+1, user_id, banned_id);
            used[i] = false;
        }
    }
}

int solution(vector<string> user_id, vector<string> banned_id) {
    dfs(0, user_id, banned_id);
    return answer.size();
}
