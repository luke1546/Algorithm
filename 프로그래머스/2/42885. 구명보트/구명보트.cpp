#include <string>
#include <vector>
#include <deque>
#include <algorithm>
#include <iostream>
using namespace std;

int solution(vector<int> people, int limit) {
    int answer = 0;
    int cnt = 0;
    sort(people.begin(), people.end());
    vector<bool> visit(people.size(), false);
    for(int i=people.size()-1; i>=0; i--){
        if(visit[i]) continue;
        answer++;
        cnt++;
        int find = limit - people[i];
        int index = upper_bound(people.begin(), people.begin()+i, find) - people.begin() - 1;
        while(index >= 0){
            if(!visit[index]) {
                visit[index] = true;
                cnt++;
                break;
            }
            else index--;
        }
        if(cnt == people.size()) break;
    }
    return answer;
}