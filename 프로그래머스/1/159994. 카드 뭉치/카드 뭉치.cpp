#include <string>
#include <vector>
#include <deque>

using namespace std;

string solution(vector<string> cards1, vector<string> cards2, vector<string> goal) {
    deque<string> dq1(cards1.begin(),cards1.end());
    deque<string> dq2(cards2.begin(),cards2.end());
    for(auto s : goal){
        if(!dq1.empty() && s == dq1.front()) dq1.pop_front();
        else if(!dq2.empty() && s == dq2.front()) dq2.pop_front();
        else return "No";
    }
    return "Yes";
}