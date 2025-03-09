#include <string>
#include <vector>

using namespace std;

string solution(string s) {
    int index = 0;
    for(auto& c : s){
        if(c == ' '){
            index = 0;
            continue;
        }
        if(index==0) c = toupper(c);
        else c = tolower(c);
        index++;
    }
    return s;
}