#include <bits/stdc++.h>
using namespace std;

int n, m; 
int arr[10], num[10], isused[10];
vector<int> v;

void f(int k) {
    if (k == m) {
        for (int i = 0; i < m; i++) {
            cout << arr[i] << ' ';
        }
        cout << '\n';
        return;
    }
    
    int prev = 0;
    for (int i = 0; i < n; i++) {
        if (!isused[i] && num[i] != prev) { // 이전 수열의 마지막 항과 새로 추가할 값이 같으면 중복 수열 
            arr[k] = num[i];
            prev = arr[k];
            isused[i] = 1;
            f(k+1);
            isused[i] = 0;
        }
    }
}

int main()
{
    ios::sync_with_stdio(0); cin.tie(0);
    
    cin >> n >> m;
    for (int i = 0; i < n; i++) cin >> num[i];
    sort(num, num + n);
    f(0);
    return 0;
}
