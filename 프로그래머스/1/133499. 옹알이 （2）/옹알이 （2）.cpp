#include <string>
#include <vector>
using namespace std;

void replaceAll(string& s, const string& from, const string& to){
    int pos = 0;
    while((pos = s.find(from, pos)) != string::npos){
        s.replace(pos, from.size(), to);
        pos+=to.size();
    }
}

int solution(vector<string> babbling) {
    int answer = 0;
    for(auto& s : babbling){
        replaceAll(s, "ayaaya", " ");
        replaceAll(s, "yeye", " ");
        replaceAll(s, "woowoo", " ");
        replaceAll(s, "mama", " ");
        
        replaceAll(s, "aya", "1");
        replaceAll(s, "ye", "1");
        replaceAll(s, "woo", "1");
        replaceAll(s, "ma", "1");
        int cnt = 0;
        for(auto c : s){
            if(c == '1') cnt++;
        }
        if(s.size() == cnt) answer++;
    }
    return answer;
}