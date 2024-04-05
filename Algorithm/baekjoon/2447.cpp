#include <iostream>
using namespace std;

int main()
{
    ios::sync_with_stdio(false); cin.tie(0);
    
    int n; cin >> n;
    for (int i = 0; i < n; i++) {
        for (int j = 0; j < n; j++) {
            int m = n / 3;
            while (m > 0) {
                if (i / m % 3 == 1 && j / m % 3 == 1) {
                    cout << " ";
                    break;
                }
                m /= 3;
            }
            if (m == 0) {
                cout << "*";
            }
        }
        cout << "\n";
    }

    return 0;
}
