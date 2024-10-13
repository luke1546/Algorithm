#include <string>
#include <iostream>
using namespace std;

bool solution(string s)
{
    int cnt = 0;
    for(int i=0; i<s.size(); i++){
        if(s[i] == 'p' || s[i] == 'P') cnt++;
        else if(s[i] == 'y' || s[i] == 'Y') cnt--;
    }
    return cnt==0 ? true : false;
}