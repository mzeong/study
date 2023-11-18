#include<iostream>
#include<vector>
using namespace std;

const int n_ = 11111;

int main(int argc, char** argv)
{
	int test_case;
	int T;
	cin >> T;
	
	for (test_case = 1; test_case <= T; ++test_case)
	{
		int n, m, k; cin >> n >> m >> k; //m초에 k개 생성 
		vector<int> arr(n_ + 1);
		for (int i = 0; i < n; i++) {
			int input; cin >> input;
			arr[input]++;
		}

		bool isPossible = true;
		int cnt = 0;
		for (int i = 0; i < arr.size(); i++) { //0이상 11111이하에 도착
			if (i > 0 && i % m == 0) cnt += k;
			if (arr[i] <= cnt) cnt -= arr[i];
			else {
				isPossible = false;
				break;
			}
		}
		cout << "#" << test_case << " ";
		cout << (isPossible ? "Possible" : "Impossible") << "\n";
	}
	return 0;
}