#include <string>
#include <vector>
#include <algorithm>

using namespace std;

vector<int> solution(vector<int> arr) {
    int index = 0;
    int min = 1999999999;
    for(int i=0; i<arr.size(); i++){
        if(arr[i] < min){
            min = arr[i];
            index = i;
        }
    }
    arr.erase(arr.begin() + index);
    return arr.empty() ? vector<int>(1,-1) : arr;
}