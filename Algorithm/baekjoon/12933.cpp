#include <iostream>

using namespace std;

string sound = "quack";
int visited[2501];

int main()
{
    ios::sync_with_stdio(false); cin.tie(0);
    
    string s; cin >> s;
    
    int answer = 0;
    while (true) {
        bool flag = true;
        int cnt = 0;
        for (int i = 0, j = 0; i < s.length(); i++) {
            if (visited[i]) continue;
            
            flag = false;
            if (s[i] == sound[j]) {
                cnt++;
                visited[i] = 1;
                j = (j + 1) % sound.length();
            }
        }
        if (flag) {
            break;
        }
        if (cnt == 0 || cnt % 5 != 0) {
            cout << -1;
            return 0;
        }
        answer++;
    }
    cout << answer;
    return 0;
}
