#include <string>
#include <vector>
#include <iostream>
using namespace std;

int solution(string s) {
    int answer = 0;
    int x = 0;
    char xc = 'a';
    for(char c : s){
        if(x == 0) {
            xc = c;
            x++;
            answer++;
        }else if(xc == c) x++;
        else x--;
    }
    return answer;
}