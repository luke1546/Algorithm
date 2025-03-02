#include <string>
#include <vector>
#include <iostream>

using namespace std;

string solution(string s, int n) {
    string answer = "";
    for(int i=0; i<s.size(); i++){
        bool flag = false;
        int x = s[i];
        if(x <= 'Z') flag = true;
        if(x != ' ') x+=n;
        if((flag && x > 'Z') || x > 'z') x-=26;
        s[i] = (char)x;
    }
    return s;
}