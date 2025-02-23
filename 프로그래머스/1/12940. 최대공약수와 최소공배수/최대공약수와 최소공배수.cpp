#include <string>
#include <vector>

using namespace std;
int gcd(int a, int b){
    return b ? gcd(b,a%b) : a;
}
vector<int> solution(int n, int m){
    return {gcd(n,m),n*m/gcd(n,m)};
}