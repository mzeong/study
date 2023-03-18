#include <bits/stdc++.h>
using namespace std;

int n, m; 
int arr[10], num[10];

void f(int k) {
    if (k == m) {
        for (int i = 0; i < m; i++) {
            cout << num[arr[i]] << ' ';
        }
        cout << '\n';
        return;
    }
    
    int prev = 0;
    for (int i = arr[k-1] + 1; i <= n; i++) {
        arr[k] = i;
        if (prev == num[arr[k]]) continue;
        else prev = num[arr[k]];
        f(k+1);
    }
}

int main()
{
    ios::sync_with_stdio(0); cin.tie(0);
    
    cin >> n >> m;
    for (int i = 1; i <= n; i++) cin >> num[i];
    sort(num, num + n + 1);
    f(0);
    return 0;
}
