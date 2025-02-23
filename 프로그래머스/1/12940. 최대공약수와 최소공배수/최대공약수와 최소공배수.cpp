#include <string>
#include <vector>

using namespace std;
int gcd(int a, int b){
    if(b == 0) return a;
    return gcd(b,a%b);
}
int lcm(int a, int b){
    return a*b/gcd(a,b);
}
vector<int> solution(int n, int m){
    return {gcd(n,m),lcm(n,m)};
}