#include <string>
#include <vector>
#include <unordered_set>
#include <unordered_map>
#include <iostream>
using namespace std;

vector<int> solution(vector<string> id_list, vector<string> report, int k) {
    vector<int> answer;
    unordered_map<string, int> 신고당한횟수;
    unordered_map<string, vector<string>> 신고한사람;
    unordered_set<string> reportSet(report.begin(), report.end());
    for(auto s : reportSet){
        int index = s.find(" ");
        string a = s.substr(0, index);
        string b = s.substr(index+1);
        신고한사람[a].push_back(b);
        신고당한횟수[b]++;
    }
    for(string s : id_list){
        int cnt = 0;
        for(auto ele : 신고한사람[s]){
            if(신고당한횟수[ele] >= k) cnt++;
        }
        answer.push_back(cnt);
    }
    return answer;
}