#include <string>
#include <vector>

using namespace std;
bool countM(int x);
int solution(int left, int right) {
    int sum = 0;
    for(int i=left; i<= right; i++){
       if(countM(i)) sum += i;
        else sum-=i;
    }
    return sum;
}

bool countM(int x){
    int count = 0;
    for(int i=1; i<=x/2; i++){
        if(!(x%i)) count++;
    }
    return count%2;
}