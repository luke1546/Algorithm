#include <string>
#include <vector>
#include <iostream>
#include <algorithm>
using namespace std;

int solution(int n) {
    int answer = 0;
    string str = "";
    while(n){
        str+=to_string(n%3);
        n/=3;
    }
    int x = 1;
    for(int i=str.size()-1; i>=0; i--){
        answer+=((str[i]-'0')*x);
        x*=3;
    }
    return answer;
}