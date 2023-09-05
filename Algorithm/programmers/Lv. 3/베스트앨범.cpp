#include <string>
#include <vector>
#include <unordered_map>
#include <algorithm>

using namespace std;

bool cmp(const pair<string, int>& a, const pair<string, int>& b) {
    return a.second > b.second;
}

bool cmp2(const pair<int, int>& a, const pair<int, int>& b) {
    if (a.second == b.second) return a.first < b.first;
    else return a.second > b.second;
}

vector<int> solution(vector<string> genres, vector<int> plays) {
    unordered_map<string, int> genre_total_plays;
    unordered_map<string, vector<pair<int, int>>> genre_songs;
    for (int i = 0; i < genres.size(); i++) {
        genre_total_plays[genres[i]] += plays[i];
        genre_songs[genres[i]].emplace_back(i, plays[i]);
    }
    
    vector<pair<string, int>> sorted_genres;
    for (const auto& [g, total] : genre_total_plays) {
        sorted_genres.emplace_back(g, total);
    }
    sort(sorted_genres.begin(), sorted_genres.end(), cmp);
    
    vector<int> answer;
    for (const auto& [g, total] : sorted_genres) {
        auto& ss = genre_songs[g];
        sort(ss.begin(), ss.end(), cmp2); 
        for (int i = 0; i < min(2, static_cast<int>(ss.size())); i++) { 
            answer.push_back(ss[i].first);
        }
    }
    return answer;
}
