#include <string>
#include <vector>
#include <unordered_map>

using namespace std;

vector<int> solution(vector<string> name, vector<int> yearning, vector<vector<string>> photo) {
    unordered_map<string, int> um;
    vector<int> answer;
    for(int i=0; i<name.size(); i++){
        um[name[i]] = yearning[i];
    }
    for(auto strs : photo){
        int sum = 0;
        for(auto str : strs){
            sum += um[str];
        }
        answer.push_back(sum);
    }
    return answer;
}