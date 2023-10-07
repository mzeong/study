#include <bits/stdc++.h>

using namespace std;

int main()
{
    int t; cin >> t;
    while (t--) {
        int n; cin >> n;
        vector<int> outdegree(n + 1), indegree(n + 1);
        for (int i = 1; i <= n; i++) {
            cin >> outdegree[i];
            indegree[outdegree[i]]++;
        }
        
        queue<int> q;
        for (int i = 1; i <= n; i++) {
            if (indegree[i] == 0) q.push(i); //내차수가 0인 것만 큐에 넣음 
        }
        
        int answer = 0;
        while (!q.empty()) {
            int cur = q.front();
            q.pop();
            
            answer++; 
            
            int nxt = outdegree[cur];
            indegree[nxt]--;
            if (indegree[nxt] == 0) q.push(nxt);
        }
        
        cout << answer << "\n";
    }
    
    return 0;
}
