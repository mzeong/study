#include <string>
#include <vector>

using namespace std;

vector<string> solution(vector<string> s) {
    vector<string> answer;
    
    for (string x : s) {
        if (x.length() <= 3) {
            answer.push_back(x);
            continue;
        }
        
        int cnt = 0;
        for (int i = 0; i < x.length() - 2 && x.length() >= 3; i++) {
            if (x.substr(i, 3) == "110") {
                x.erase(i, 3);
                cnt++;
                i = i > 1 ? i - 3 : (i > 0 ? i - 2 : i - 1);
            }
        }
        
        int i = x.length() - 1;
        string tmp = "";
        while (i >= 0) {
            if (x[i] == '0') {
                tmp += x.substr(0, i + 1);
                break;
            }
            i--;
        }
        while (cnt > 0) {
            tmp += "110";
            cnt--;
        }
        tmp += x.substr(i + 1);
        answer.push_back(tmp);
    }
    
    return answer;
}
