#include <string>
#include <vector>
#include <unordered_map>
using namespace std;
unordered_map<string, int> 선물지수;
unordered_map<string, int> nameToNum;
vector<vector<int>> 선물기록;
bool compare(string f1, string f2){
    int score1 = 선물기록[nameToNum[f1]][nameToNum[f2]];
    int score2 = 선물기록[nameToNum[f2]][nameToNum[f1]];
    if(score1 == score2){
        if(선물지수[f1] > 선물지수[f2]) return true;
    }else if(score1 > score2) return true;
    return false;
}

int solution(vector<string> friends, vector<string> gifts) {
    for(int i=0; i<friends.size(); i++){
        nameToNum[friends[i]] = i;
    }
    선물기록.resize(friends.size(), vector<int>(friends.size(),0));
    for(auto gift : gifts){
        int index = gift.find(" ");
        string from = gift.substr(0, index);
        string to = gift.substr(index+1);
        선물지수[from]++;
        선물지수[to]--;
        선물기록[nameToNum[from]][nameToNum[to]]++;
    }
    int maxValue = 0;
    for(int i=0; i<friends.size(); i++){
        int ans = 0;
        for(int j=0; j<friends.size(); j++){
            if(i==j) continue;
            if(compare(friends[i], friends[j])) ans++;
        }
        maxValue = max(maxValue, ans);
    }
    return maxValue;
}