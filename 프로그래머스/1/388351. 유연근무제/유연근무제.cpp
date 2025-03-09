#include <string>
#include <vector>
#include <iostream>

using namespace std;

int limit(int time){
    return (time+10)%100 >= 60 ? time+50 : time+10;
}

int solution(vector<int> schedules, vector<vector<int>> timelogs, int startday) {
    int answer = 0;
    for(int i=0; i<timelogs.size(); i++){
        bool flag = true;
        for(int j=startday; j<startday+7; j++){
            if(j%7==6 || j%7==0) continue;
            if(timelogs[i][j-startday] > limit(schedules[i])) flag = false;
        }
        if(flag) answer++;
        cout << endl;
    }
    
    return answer;
}