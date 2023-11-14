#include<iostream>
#include<vector>
using namespace std;

int n;
int answer;
vector<int> col(10);

bool check(int row) {
	for (int i = 0; i < row; i++) {
		if (col[i] == col[row]) return false;
		if (abs(col[row] - col[i]) == row - i) return false;
	}
	return true;
}

void nqueen(int row) {
	if (row == n) {
		answer++;
	} else {
		for (int i = 0; i < n; i++) {
			col[row] = i;
			if (check(row)) nqueen(row + 1);
		}
	}
}

int main(int argc, char** argv)
{
	int test_case;
	int T;
	cin >> T;
	
	for (test_case = 1; test_case <= T; ++test_case)
	{
		cin >> n;

		answer = 0;
		col.clear();
		col.resize(n);
		
		nqueen(0);

		cout << "#" << test_case << " " << answer << "\n";
	}
	return 0;
}
