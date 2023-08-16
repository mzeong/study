#include <bits/stdc++.h>
using namespace std;

int b[50];

int main()
{
    ios::sync_with_stdio(false); cin.tie(NULL);
    
    int n; cin >> n;
    for (int i = 0; i < n; i++) cin >> b[i];
    
    int cnt = 0;
    while (1) {
        bool allZero = true;
        bool allEven = true;
        for (int i = 0; i < n; i++) {
            if (b[i]) allZero = false; 
            if (b[i] % 2) allEven = false, b[i]--, cnt++; 
        }
        if (allZero) break;
        if (allEven) {
            for (int i = 0; i < n; i++) b[i] /= 2;
            cnt++;
        }
    }
    cout << cnt;
    return 0;
}
