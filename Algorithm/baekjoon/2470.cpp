#include <iostream>
#include <vector>
#include <algorithm>
#include <cstdlib>

using namespace std;

int main()
{
    ios::sync_with_stdio(false); cin.tie(0);
    
    int n; cin >> n;
    vector<int> v(n);
    for (int i = 0; i < n; i++) cin >> v[i];
    
    sort(v.begin(), v.end());
    
    vector<int> answer(2);
    int left = 0, right = n - 1, mn = 2000000001;
    while (left < right) {
        int sum = v[left] + v[right]; // 틀린 코드 -> int sum = abs(v[left] + v[right]);
            
        if (abs(sum) < mn) {
            mn = abs(sum);
            answer[0] = v[left];
            answer[1] = v[right];
        }
        
        if (sum < 0) left++; 
        else right--;
    }
    
    cout << answer[0] << " " << answer[1];
    
    return 0;
}
