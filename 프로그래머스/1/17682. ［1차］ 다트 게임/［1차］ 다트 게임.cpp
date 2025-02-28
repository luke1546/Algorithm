#include <string>
#include <algorithm>
#include <iostream>
using namespace std;

int solution(string dartResult) {
    int answer = 0;
    string str[3] = {};
    int index = -1;
    for(int i=0; i<dartResult.size(); i++){
        if(dartResult[i] >= '0' && dartResult[i] <= '9'){
            index++;
        }
        if(i != 0 && dartResult[i] == '0' && dartResult[i-1] >= '1' && dartResult[i-1] <= '9')
            index--;
        str[index] += dartResult[i];
    }
    int before = 0;
    for(auto s : str) {
        int sum = 0;
        for(auto c : s){
            if(c >= '1' && c <= '9')
                sum += (c-'0');
            else if(c=='0') sum *= 10;
            else if(c == 'D') sum*=sum;
            else if(c == 'T') sum*=(sum*sum);
            else if(c == '#') sum *=-1;
            else if(c == '*') {
                sum = (sum*2);
                answer+=before;
            }
        }
        answer+=sum;
        before=sum;
        cout << s << endl;
        // cout << sum << endl;
    }
    return answer;
}