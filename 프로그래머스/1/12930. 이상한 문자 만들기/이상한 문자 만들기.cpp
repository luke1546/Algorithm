#include <string>
#include <vector>

using namespace std;

string solution(string s) {
    int index = 0;
    for(auto& c : s){
        if(c == ' ') {
            index=0;
            continue;
        }
        index&1 ? c = tolower(c) : c = toupper(c);
        index++;
    }
    return s;
}