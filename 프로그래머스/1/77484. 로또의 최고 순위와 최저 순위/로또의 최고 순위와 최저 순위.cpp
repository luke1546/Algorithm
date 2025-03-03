#include <string>
#include <vector>
#include <unordered_set>
#include <algorithm>
using namespace std;

vector<int> solution(vector<int> lottos, vector<int> win_nums) {
    unordered_set<int> uset(lottos.begin(), lottos.end());
    int cnt = 0;
    for(int i : win_nums){
        if(uset.count(i)) cnt++;
    }
    int ans[7] = {6, 6, 5, 4, 3, 2, 1};
    vector<int> answer;
    answer.push_back(ans[cnt]);
    for(int x : lottos) if(x == 0) cnt++;
    answer.push_back(ans[cnt]);
    sort(answer.begin(), answer.end());
    return answer;
}