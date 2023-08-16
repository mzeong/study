#include <bits/stdc++.h>
using namespace std;

int lose[100001], gain[100001];
queue<int> q;

int main()
{
    ios::sync_with_stdio(false); cin.tie(NULL);
    
    int X, Y, M; cin >> X >> Y >> M;
    for (int i = 1; i <= X; i++) cin >> lose[i];
    for (int i = 1; i <= Y; i++) cin >> gain[i];
    
    int m = M, i = 1, j = 1;
    while (i <= X) {
        m -= lose[i]; q.push(-1 * i);
        if (m <= 0) { cout << 0; return 0; }
        while (m <= M/2 && j <= Y) {
            m = min(M, m + gain[j]); q.push(j);
            j++;
        }
        i++;
    }
    while (j <= Y) q.push(j++);
    
    while (!q.empty()) {
        cout << q.front() << "\n";
        q.pop();
    }
    return 0;
}
