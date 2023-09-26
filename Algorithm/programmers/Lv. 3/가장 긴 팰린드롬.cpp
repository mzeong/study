#include <iostream>
#include <string>
#include <vector>

using namespace std;

vector<vector<int>> v(26);

int is_palindrom(int a, int b, string& s) {
    int length = b - a + 1;
    while (a < b) {
        if (s[a] != s[b]) return 0;
        a++; b--;
    }
    return length;
}

int solution(string s)
{
    for (int i = 0; i < s.length(); i++) {
        v[s[i] - 'a'].push_back(i);
    }
    
    int answer = 1;
    for (int i = 0; i < v.size(); i++) {
        if (v[i].size() < 2) continue;
        
        for (int j = 0; j < v[i].size() - 1; j++) {
            for (int k = v[i].size() - 1; k > j; k--) {
                if (v[i][k] - v[i][j] + 1 < answer) continue;
                int len = is_palindrom(v[i][j], v[i][k], s);
                answer = max(answer, len);
            }
        }
    }

    return answer;
}
