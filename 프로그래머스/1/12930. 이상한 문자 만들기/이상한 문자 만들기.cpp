#include <string>
#include <vector>

using namespace std;

void replaceAll(string& s, string from, string to){
    int pos = 0;
    while((pos = s.find(from, pos)) != string::npos){
        s.replace(pos, from.size(), to);
        pos+=to.size();
    }
}

string solution(string s) {
    int index = 0;
    for(auto& c : s){
        if(c == ' ') {
            index=0;
            continue;
        }
        if(index&1) c = tolower(c);
        else c = toupper(c);
        index++;
    }
    // int pos = 0;
    // while(s.find("  ") != string::npos)
    //     replaceAll(s, "  ", " ");
    // if(s[0] == ' ') s.erase(s.begin());
    // if(s[s.size()-1] == ' ') s.erase(s.end()-1);
    return s;
}