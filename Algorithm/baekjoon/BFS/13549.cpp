#include <bits/stdc++.h>

using namespace std;

const int N = 100000;

int main()
{
    ios::sync_with_stdio(false); cin.tie(0);
    
    int n, k; cin >> n >> k;
    
    vector<int> visited(N + 1, 2 * N);
    queue<int> q;
    
    visited[n] = 0;
    q.push(n);
    
    while (!q.empty()) {
        int cur = q.front();
        q.pop();
        
        if (cur == k) break;
        
        if (cur-1 >= 0 && visited[cur] + 1 < visited[cur-1]) {
            visited[cur-1] = visited[cur] + 1;
            q.push(cur-1);
        }
        if (cur+1 <= N && visited[cur] + 1 < visited[cur+1]) {
            visited[cur+1] = visited[cur] + 1;
            q.push(cur+1);
        }
        if (2*cur <= N && visited[cur] < visited[2*cur]) {
            visited[2*cur] = visited[cur];
            q.push(2*cur);
        }
    }
    cout << visited[k];
    
    return 0;
}
