#include <string>
#include <vector>
// 12345      5
// 21232425   8
// 3311224455 10
using namespace std;

vector<int> solution(vector<int> answers) {
    vector<int> answer;
    vector<int> p1 = {1,2,3,4,5};
    vector<int> p2 = {2,1,2,3,2,4,2,5};
    vector<int> p3 = {3,3,1,1,2,2,4,4,5,5};
    int ans[3] = {};
    for(int i=0; i<answers.size(); i++){
        if(answers[i] == p1[i%5]) ans[0]++;
        if(answers[i] == p2[i%8]) ans[1]++;
        if(answers[i] == p3[i%10]) ans[2]++;
    }
    int maxValue = 0;
    for(int i=0; i<3; i++){
        maxValue = max(maxValue, ans[i]);
    }
    for(int i=0; i<3; i++){
        if(ans[i] == maxValue) answer.push_back(i+1);
    }
    return answer;
}