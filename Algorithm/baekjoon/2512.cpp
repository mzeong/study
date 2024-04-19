#include <iostream>
#include <vector>

using namespace std;

int main()
{
    ios::sync_with_stdio(false); cin.tie(0);
    
    int n; cin >> n;
    vector<int> v(n);
    int sum = 0, mx = 0;
    for (int i = 0; i < n; i++) {
        cin >> v[i];
        sum += v[i];
        mx = max(mx, v[i]);
    }
    int m; cin >> m;
    
    if (sum <= m) {
        cout << mx;
    } else {
        int answer = 0;
        int left = 1, right = mx;
        
        while (left <= right) {
            int mid = (left + right) / 2;
            
            int sum = 0;
            for (int i = 0; i < n; i++) {
                sum += v[i] < mid ? v[i] : mid;
            }
            
            if (sum <= m) {
                answer = max(answer, mid);
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        cout << answer;
    }

    return 0;
}
