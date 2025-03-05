#include <string>
#include <vector>
#include <deque>
#include <iostream>
using namespace std;
vector<vector<int>> map;
int move(int x){
    x--;
    for(int i=0; i<map.size(); i++){
        if(map[i][x] != 0){
            int v = map[i][x];
            map[i][x] = 0;
            return v;            
        }
    }
    return 0;
}

int solution(vector<vector<int>> board, vector<int> moves) {
    int answer = 0;
    map = board;
    deque<int> dq;
    for(int i : moves){
        int v = move(i);
        cout << v << " ";
        if(v != 0){
            if(!dq.empty() && dq.back() == v) {
                dq.pop_back();
                answer++;
            }
            else {
                dq.push_back(v);
            }
        }
    }
    return answer*2;
}