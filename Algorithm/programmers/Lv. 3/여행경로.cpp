#include <string>
#include <vector>
#include <algorithm>

using namespace std;

vector<string> answer;
vector<int> visited(100000);

void dfs(string airport, vector<vector<string>>& tickets, int count) {
    answer.push_back(airport);
    
    for (int i = 0; i < tickets.size(); i++) {
        if (tickets[i][0] == airport && !visited[i]) {
            visited[i] = 1;
            dfs(tickets[i][1], tickets, count + 1);
            
            if (answer.size() < tickets.size() + 1) {
                answer.pop_back();
                visited[i] = 0;
            }
        }
    }
}

vector<string> solution(vector<vector<string>> tickets) {
    sort(tickets.begin(), tickets.end());
    dfs("ICN", tickets, 0);

    return answer;
}
