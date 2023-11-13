#include<iostream>
#include <vector>
using namespace std;

int dy[4] = { 0, 1, 0, -1 };
int dx[4] = { 1, 0, -1, 0 };

void dfs(vector<vector<int>>& arr, int y, int x, int num, int n, int dir) {
	arr[y][x] = num;
	if (num == n*n) return;
	
	int ny = y + dy[dir];
	int nx = x + dx[dir];
	if (ny < 0 || ny >= n || nx < 0 || nx >= n || arr[ny][nx]) {
		dir = (dir + 1) % 4;
		ny = y + dy[dir];
		nx = x + dx[dir];
	}
	dfs(arr, ny, nx, num + 1, n, dir);
}

int main(int argc, char** argv)
{
	int test_case;
	int T;
	cin >> T;
	
	for (test_case = 1; test_case <= T; ++test_case)
	{
		int n; cin >> n;
		vector<vector<int>> arr(n, vector<int>(n));
		dfs(arr, 0, 0, 1, n, 0);
		cout << "#" << test_case << "\n";
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				cout << arr[i][j] << " ";
			}
			cout << "\n";
		}
	}
	return 0;
}
