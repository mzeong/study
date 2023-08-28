/*
첫 번째 풀이
*/
#include <string>
#include <vector>
#include <algorithm>

using namespace std;

void dfs(int i, string target, int cnt, vector<int>& visited, vector<vector<int>>& edge, vector<string>& words, int& answer) {
    if (words[i] == target) {
        answer = cnt;
        return;
    }
    for (auto j : edge[i]) {
        if (visited[j]) continue;
        visited[j] = 1;
        dfs(j, target, cnt+1, visited, edge, words, answer);
        visited[j] = 0;
    }
}

int solution(string begin, string target, vector<string> words) {
    vector<string>::iterator it;
    it = find(words.begin(), words.end(), target);
    if (it == words.end()) return 0; //변환할 수 없는 경우
    
    words.push_back(begin);
    int size = words.size();
    int length = begin.length();
    vector<vector<int>> edge(size);
    for (int i = 0; i < size; i++) {
        for (int j = i + 1; j < size; j++) {
            int cnt = 0;
            for (int k = 0; k < length; k++) {
                if (words[i][k] != words[j][k]) cnt++;
            }
            if (cnt == 1) { //한 번에 한 개의 알파벳만 바꿀 수 있음 
                edge[i].push_back(j);
                edge[j].push_back(i);
            }
        }
    }

    vector<int> visited(size, 0);
    visited[size-1] = 1;
    int answer = 0;
    dfs(size-1, target, 0, visited, edge, words, answer);
    return answer;
}

/*
두 번째 풀이
*/
#include <string>
#include <vector>
#include <queue>

using namespace std;

bool possible(string& a, string& b) {
    int cnt = 0;
	for (int i = 0; i < a.length(); i++) {
		if (a[i] != b[i]) cnt++;
	}
	if (cnt == 1) return true;
	else return false;
}

int solution(string begin, string target, vector<string> words) {
    int answer = 0;
    queue<pair<string, int>> q;
    vector<int> visited(words.size(), 0);
    q.push({begin, 0});
    while (!q.empty()) {
        auto [word, cnt] = q.front();
        q.pop();

        if (word.compare(target) == 0) {
            answer = cnt;
            break;
        }

        for (int i = 0; i < words.size(); i++) {
            if (visited[i]) continue;
            if (possible(word, words[i])) {
                visited[i] = 1;
                q.push({words[i], cnt+1});
            }
        }
    }
    return answer;
}
