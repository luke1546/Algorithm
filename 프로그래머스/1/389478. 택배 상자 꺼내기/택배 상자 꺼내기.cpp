#include <string>
#include <vector>
#include <iostream>
using namespace std;

int solution(int n, int w, int num) {
    int answer = 0;
    int R = n/w+1;
    int C = w;
    int map[100][10] = {};
    int cnt = 1;
    int nr, nc;
    for(int i=0; i<R; i++){
        for(int j=0; j<C; j++){
            int c = j;
            if(i&1) c = C-j-1;
            map[i][c] = cnt;
            if(cnt == num){
                nr = i;
                nc = c;
            }
            cnt++;
            if(cnt > n) break;
        }
        if(cnt > n) break;
    }
    
    while(true){
        if(nr >= 0 && nr < R && nc >= 0 && nc < C && map[nr][nc] != 0) answer++;
        else break;
        nr++;
    }
    return answer;
}