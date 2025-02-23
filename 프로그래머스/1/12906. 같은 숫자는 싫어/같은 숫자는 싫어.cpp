#include <vector>
#include <iostream>
#include <deque>

using namespace std;

vector<int> solution(vector<int> arr) 
{
    vector<int> answer;
    deque<int> dq(1,-1);
    for(auto i : arr){
        if(dq.front() != i) answer.push_back(i);
        dq.push_front(i);
    }
    return answer;
}