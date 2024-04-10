#include <iostream>
#include <vector>
using namespace std;

int main()
{
    ios::sync_with_stdio(false); cin.tie(0);
    
    int n; cin >> n;
    
    vector<int> p;
    int number = 1;
    while (p.size() < n - 1) {
        if (p.size() % 2 == 0) {
            p.push_back(number++);
        } else {
            p.push_back(n - p[p.size() - 1]);
        }
    }
    p.push_back(n);

    for (int i = 0; i < n; i++) {
        cout << p[i] << " ";
    }

    return 0;
}
