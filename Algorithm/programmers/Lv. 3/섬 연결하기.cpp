#include <string>
#include <vector>
#include <algorithm>

using namespace std;

vector<int> parent(100);

bool cmp(vector<int>& a, vector<int>& b) {
    return a[2] < b[2];
}

int Find(int a) {
    if (a == parent[a]) return a;
    return parent[a] = Find(parent[a]);
}

void Union(int a, int b) {
    a = Find(a);
    b = Find(b);
    
    if (a == b) return;
    
    if (a < b) parent[b] = a;
    else parent[a] = b;
}

int solution(int n, vector<vector<int>> costs) {
    sort(costs.begin(), costs.end(), cmp);

    int answer = 0;
    for (int i = 0; i < n; i++) {
        parent[i] = i;
    } 
    Union(costs[0][0], costs[0][1]);
    answer += costs[0][2];
    for (int i = 1; i < costs.size(); i++) {
        if (Find(costs[i][0]) != Find(costs[i][1])) {
            Union(costs[i][0], costs[i][1]);
            answer += costs[i][2];
        } 
    }
    
    return answer;
}
