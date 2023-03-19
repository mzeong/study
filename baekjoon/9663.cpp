#include <bits/stdc++.h>
using namespace std;

int n, cnt;
int isused1[15], isused2[30], isused3[30];

void nqueen(int y) {
    if (y == n) {
        cnt++;
        return;
    }
    
    for (int x = 0; x < n; x++) {
        if (isused1[x] || isused2[y+x] || isused3[y-x+n-1]) continue;
        isused1[x] = 1;
        isused2[y+x] = 1;
        isused3[y-x+n-1] = 1;
        nqueen(y+1);
        isused1[x] = 0;
        isused2[y+x] = 0;
        isused3[y-x+n-1] = 0;
    }
}

int main()
{
    ios::sync_with_stdio(0); cin.tie(0);
    
    cin >> n;
    nqueen(0);
    cout << cnt;
    return 0;
}
