#include <string>
#include <vector>
#include <algorithm>
#include <iostream>

using namespace std;

int solution(int k, vector<int> tangerine) {
    vector<int> arr(100001,0);
    int index = 0;
    sort(tangerine.begin(), tangerine.end());
    int cur = tangerine[0];
    for(int v : tangerine){
        if(cur == v) arr[index]++;
        else{
            cur = v;
            index++;
            arr[index]++;
        }
    }
    sort(arr.rbegin(), arr.rend());
    int cnt = 0;
    while(k>0){
        cout << arr[cnt] << " ";
        k-=arr[cnt];
        cnt++;
    }
    return cnt;
}