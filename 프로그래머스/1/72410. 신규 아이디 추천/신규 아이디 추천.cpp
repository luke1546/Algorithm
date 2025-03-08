#include <string>
#include <vector>
#include <iostream>

using namespace std;

void lower(string& str){ //1단계
    for(auto& c : str){
        c = tolower(c);
    }
}

void remove(string& str){
    for(int i=str.size()-1; i>=0; i--){
        if(str[i] != '.' && str[i] != '_' && str[i] != '-' && 
           (str[i] < '0' || str[i] >'9') && (str[i] < 'a' || str[i] > 'z'))
            str.erase(str.begin()+i);
    }
}

void replace(string& str, string from, string to){
    int pos = 0;
    while((pos = str.find(from, pos)) != string::npos){
        str.replace(pos, from.size(), to);
        pos += to.size();
    }
}

void removeStartEndDot(string& str){
    if(str.size() != 0 && str[0] == '.') str.erase(str.begin());
    if(str.size() != 0 && str[str.size()-1] == '.') str.erase(str.end()-1);
}

void removeBy15(string& str){
    if(str.size() >= 16) str.erase(str.begin() + 15, str.end());
}

void addBy3(string& str){
    while(str.size() <= 2){
        str += str[str.size()-1];
    }
}

string solution(string new_id) {
    lower(new_id);
    remove(new_id);
    replace(new_id, "..", ".");
    while(new_id.find("..") != string::npos)
        replace(new_id, "..", ".");
    removeStartEndDot(new_id);
    if(new_id.size() == 0) new_id="a";
    removeBy15(new_id);
    removeStartEndDot(new_id);
    addBy3(new_id);
    return new_id;
}