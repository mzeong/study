/*
첫 번째 풀이
*/
#include <iostream>
#include <vector>
using namespace std;

int solution(int n, vector<int> stations, int w)
{
    int answer = 0;
    int i = 1;
    int k = w * 2 + 1;
    for (auto s : stations) {
        int j = s - w - i;
        answer += j / k + (j % k > 0 ? 1 : 0);
        i = s + w + 1;
    }
    if (i <= n) {
        int j = n - i + 1;
        answer += j / k + (j % k > 0 ? 1 : 0);
    }
    return answer;
}

/*
두 번째 풀이
*/
#include <iostream>
#include <vector>
#include <cmath>
#include <algorithm>
using namespace std;

int solution(int n, vector<int> stations, int w)
{
    int answer = 0;
    int p = 1;
    int coverage = w * 2 + 1;
    for (auto s : stations) {
        int d = s - w - p;
        int requiredStations = ceil((double)d / coverage);
        answer += max(0, requiredStations); 
        p = s + w + 1;
    }
    answer += ceil((double)(n - p + 1) / coverage); 
    return answer;
}
