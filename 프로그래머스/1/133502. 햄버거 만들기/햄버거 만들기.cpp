#include <string>
#include <vector>
#include <iostream>
using namespace std;
int arr[4] = {1,2,3,1};
int solution(vector<int> ingredient) {
    int ans = 0;
    vector<int> bugi;
    for(int i=0; i<ingredient.size(); i++){
        bugi.push_back(ingredient[i]);
        if(bugi.size() >= 4){
            int cnt = 0;
            for(int j=bugi.size()-4; j<bugi.size(); j++){
                if(bugi[j] == arr[j-bugi.size()+4]) cnt++;
            }
            if(cnt==4) {
                ans++;
                for(int i=0; i<4; i++) bugi.pop_back();
            }
        }
        
    }
    return ans;
}