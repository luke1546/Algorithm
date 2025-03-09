#include <string>
#include <vector>
#include <iostream>
using namespace std;

int zero = 0;
int cnt = 0;
void replaceAll(string& s, string from, string to){
    int pos = 0;
    while((pos = s.find(from, pos)) != string::npos){
        s.replace(pos, from.size(), to);
        pos+=to.size();
    }
}

void 이진변환(string& s){
    int before = s.size();
    replaceAll(s, "0", "");
    zero += before-s.size();
    int x = s.size();
    string b = "";
    while(x){
        b = to_string(x%2) + b;
        x/=2;
    }
    s = b;
}

vector<int> solution(string s) {
    while(s != "1"){
        이진변환(s);
        cnt++;
    }
    return {cnt,zero};
}