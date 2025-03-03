#include <vector>
#include <iostream>
#include <cmath>
using namespace std;
int R = 3;
int selected[3] = {};
int result = 0;
bool arr[3001] = {};
bool check[3001] = {};
void 조합(int start, int cnt, vector<int> nums){
    if(cnt == R){
        int sum = 0;
        for(int i=0; i<R; i++){
            sum += selected[i];
        }
        if(!arr[sum] && !check[sum]) {
            result++;
        }
        return;    
    }
    for(int i=start; i<nums.size(); i++){
        selected[cnt] = nums[i];
        조합(i+1, cnt+1, nums);
    }
}

int solution(vector<int> nums) {
    for(int i=2; i<=sqrt(3000); i++){
        for(int j=i*2; j<=3000; j+=i){
            arr[j] = true;
        }
    }
    조합(0,0,nums);
    return result;
}