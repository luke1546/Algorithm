#include <string>
#include <vector>
#include <iostream>
#include <unordered_set>

using namespace std;

vector<int> solution(int n, vector<string> words) {
    vector<int> answer;
    unordered_set<string> uset;
    int turn = 1;
    int cnt = 0;
    string before = "";
    for(auto word : words){
        cnt++;
        if(cnt > n) {
            cnt-=n;
            turn++;
        }
        if(uset.count(word) || !before.empty() && before[before.size()-1] != word[0]) return {cnt, turn};
        uset.insert(word);
        before = word;
    }
    return {0,0};
}