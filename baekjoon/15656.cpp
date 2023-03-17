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
    
    for (int i = 1; i <= n; i++) {
        arr[k] = i;
        f(k+1);
        arr[k] = 0;
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
