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
    
    vector<int> answer(3);
    long long mn = 3000000001;
    for (int i = 0; i < n - 2; i++) {
        int left = i + 1, right = n - 1;
        
        while (left < right) {
            long long sum = 0L + v[i] + v[left] + v[right]; // 틀린 이유 -> 1L 씀
                
            if (abs(sum) < mn) {
                mn = abs(sum);
                answer[0] = v[i];
                answer[1] = v[left];
                answer[2] = v[right];
            }
                
            if (sum < 0) left++;
            else right--;
        }
    }
    
    cout << answer[0] << " " << answer[1] << " " << answer[2];
    
    return 0;
}
