#include <string>
#include <vector>
#include <string.h>

using namespace std;

int used[9];
int answer;

void dfs(int cur, int cnt, vector<int> weak_dist, vector<int> dist, int start) {
    if (cnt > 0 && cur == start) {
        answer = min(answer, cnt);
    }
    
    for (int i = 0; i < dist.size(); i++) {
        if (used[i]) continue;
        if (dist[i] < weak_dist[cur]) { // 테스트 11, 12, 14, 22, 25 실패 - 친구가 하나의 취약 지점 점검
            used[i] = 1;
            dfs((cur + 1) % weak_dist.size(), cnt + 1, weak_dist, dist, start);
            used[i] = 0;
        } else { // 친구가 둘 이상의 취약 지점 점검
            int weak_dist_sum = weak_dist[cur];
            int nxt = (cur + 1) % weak_dist.size();
            while (dist[i] >= weak_dist_sum + weak_dist[nxt] && (nxt + 1) % weak_dist.size() != start) {
                weak_dist_sum += weak_dist[nxt];
                nxt = (nxt + 1) % weak_dist.size();
            }

            used[i] = 1;
            dfs((nxt + 1) % weak_dist.size(), cnt + 1, weak_dist, dist, start);
            used[i] = 0;
        }
    }
}

int solution(int n, vector<int> weak, vector<int> dist) {
    int weak_size = weak.size();
    vector<int> weak_dist(weak_size);
    for (int i = 0; i < weak_size - 1; i++) {
        weak_dist[i] = weak[i + 1] - weak[i];
    }
    if (weak_size == 1) {
        weak_dist[weak_size - 1] = 0;
    } else {
        weak_dist[weak_size - 1] = n - weak[weak_size - 1] + weak[0];
    }
    
    int dist_size = dist.size();
    answer = dist_size + 1;
    for (int i = 0; i < weak_size; i++) {
        memset(used, 0, sizeof(used));
        dfs(i, 0, weak_dist, dist, i);
    }
    
    return answer == dist_size + 1 ? -1 : answer;
}
