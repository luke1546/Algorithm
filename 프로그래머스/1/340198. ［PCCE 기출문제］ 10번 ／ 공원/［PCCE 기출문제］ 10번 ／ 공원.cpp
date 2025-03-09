#include <string>
#include <vector>
#include <iostream>

using namespace std;
int R, C;

int check(vector<vector<string>> park, int r, int c){
    int s = min(R,C);
    int cnt = 1;
    int flag = true;
    for(int i=1; i<=s; i++){
        for(int j=0; j<=i; j++) {
            int nr = r+j;
            int nc = c+i;
            if(nr < 0 || nr >= R || nc < 0 || nc >= C || park[nr][nc] != "-1")
                flag = false;
        }   
        for(int j=0; j<=i; j++) {
            int nr = r+i;
            int nc = c+j;
            if(nr < 0 || nr >= R || nc < 0 || nc >= C || park[nr][nc] != "-1")
                flag = false;
        }
        if(flag) cnt++;
        else break;
    }
    return cnt;
}

int solution(vector<int> mats, vector<vector<string>> park) {
    int answer = 0;
    R = park.size();
    C = park[0].size();
    int maxSize = 0;
    for(int i=0; i<R; i++){
        for(int j=0; j<C; j++){
            if(park[i][j] == "-1") maxSize = max(maxSize,check(park, i, j));
        }
    }
    cout << maxSize;
    for(auto i : mats){
        if(i <= maxSize) answer=max(i, answer);
    }
    return answer == 0 ? -1 : answer;
}