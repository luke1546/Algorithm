#include <string>
#include <vector>
#include <cmath>
using namespace std;

vector<int> solution(int brown, int yellow) {
    vector<int> answer;
    vector<pair<int,int>> vec;
    int sum = brown + yellow;
    for(int i=1; i<=sqrt(sum); i++){
        if(sum%i==0){
            vec.push_back({i,sum/i});
        }
    }
    for(auto p : vec){
        if(2*(p.first-1 + p.second-1) == brown){
            answer.push_back(max(p.first,p.second));
            answer.push_back(min(p.first,p.second));
        }
    }
    return answer;
}