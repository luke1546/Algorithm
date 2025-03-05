#include <string>
#include <vector>
#include <iostream>

using namespace std;
int xx[11];
int yy[11];
int zz[11];
string solution(string X, string Y) {
    string answer = "";
    for(auto c : X) xx[c-'0']++;
    for(auto c : Y) yy[c-'0']++;
    for(int i=0; i<11; i++) zz[i] = min(xx[i],yy[i]);
    for(int i=10; i>=0; i--) {
        for(int j=0; j<zz[i]; j++) 
            answer+=(i+'0');
    }
    if(answer[0] == '0') answer = "0";
    return answer.empty() ? "-1" : answer;
}