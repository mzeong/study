#include <bits/stdc++.h>
using namespace std;

stack<pair<int, int>> s;
stack<int> num[31];

int main()
{
    ios::sync_with_stdio(0); cin.tie(0);
    
    string str; cin >> str;
    for (int i = 0; i < str.size(); i++) {
        if (str[i] == '(') s.push({2, i});
        else if (str[i] == '[') s.push({3, i});
        else {
            if (s.empty() || (str[i] == ')' && s.top().first != 2) || (str[i] == ']' && s.top().first != 3)) { cout << 0; return 0; }
            
            auto tmp = s.top(); s.pop();
            if (tmp.second == i-1) {
                num[s.size()].push(tmp.first);
            }
            else {
                int value = 0;
                while (!num[s.size()+1].empty()) {
                    value += num[s.size()+1].top();
                    num[s.size()+1].pop();
                }
                num[s.size()].push(tmp.first * value);
            }
        }
    }
    int ans = 0;
    while (!num[0].empty()) {
        ans += num[0].top(); 
        num[0].pop();
    }
    cout << ans;
    return 0;
}
