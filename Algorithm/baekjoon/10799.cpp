#include <bits/stdc++.h>
using namespace std;

stack<int> s;
int ans, remain;

int main()
{
    ios::sync_with_stdio(0); cin.tie(0);
    
    string str; cin >> str;
    for (int i = 0; i < str.size(); i++) {
        if (str[i] == '(') s.push(i);
        else {
            int tmp = s.top(); s.pop();
            if (tmp == i-1) {
                ans += s.size() + remain;
                remain = 0;
            }
            else remain++;
        }
    }
    ans += remain;
    cout << ans;
    return 0;
}
