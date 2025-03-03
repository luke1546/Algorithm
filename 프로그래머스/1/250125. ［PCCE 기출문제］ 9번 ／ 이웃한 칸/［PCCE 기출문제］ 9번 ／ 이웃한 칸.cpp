#include <string>
#include <vector>
#include <iostream>
#include <unordered_map>
using namespace std;

int solution(vector<vector<string>> board, int h, int w) {
    int answer = 0;
    int dirs[4][2] = {{-1,0},{0,1},{1,0},{0,-1}};
    int R = board.size();
    int C = board.size();
    string str = board[h][w];
    for(int* dir : dirs){
        int nr = h + dir[0];
        int nc = w + dir[1];
        if(nr >= 0 && nr < R && nc >= 0 && nc < C){
            if(board[nr][nc] == str) answer++;
        }
    }
    return answer;
}