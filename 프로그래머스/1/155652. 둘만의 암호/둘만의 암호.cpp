#include <string>
#include <vector>
#include <unordered_set>
using namespace std;

string solution(string s, string skip, int index) {
    unordered_set<char> uset;
    for(auto c : skip) uset.insert(c);
    for(auto& c : s){
        for(int i=0; i<index; i++){
            c++;
            if(c > 'z') c-=26;
            while(uset.count(c)){
                c++;
                if(c > 'z') c-=26;
            } 
        }
    }
    return s;
}