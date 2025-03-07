#include <string>
#include <vector>
#include <map>
#include <algorithm>
#include <iostream>

using namespace std;
bool compare(const pair<char, int>& p1, const pair<char, int>& p2){
    return p1.second == p2.second ? p1.first < p2.first : p1.second > p2.second;
}

string solution(vector<string> survey, vector<int> choices) {
    string answer = "";
    map<char, int> typeScore;
    typeScore['R'];
    typeScore['T'];
    typeScore['C'];
    typeScore['F'];
    typeScore['J'];
    typeScore['M'];
    typeScore['A'];
    typeScore['N'];
    for(int i=0; i<choices.size(); i++){
        switch(choices[i]){
            case 1:
            case 2:
            case 3:
                typeScore[survey[i][0]] += 4-choices[i];
                break;
            case 5:
            case 6:
            case 7:
                typeScore[survey[i][1]] += choices[i]-4;
                break;
        }
    }
    answer += (typeScore['R'] >= typeScore['T'] ? "R" : "T");
    answer += (typeScore['C'] >= typeScore['F'] ? "C" : "F");
    answer += (typeScore['J'] >= typeScore['M'] ? "J" : "M");
    answer += (typeScore['A'] >= typeScore['N'] ? "A" : "N");
    for(auto s : typeScore) cout << s.first << s.second << "\n";
    return answer;
}