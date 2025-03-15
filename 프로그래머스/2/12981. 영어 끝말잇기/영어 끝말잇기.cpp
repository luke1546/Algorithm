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
    bool fail = false;
    string before = "";
    for(auto word : words){
        cnt++;
        if(cnt > n) {
            cnt-=n;
            turn++;
        }
        if(uset.count(word)) {
            fail = true;
            break;
        }
        if(!before.empty() && before[before.size()-1] != word[0]) {
            fail = true;
            break;
        }
        uset.insert(word);
        before = word;
    }
    if(fail){
    answer.push_back(cnt);
    answer.push_back(turn);
    }else{
        answer.push_back(0);
        answer.push_back(0);
    }
    return answer;
}