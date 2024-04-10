#include <iostream>
#include <vector>
using namespace std;

const int n_ = 5001;

int v[n_], answer[n_], used[n_];

void sol(int idx, int n) {
    if (idx == n) {
        for (int i = 0; i < n; i++) {
            cout << answer[i] << " ";
        }
        exit(0);
    }
    
    for (int i = 0; i < n; i++) {
        if (v[i] == v[idx] || used[i]) continue;
        
        used[i] = 1;
        answer[idx] = v[i];
        sol(idx + 1, n);
        used[i] = 0;
    }
}

int main()
{
    ios::sync_with_stdio(false); cin.tie(0);
    
    int n; cin >> n;
    for (int i = 0; i < n; i++) cin >> v[i];
    
    sol(0, n);
    cout << -1;
    
    return 0;
}
