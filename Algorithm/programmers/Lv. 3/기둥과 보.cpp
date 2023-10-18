#include <string>
#include <vector>

using namespace std;

int arr[101][101][2];
int N;

bool install_item(int x, int y, int a) {
    if (a == 0) { //기둥
        if (y == 0) return true; //바닥 위
        if (x > 0 && arr[x-1][y][1]) return true; //보의 한쪽 끝 부분 위
        if (y < N && arr[x][y][1]) return true;
        if (y > 0 && arr[x][y-1][0]) return true; //다른 기둥 위
    } else { //보
        if (y > 0 && arr[x][y-1][0]) return true; //한쪽 끝 부분이 기둥 위 
        if (x < N && y > 0 && arr[x+1][y-1][0]) return true;
        if (x > 0 && x < N && arr[x-1][y][1] && arr[x+1][y][1]) return true; //양쪽 끝 부분이 다른 보
    }
    return false;
}

bool remove_item(int x, int y, int a) {
    arr[x][y][a] = 0;
    
    if (a == 0) { //기둥 
        if (y < N && arr[x][y+1][0] && !install_item(x, y+1, 0)) return false;
        
        if (y < N && arr[x][y+1][1] && !install_item(x, y+1, 1)) return false;
        if (x > 0 && y < N && arr[x-1][y+1][1] && !install_item(x-1, y+1, 1)) return false;
    } else { //보
        if (arr[x][y][0] && !install_item(x, y, 0)) return false;
        if (x < N && arr[x+1][y][0] && !install_item(x+1, y, 0)) return false;
        
        if (x > 0 && arr[x-1][y][1] && !install_item(x-1, y, 1)) return false;
        if (x < N && arr[x+1][y][1] && !install_item(x+1, y, 1)) return false;
    }
    return true;
}

vector<vector<int>> solution(int n, vector<vector<int>> build_frame) {
    N = n;
    
    for (const auto& frame : build_frame) {
        int x = frame[0];
        int y = frame[1];
        int a = frame[2];
        int b = frame[3];
        
        if (b == 0) { //삭제
            if(!remove_item(x, y, a)) arr[x][y][a] = 1;
        } else { //설치
            if (install_item(x, y, a)) arr[x][y][a] = 1;
        }
    }
    
    vector<vector<int>> answer;
    for (int i = 0; i <= n; i++) {
        for (int j = 0; j <= n; j++) {
            if (arr[i][j][0]) answer.push_back({i, j, 0});
            if (arr[i][j][1]) answer.push_back({i, j, 1});
        }
    }
    return answer;
}
