#include<string>
#include <iostream>
#include <deque>
using namespace std;

bool solution(string s)
{
    deque<char> dq;
    for(auto c : s){
        if(c == '(') dq.push_back(c);
        else{
            if(!dq.empty() && dq.back() == '(') dq.pop_back();
            else{
                dq.push_back(c);
            }
        }
    }
    return dq.empty();
}