#include <string>
#include <vector>

using namespace std;

int str_to_int(const string& str) {
    int h = stoi(str.substr(0, 2));
    int m = stoi(str.substr(3, 2));
    int s = stoi(str.substr(6, 2));
    
    return h * 60 * 60 + m * 60 + s;
}

string int_to_str(int i) {
    int s = i % 60;
    i /= 60;
    int m = i % 60;
    i /= 60;
    int h = i;
    
    string result = "";
    if (h < 10) result += "0";
    result += to_string(h);
    result += ":";
    if (m < 10) result += "0";
    result += to_string(m);
    result += ":";
    if (s < 10) result += "0";
    result += to_string(s);
    
    return result;
}

string solution(string play_time, string adv_time, vector<string> logs) {
    int total = str_to_int(play_time);
    vector<int> vps(total); //viewers per second
    for (const auto& log : logs) {
        int s = str_to_int(log.substr(0, 8));
        int e = str_to_int(log.substr(9, 8));
        for (int i = s; i < e; i++) {
            vps[i]++;
        }
    }
    
    int adv = str_to_int(adv_time);
    long long sum = 0; //test 17
    for (int i = 0; i < adv; i++) {
        sum += vps[i];
    }

    long long max = sum;
    int answer = 0;
    for (int s = 0, e = adv; e < total; s++, e++) {
        sum -= vps[s];
        sum += vps[e];
        
        if (max < sum) {
            max = sum;
            answer = e - adv + 1;
        }
    }

    return int_to_str(answer);
}
