#include <iostream>
#include <string>
#include <deque>
using namespace std;

int solution(string s)
{
    deque<char> dq;
    for(auto c : s){
        if(!dq.empty() && dq.back() == c){
            dq.pop_back();
            continue;
        }
        dq.push_back(c);
    }
    return dq.empty() ? 1 : 0;
}