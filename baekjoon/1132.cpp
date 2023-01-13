#include <bits/stdc++.h>
using namespace std;
const int AtoJ = 10;

string number[50];
vector<pair<long long, int>> weight(AtoJ);
bool notZero[AtoJ];
int value[AtoJ];

int main()
{
    ios::sync_with_stdio(false); cin.tie(NULL);
    
    int n; cin >> n;
    for (int i = 0; i < n; i++) cin >> number[i];
    for (int i = 0; i < n; i++) {
        string num = number[i];
        // 자리수로 가중치 부여
        long long k = 1;
        for (int j = num.length() - 1; j >= 0; j--, k *= 10) {
            weight[num[j] - 'A'].first += k;
        }
        // 0으로 시작하는 수는 없으므로 처음 나오는 알파벳은 0일 수 없음  
       notZero[num[0] - 'A'] = true;
    }
    for(int i = 0; i < weight.size(); i++) weight[i].second = i;
    sort(weight.begin(), weight.end());
    
    // 0 재배정 
    if (weight[0].first != 0 && notZero[weight[0].second]) {
        int i = 1;
        while (notZero[weight[i].second]) i++;
        auto tmp = weight[i];
        for (int j = i - 1; j >= 0; j--) weight[j + 1] = weight[j];
        weight[0] = tmp;
    }
    
    for (int i = 9; i >= 0; i--) value[weight[i].second] = i;
    long long res = 0;
    for (string num : number) {
        long long k = 1;
        for (int j = num.length() - 1; j >= 0; j--, k *= 10) {
            res += value[num[j] - 'A'] * k;
        }
    }
    cout << res;
    return 0;
}
