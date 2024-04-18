#include <iostream>
#include <vector>
#include <stack>

using namespace std;

int s, l, r, n; 
vector<vector<int>> v = {{ 0, 0, 0 }, { 1, 3, 2 }, { 2, 1, 1 }, { 2, 3, 2 }};

vector<int> sol(int idx) {
    stack<int> st;
    for (int i = 0, q = idx; i < n; i++) { 
        st.push(q % 3);
        q /= 3;
    }
    
    vector<int> res(4);
    res[s]++;
    for (int i = 0, k = s; i < n; i++) {
        int r = st.top(); 
        st.pop();
        
        vector<int> tmp = res;
        
        tmp[k]--;
        
        res[1] = tmp[1] + 2 * tmp[2];
        res[2] = tmp[1] + tmp[2] + 2 * tmp[3];
        res[3] = tmp[1] + tmp[3];
        
        for (int j = 0; j < 3; j++) {
            if (j <= r) {
                res[v[k][j]]++;
            }
        } 
        
        k = v[k][r];
    }
    return res;
}

int main()
{
    ios::sync_with_stdio(false); cin.tie(0);
    
    cin >> s >> l >> r >> n;
    
    vector<int> v1 = sol(r);
    vector<int> v2 = l == 0 ? vector<int>{0, 0, 0, 0} : sol(l - 1);
    
    cout << v1[1] - v2[1] << " " << v1[2] - v2[2] << " " << v1[3] - v2[3];

    return 0;
}
