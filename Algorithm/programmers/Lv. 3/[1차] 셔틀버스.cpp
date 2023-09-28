#include <string>
#include <vector>
#include <algorithm>

using namespace std;

string solution(int n, int t, int m, vector<string> timetable) {
    sort(timetable.begin(), timetable.end());
    
    int bus_h = 9, bus_m = 0;
    int j = 0;
    string answer = "";
    for (int i = 0; i < n; i++) {
        int cnt = 0;
        int k = j;
        while(cnt < m && k < timetable.size()) {
            int cur_h = stoi(timetable[k].substr(0, 2));
            int cur_m = stoi(timetable[k].substr(3, 2));
            
            if (cur_h < bus_h || (cur_h == bus_h && cur_m <= bus_m)) k++, cnt++; //버스 탑승 가능 
            else break;
        }

        if (cnt == m) { //만석이면 마지막 사람보다 빨리 와야 함 
            int con_h = stoi(timetable[j + cnt - 1].substr(0, 2));
            int con_m = stoi(timetable[j + cnt - 1].substr(3, 2));
            
            con_m -= 1;
            if (con_m < 0) con_m = 59, con_h -= 1;
            
            answer = (con_h < 10 ? "0" + to_string(con_h) : to_string(con_h));
            answer += ":";
            answer += (con_m < 10 ? "0" + to_string(con_m) : to_string(con_m));
        } else { //자리 있으면 버스 출발할 때 오면 됨 
            answer = (bus_h < 10 ? "0" + to_string(bus_h) : to_string(bus_h));
            answer += ":";
            answer += (bus_m < 10 ? "0" + to_string(bus_m) : to_string(bus_m));
        }
        j += cnt;
        
        if (j >= timetable.size()) break;
        
        bus_m += t;
        if (bus_m >= 60) bus_m -= 60, bus_h += 1;
    }
    
    return answer;
}
