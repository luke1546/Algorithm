#include <string>
#include <vector>
#include <unordered_set>
#include <iostream>
using namespace std;

int R = 5;
int result = 0;
int nG;
vector<int> selected(5);
vector<vector<int>> qG;
vector<int> ansG;

int match(vector<int> selected, vector<int> v){
    int cnt = 0;
    unordered_set<int> s(v.begin(), v.end());
    for(auto i : selected){
        if(s.count(i)) cnt++;
    }
    return cnt;
}

void 조합(int start, int cnt){
    if(cnt == R){
        int same = 0;
        for(int i=0; i<qG.size(); i++){
            if(match(selected, qG[i]) == ansG[i]) same++;
        }
        if(same == ansG.size()) result++;
        return;
    }
    for(int i=start; i<=nG; i++){
        selected[cnt] = i;
        조합(i+1, cnt+1);
    }
}

int solution(int n, vector<vector<int>> q, vector<int> ans) {
    qG = q;
    ansG = ans;
    nG = n;
    조합(1,0);
    return result;
}