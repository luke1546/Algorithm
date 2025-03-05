#include <string>
#include <vector>
#include <algorithm>
#include <set>
#include <iostream>
using namespace std;

int solution(int n, vector<int> lost, vector<int> reserve) {
    bool flag[30] = {};
    int answer = 0;
    for(int i : lost) flag[i-1] = true;
    set<int> s(reserve.begin(), reserve.end());
    for(int i : s) {
        if(flag[i-1]) {
            s.erase(i);
            flag[i-1] = false;
        }
    }
    for(int i : s){
        if(i-2 >= 0 && flag[i-2]) flag[i-2] = false;
        else if(i < n) flag[i] = false;
    }
    for(int i=0; i<n; i++) if(!flag[i]) answer++;
    return answer;
}