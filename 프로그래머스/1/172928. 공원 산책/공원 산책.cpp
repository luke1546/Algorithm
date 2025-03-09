#include <string>
#include <vector>
#include <unordered_map>
using namespace std;

int dirs[4][2] = {{-1,0}, {0,1}, {1,0}, {0,-1}};

vector<int> solution(vector<string> park, vector<string> routes) {
    vector<int> answer;
    unordered_map<char, int*> um;
    int R = park.size();
    int C = park[0].size();
    um['N'] = dirs[0];
    um['E'] = dirs[1];
    um['S'] = dirs[2];
    um['W'] = dirs[3];
    int cur[2] = {};
    for(int i=0; i<R; i++){
        for(int j=0; j<C; j++){
            if(park[i][j] == 'S'){
                cur[0] = i;
                cur[1] = j;
            }
        }
    }
    for(auto route : routes){
        bool flag = true;
        int dis = (route[2] - '0');
        int nr = cur[0];
        int nc = cur[1];
        for(int i=0; i<dis; i++){
            nr += um[route[0]][0];
            nc += um[route[0]][1];
            if(nr < 0 || nr >= R || nc < 0 || nc >= C || park[nr][nc] == 'X')
            {
                flag = false;
                break;
            }
        }
        if(flag){
            cur[0] = nr;
            cur[1] = nc;
        }
    }
    return {cur[0], cur[1]};
}