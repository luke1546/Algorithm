#include <string>
#include <vector>
#include <unordered_map>
using namespace std;

vector<int> solution(vector<string> keymap, vector<string> targets) {
    vector<int> answer;
    unordered_map<char, int> umap;
    for(auto s : keymap){
        for(int i=0; i<s.size(); i++){
            if(umap.count(s[i])) umap[s[i]] = min(i+1,umap[s[i]]);
            else umap[s[i]] = i+1;
        }
    }
    for(auto s : targets){
        int ans = 0;
        for(auto c : s){
            if(!umap.count(c)){
                ans = -1;
                break;
            }
            ans += umap[c];
        }
        answer.push_back(ans);
    }
    return answer;
}