#include <string>
#include <vector>
#include <unordered_map>
using namespace std;

string solution(vector<string> participant, vector<string> completion) {
    unordered_map<string, int> umap;
    string ans = "";
    for(auto s : participant)
        umap[s]++;
    for(auto s : completion)
        umap[s]--;
    for(auto p : umap){
        if(p.second == 1) ans = p.first;
    }
    return ans;
}