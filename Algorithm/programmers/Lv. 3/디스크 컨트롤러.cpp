#include <string>
#include <vector>
#include <algorithm>
#include <queue>

using namespace std;

bool cmp(vector<int>& a, vector<int>& b) {
    if (a[0] != b[0]) return a[0] < b[0];
    else return a[1] < b[1];
}

int solution(vector<vector<int>> jobs) {
    sort(jobs.begin(), jobs.end(), cmp);

    int answer = 0;
    int end_time = 0;
    int n = jobs.size();
    vector<bool> did(n, 0);
    for (int i = 0; i < n; ) {
        priority_queue<pair<int, int>> pq; //required(-), idx
        int j = i;
        while (j < n && jobs[j][0] <= end_time) {
            if (!did[j]) pq.push({ -1 * jobs[j][1], j});
            j++;
        }
        int required, idx;
        if (!pq.empty()) {
            required = pq.top().first * -1;
            idx = pq.top().second;
        } else {
            required = jobs[i][1];
            idx = i;
            i++;
        }
        answer += required + max(0, end_time - jobs[idx][0]);
        end_time += required + max(0, jobs[idx][0] - end_time);
        did[idx] = 1;

        while (i < n && did[i]) i++;
    }
    answer /= n;

    return answer;
}
