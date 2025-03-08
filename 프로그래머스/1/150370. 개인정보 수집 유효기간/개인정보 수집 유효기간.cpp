#include <string>
#include <vector>
#include <iostream>
#include <unordered_map>
using namespace std;

vector<string> split(string str, char delimeter){
    vector<string> result;
    int start = 0, end;
    while((end = str.find(delimeter, start)) != string::npos){
        result.push_back(str.substr(start, end-start));
        start = end + 1;
    }
    result.push_back(str.substr(start));
    return result;
}

vector<int> solution(string today, vector<string> terms, vector<string> privacies) {
    vector<int> answer;
    unordered_map<string, int> um;
    for(auto s : terms){
        vector<string> v = split(s, ' ');
        um[v[0]] = stoi(v[1]);
    }
    int index = 0;
    for(auto s : privacies){
        index++;
        vector<string> v = split(s, ' ');
        vector<string> date = split(v[0], '.');
        vector<string> date2 = split(today, '.');
        int term = um[v[1]];
        vector<int> dateI;
        vector<int> todayI;
        for(int i=0; i<3; i++){
            dateI.push_back(stoi(date[i]));
            todayI.push_back(stoi(date2[i]));
        }
        dateI[1] += term;
        dateI[0] += ((dateI[1]-1) / 12);
        dateI[1]--;
        dateI[1] %= 12;
        dateI[1]++;
        for(int i=0; i<3; i++){
            if(todayI[i] > dateI[i]){
                answer.push_back(index);
                break;
            }else if(todayI[i] < dateI[i]) break;
            else if(i == 2 && todayI[i] == dateI[i]){
                answer.push_back(index);
                break;
            }
        }
    }
    return answer;
}