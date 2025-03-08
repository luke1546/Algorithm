#include <string>
#include <vector>

using namespace std;

vector<int> solution(vector<string> wallpaper) {
    vector<int> answer;
    int minValue[2] = {999, 999};
    int maxValue[2] = {};
    for(int i=0; i<wallpaper.size(); i++){
        for(int j=0; j<wallpaper[0].size(); j++){
            if(wallpaper[i][j] == '#'){
                minValue[0] = min(minValue[0], i);
                minValue[1] = min(minValue[1], j);
                maxValue[0] = max(maxValue[0], i);
                maxValue[1] = max(maxValue[1], j);
            }
        }
    }
    answer.push_back(minValue[0]);
    answer.push_back(minValue[1]);
    answer.push_back(maxValue[0]+1);
    answer.push_back(maxValue[1]+1);
    return answer;
}