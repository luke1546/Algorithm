#include <string>
#include <vector>
#include <algorithm>
using namespace std;

string to_binary(int x, int n){
    string s = "";
    while(x){
        s+=to_string(x%2);
        x/=2;
    }
    while(s.size() != n){
        s+="0";
    }
    reverse(s.begin(), s.end());
    for(int i=0; i<s.size(); i++){
        if(s[i] == '1') s[i] = '#';
        else s[i] = ' ';
    }
    return s;
}

vector<string> solution(int n, vector<int> arr1, vector<int> arr2) {
    vector<string> answer;
    for(int i=0; i<n; i++){
        int x = arr1[i] | arr2[i];
        answer.push_back(to_binary(x, n));
    }
    return answer;
}